package com.sss.consumer.controller;

import com.sss.interfaces.hmodel.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;


@Controller
@SessionAttributes("currentUserName")
public class CommonPageController {

    @ModelAttribute("currentUserName")
    public String initCUN(){
        return "";
    }

    public ModelAndView get(ModelMap m,String viewName,String currentUserName) throws ServletException, IOException {

        ModelAndView mv = new ModelAndView(viewName);
        if(currentUserName.length()>0) {
            User user = new User();
            user.setName(currentUserName);
            mv.addObject("user",user);
        }else mv.addObject("user",null);
        return mv;
    }
}
