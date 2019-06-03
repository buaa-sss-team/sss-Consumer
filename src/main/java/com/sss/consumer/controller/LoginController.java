package com.sss.consumer.controller;

import com.sss.consumer.DubboServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {
    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public ModelAndView get(ModelMap m) throws ServletException, IOException {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public String post(ModelMap m, @RequestParam("username")String userName, @RequestParam("password")String password, HttpSession session) throws ServletException, IOException {
        if(DubboServices.INSTANCE.authorization.userLogin(userName,password)==0){
            session.setAttribute("currentUserName",userName);
            return "redirect:/";
        }

        return "redirect:/login?alert=Failed";
    }

}
