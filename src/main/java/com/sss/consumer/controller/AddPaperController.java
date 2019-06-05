package com.sss.consumer.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sss.consumer.DubboServices;
import com.sss.consumer.FileUtil;
import com.sss.interfaces.hmodel.Expert;
import com.sss.interfaces.hmodel.Paper;
import com.sss.interfaces.hmodel.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.sss.consumer.FileUtil.FileUpload;

@Controller
public class AddPaperController extends CommonPageController {
    @RequestMapping(value = "/addpaper")
    public ModelAndView get(ModelMap m, HttpSession session) throws ServletException, IOException {

        if(session.getAttribute("currentUserName")==null || session.getAttribute("currentUserName").equals(""))
            return new ModelAndView("redirect:/login?alert=LoginFirst");
        ModelAndView mv=super.get(m,"addPaper",session);
        User user= DubboServices.INSTANCE.commonService.getUserInfo((String)session.getAttribute("currentUserName"));
        if(user.getType()<=0)return new ModelAndView("redirect:/login?alert=LoginFirst");


        return mv;
    }
    @RequestMapping(value = "/addpaper", method = RequestMethod.POST)
    public String post(ModelMap m,
                       @RequestParam("file") MultipartFile file,
                       @RequestParam("paperTitle") String paperTitle,
                       @RequestParam("paperISBN") String paperISBN,
                       @RequestParam("paperCost") String paperCost,
                       @RequestParam("paperYear") String paperYear,
                       @RequestParam("paperOrg") String paperOrg,
                       @RequestParam("paperAuthors") String paperAuthors,
                       @RequestParam("paperAbs") String paperAbs,
                       @RequestParam("password") String password,
                       HttpSession session) throws ServletException, IOException {

        User user= DubboServices.INSTANCE.commonService.getUserInfo((String)session.getAttribute("currentUserName"));
        Expert expert=DubboServices.INSTANCE.commonService.getExpertInfo(user.getType());
        Paper paper=new Paper();
        paper.setAbs(paperAbs);
        paper.setTitle(paperTitle);
        paper.setIsbn(paperISBN);
        paper.setCost(Integer.valueOf(paperCost));
        paper.setYear(Integer.valueOf(paperYear));
        paper.setOrg("'{\"raw\":\""+paperOrg+"\"}'");
        Gson gson=new Gson();
        JsonArray authors=new JsonArray();
        JsonObject object=new JsonObject();
        object.addProperty("name",expert.getName());
        authors.add(object);
        for(String s:paperAuthors.split("\\|")){
            if(s.length()>0) {
                object = new JsonObject();
                object.addProperty("name", s);
                authors.add(object);
            }
        }
        paper.setAuthorId(gson.toJson(authors));
        int id=DubboServices.INSTANCE.commonService.insertPaper(paper);

        if(id>0)paper.setId(id);

        String filename=FileUtil.FileUpload(file,"paper");

        String url="[\"/paper/"+String.valueOf(id)+"/download/"+filename+"\"]";

        paper.setUrl(url);

        DubboServices.INSTANCE.commonService.update(paper);
        JsonArray bought;
        JsonObject itemBought=new JsonObject();
        try {
            bought=gson.fromJson(user.getBoughtThings(), JsonArray.class);
        }catch (Exception e){
            bought=new JsonArray();
        }
        if(bought==null)bought=new JsonArray();
        itemBought.addProperty("type","paper");
        itemBought.addProperty("id",Integer.valueOf(id));
        bought.add(itemBought);
        user.setBoughtThings(gson.toJson(bought));
        DubboServices.INSTANCE.commonService.updateUserInfo(user);

        return "redirect:/bought";
    }
}
