package com.sss.consumer.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sss.consumer.DubboServices;
import com.sss.interfaces.hmodel.Paper;
import com.sss.interfaces.hmodel.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class buyController extends CommonPageController{
    @RequestMapping(value = "/buy/{restype}/{resid}")
    public ModelAndView get(ModelMap m, HttpSession session, @PathVariable String restype, @PathVariable String resid) throws ServletException, IOException {

        ModelAndView mv=super.get(m,"confirmbuyres",session);
        User user= DubboServices.INSTANCE.commonService.getUserInfo((String)session.getAttribute("currentUserName"));
        mv.addObject("user", user);

        String resname="";
        int price=0;
        if(restype.equals("paper")){
            Paper paper=DubboServices.INSTANCE.commonService.getPaperInfo(Integer.valueOf(resid));
            resname=paper.getTitle();
            price=paper.getCost();
        }

        mv.addObject("resname",resname);
        mv.addObject("amount",price);
        return mv;
    }

    @RequestMapping(value = "/buy/{restype}/{resid}" , method = RequestMethod.POST)
    public String post(ModelMap m, @RequestParam("password") String password, HttpSession session, @PathVariable String restype, @PathVariable String resid) throws ServletException, IOException {
        User user=DubboServices.INSTANCE.commonService.getUserInfo((String)session.getAttribute("currentUserName"));
        if(password.equals(user.getPassword())) {
            Gson gson=new Gson();
            JsonArray bought;
            int price=0;
            if(restype.equals("paper")){
                Paper paper=DubboServices.INSTANCE.commonService.getPaperInfo(Integer.valueOf(resid));
                price=paper.getCost();
            }
            try {
                bought=gson.fromJson(user.getBoughtThings(), JsonArray.class);
            }catch (Exception e){
                bought=new JsonArray();
            }
            if(bought==null)bought=new JsonArray();
            bought.add(resid);
            user.setBoughtThings(gson.toJson(bought));
            user.setCredit(user.getCredit()-price);


            if (DubboServices.INSTANCE.commonService.updateUserInfo(user) == 0) {
                return "redirect:/account?alert=OK";
            }
        }
        return "redirect:/account?alert=Failed";
    }

}
