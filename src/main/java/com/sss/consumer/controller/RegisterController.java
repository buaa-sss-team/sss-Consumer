package com.sss.consumer.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sss.consumer.DubboServices;
import com.sss.interfaces.hmodel.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class RegisterController extends CommonPageController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView get(ModelMap m, HttpSession session) throws ServletException, IOException {

        ModelAndView mv=super.get(m,"register",session);

        return mv;
    }

    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public String post(ModelMap m, @RequestParam("username")String userName, @RequestParam("password")String password, @RequestParam("tel")String tel, @RequestParam("birthday")String birthday, @RequestParam("org")String org, HttpSession session) throws ServletException, IOException {
        User user=new User();
        user.setAccount(userName);
        user.setPassword(password);
        Gson gson=new Gson();
        JsonObject obj=new JsonObject();
        obj.addProperty("tel",tel);
        obj.addProperty("birthday",birthday);
        obj.addProperty("org",org);
        user.setInfo(gson.toJson(obj));
        user.setType(1);

        if(DubboServices.INSTANCE.commonService.userSignIn(user)==0){
            session.setAttribute("currentUserName",userName);
            return "redirect:/";
        }

        return "redirect:/register?alert=Failed";
    }

}
