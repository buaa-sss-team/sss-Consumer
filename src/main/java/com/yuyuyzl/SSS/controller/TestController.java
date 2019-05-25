package com.yuyuyzl.SSS.controller;

import com.sun.jmx.snmp.SnmpUnknownModelLcdException;
import com.yuyuyzl.SSS.model.User;
import com.yuyuyzl.SSS.service.TestUserService;
import com.yuyuyzl.SSS.service.imp.TestUserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


import java.util.List;

@Controller
@RequestMapping("/")
public class TestController {
    @Autowired
    private TestUserService userService;

    @RequestMapping(value = "/test" , method = RequestMethod.GET)
    public ModelAndView test(ModelMap m ,@RequestParam("name_id") int id) throws ServletException, IOException {
        ModelAndView mv = new ModelAndView("test");
        User user = userService.getUser(id);
        mv.addObject("account",user.getAccount());
        mv.addObject("pwd",user.getPwd());
        return mv;
    }
}
