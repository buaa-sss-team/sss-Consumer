package com.sss.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public ModelAndView test(ModelMap m) throws ServletException, IOException {

        ModelAndView mv = new ModelAndView("home");

        return mv;
    }
}
