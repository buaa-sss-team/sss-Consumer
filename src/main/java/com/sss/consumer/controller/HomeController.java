package com.sss.consumer.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;

@Controller
@SessionAttributes("currentUserName")
public class HomeController extends CommonPageController{

    @RequestMapping(value = "/")
    public ModelAndView get(ModelMap m,@ModelAttribute("currentUserName")String currentUserName) throws ServletException, IOException {

        ModelAndView mv=super.get(m,"home",currentUserName);

        return mv;
    }
}
