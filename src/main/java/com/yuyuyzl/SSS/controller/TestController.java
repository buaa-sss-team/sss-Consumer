package com.yuyuyzl.SSS.controller;

import com.sun.jmx.snmp.SnmpUnknownModelLcdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class TestController {
    @RequestMapping(value = "/test" , method = RequestMethod.GET)
    public ModelAndView test(HttpServletRequest hr) {
        ModelAndView view = new ModelAndView("test");
        view.addObject("param","success!");
        return view;
    }
}
