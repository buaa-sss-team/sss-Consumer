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
public class AccountInfoController extends CommonPageController{
    @RequestMapping(value = "/account")
    public ModelAndView get(ModelMap m, HttpSession session) throws ServletException, IOException {

        ModelAndView mv=super.get(m,"account",session);
        User user=DubboServices.INSTANCE.commonService.getUserInfo((String)session.getAttribute("currentUserName"));
        mv.addObject("user", user);
        Gson gson=new Gson();
        JsonObject info=gson.fromJson(user.getInfo(), JsonObject.class);
        mv.addObject("tel",info.get("tel").getAsString());
        mv.addObject("birthday",info.get("birthday").getAsString());
        mv.addObject("org",info.get("org").getAsString());

        return mv;
    }
    @RequestMapping(value = "/purchase")
    public ModelAndView getPurchase(ModelMap m, HttpSession session) throws ServletException, IOException {

        ModelAndView mv=super.get(m,"purchase",session);
        User user=DubboServices.INSTANCE.commonService.getUserInfo((String)session.getAttribute("currentUserName"));
        mv.addObject("user", user);

        return mv;
    }
    @RequestMapping(value = "/purchase", method = RequestMethod.POST)
    public String postPurchase(ModelMap m, HttpSession session,@RequestParam("amount")String amount) throws ServletException, IOException {


        User user=DubboServices.INSTANCE.commonService.getUserInfo((String)session.getAttribute("currentUserName"));


        int amountint=Integer.parseInt(amount);

        user.setCredit(user.getCredit()+amountint);

        DubboServices.INSTANCE.commonService.updateUserInfo(user);

        return "redirect:/account?alert=OK";
    }

    @RequestMapping(value = "/account" , method = RequestMethod.POST)
    public String post(ModelMap m, @RequestParam("password")String password,@RequestParam("newpassword")String newpassword, @RequestParam("tel")String tel, @RequestParam("birthday")String birthday, @RequestParam("org")String org, HttpSession session) throws ServletException, IOException {
        User user=DubboServices.INSTANCE.commonService.getUserInfo((String)session.getAttribute("currentUserName"));
        if(password.equals(user.getPassword())) {
            if(newpassword.length()>0)user.setPassword(newpassword);
            Gson gson = new Gson();
            JsonObject obj = new JsonObject();
            obj.addProperty("tel", tel);
            obj.addProperty("birthday", birthday);
            obj.addProperty("org", org);
            user.setInfo(gson.toJson(obj));


            if (DubboServices.INSTANCE.commonService.updateUserInfo(user) == 0) {
                return "redirect:/account?alert=OK";
            }
        }
        return "redirect:/account?alert=Failed";
    }
}
