package com.yuyuyzl.SSS.controller;

import com.sun.jmx.snmp.SnmpUnknownModelLcdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class TestController {
    @RequestMapping(value = "/test" , method = RequestMethod.GET)
    public ModelAndView test(ModelMap m ,@RequestParam("name") String temp) throws ServletException, IOException {
        ModelAndView mv = new ModelAndView("test");
        mv.addObject("front",temp);
        mv.addObject("back","success!");
        return mv;
    }
}
