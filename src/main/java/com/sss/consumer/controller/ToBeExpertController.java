package com.sss.consumer.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sss.consumer.DubboServices;
import com.sss.interfaces.hmodel.Expert;
import com.sss.interfaces.hmodel.Tobeexpert;
import com.sss.interfaces.hmodel.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class ToBeExpertController extends CommonPageController {
    @RequestMapping(value = "/tobeexpert/{expertid}")
    public ModelAndView get(ModelMap m, HttpSession session, @PathVariable String expertid) throws ServletException, IOException {
        if(session.getAttribute("currentUserName")==null || session.getAttribute("currentUserName").equals(""))
            return new ModelAndView("redirect:/login?alert=LoginFirst");

        ModelAndView mv=super.get(m,"tobeexpert",session);
        User user= DubboServices.INSTANCE.commonService.getUserInfo((String)session.getAttribute("currentUserName"));
        mv.addObject("user", user);
        Expert expert=DubboServices.INSTANCE.commonService.getExpertInfo(Integer.valueOf(expertid));
        mv.addObject("expert",expert);
        return mv;
    }
    @RequestMapping(value = "/tobeexpert/{expertid}", method = RequestMethod.POST)
    public String post(ModelMap m, HttpSession session, @PathVariable String expertid, @RequestParam("password")String password,@RequestParam("personalIdNumber")String personalIdNumber, @RequestParam("message")String message) throws ServletException, IOException {

        User user=DubboServices.INSTANCE.commonService.getUserInfo((String)session.getAttribute("currentUserName"));
        if(password.equals(user.getPassword())) {
            Tobeexpert appli=new Tobeexpert();
            appli.setUserid(user.getId());
            appli.setStatus(0);

            Gson gson = new Gson();
            JsonObject obj = new JsonObject();
            obj.addProperty("expert",expertid);
            obj.addProperty("message",message);
            obj.addProperty("PersonalIdNumber",personalIdNumber);
            appli.setMessage(gson.toJson(obj));


            if (DubboServices.INSTANCE.commonService.reqForExpert(appli) == 0) {
                return "redirect:/tobeexpert/"+expertid+"?alert=OK";
            }
        }
        return "redirect:/tobeexpert/"+expertid+"?alert=Failed";
    }
}
