package com.sss.consumer.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.sss.consumer.DubboServices;
import com.sss.interfaces.hmodel.Paper;
import com.sss.interfaces.hmodel.Patent;
import com.sss.interfaces.hmodel.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

@Controller
public class boughtThingsController extends CommonPageController{
    @RequestMapping(value = "/bought")
    public ModelAndView get(ModelMap m, HttpSession session) throws ServletException, IOException {

        ModelAndView mv=super.get(m,"boughtThings",session);
        User user= DubboServices.INSTANCE.commonService.getUserInfo((String)session.getAttribute("currentUserName"));

        Gson gson=new Gson();
        JsonArray boughtItems=gson.fromJson(user.getBoughtThings(),JsonArray.class);
        ArrayList<Paper> papers=new ArrayList<Paper>();
        ArrayList<Patent> patents=new ArrayList<Patent>();
        ArrayList<Integer> index=new ArrayList<Integer>();
        for(int i=0;i<boughtItems.size();i++){
            if(boughtItems.get(i).getAsJsonObject().get("type").getAsString().equals("paper")){
                papers.add(DubboServices.INSTANCE.commonService.getPaperInfo(boughtItems.get(i).getAsJsonObject().get("id").getAsInt()));
                index.add(papers.size()*2-2);
            }
            if(boughtItems.get(i).getAsJsonObject().get("type").getAsString().equals("patent")){
                patents.add(DubboServices.INSTANCE.commonService.getPatentInfo(boughtItems.get(i).getAsJsonObject().get("id").getAsInt()));
                index.add(patents.size()*2-1);
            }
        }
        mv.addObject("papers",papers);
        mv.addObject("index",index);
        mv.addObject("patents",patents);


        return mv;
    }

}
