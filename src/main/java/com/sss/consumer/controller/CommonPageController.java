package com.sss.consumer.controller;

import com.sss.consumer.DubboServices;
import com.sss.interfaces.hmodel.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class CommonPageController {



    public ModelAndView get(ModelMap m, String viewName, HttpSession session) throws ServletException, IOException {

        ModelAndView mv = new ModelAndView(viewName);
        String currentUserName= (String) session.getAttribute("currentUserName");
        if(currentUserName!=null && currentUserName.length()>0) {
            User user= DubboServices.INSTANCE.commonService.getUserInfo((String)session.getAttribute("currentUserName"));
            mv.addObject("user",user);
        }else mv.addObject("user",null);
        return mv;
    }


}
