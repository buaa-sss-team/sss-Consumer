package com.sss.consumer.controller;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.sss.consumer.DubboServices;
import com.sss.interfaces.hmodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReviewApplicationController extends CommonPageController {

    @RequestMapping(value = "/review")
    public ModelAndView get(ModelMap m, HttpSession session) throws ServletException, IOException {

        ModelAndView mv=super.get(m,"review",session);
        User user= DubboServices.INSTANCE.commonService.getUserInfo((String)session.getAttribute("currentUserName"));

        List<Tobeexpert> tobeexperts = DubboServices.INSTANCE.commonService.checkTobeexpert(0);
        mv.addObject("applist",tobeexperts);
        ArrayList<Map<String,String>> appextra=new ArrayList<Map<String, String>>();
        Gson gson=new Gson();
        for (Tobeexpert app:
             tobeexperts) {
            Map<String, String> extraInfo = (Map<String, String>) gson.fromJson(app.getMessage(), new TypeToken<Map<String, String>>() {
            }.getType());
            User appUser=DubboServices.INSTANCE.commonService.getUserInfo(app.getUserid());
            extraInfo.put("userName",appUser.getAccount());
            Expert expert=DubboServices.INSTANCE.commonService.getExpertInfo(Integer.valueOf(extraInfo.get("expert")));
            extraInfo.put("expertName",expert.getName());

            appextra.add(extraInfo);

        }
        mv.addObject("appextra",appextra);
        return mv;
    }

    @RequestMapping(value = "/review/{id}/{action}")
    public String action(ModelMap m, HttpSession session, @PathVariable String id, @PathVariable String action) throws ServletException, IOException {
        List<Tobeexpert> tobeexperts = DubboServices.INSTANCE.commonService.checkTobeexpert(0);
        int idint=Integer.parseInt(id);
        Tobeexpert app=null;
        for (Tobeexpert x :
                tobeexperts) {
            if(x.getId()==idint)app=x;
        }
        if (app!=null) {
            if(action.equals("a")) {
                Gson gson = new Gson();
                Map<String, String> extraInfo = (Map<String, String>) gson.fromJson(app.getMessage(), new TypeToken<Map<String, String>>() {
                }.getType());
                User appUser = DubboServices.INSTANCE.commonService.getUserInfo(app.getUserid());
                appUser.setType(Integer.valueOf(extraInfo.get("expert")));
                DubboServices.INSTANCE.commonService.updateUserInfo(appUser);
                app.setStatus(1);
            }else {
                app.setStatus(-1);
            }
            DubboServices.INSTANCE.commonService.update(app);
        }
        return "redirect:/review";
    }
}
