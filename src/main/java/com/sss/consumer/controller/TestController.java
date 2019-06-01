package com.sss.consumer.controller;

import com.sss.interfaces.IDBService;
import com.sss.interfaces.model.*;
import com.sss.interfaces.model.TestUser;
import com.sss.interfaces.ITestUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;

@Controller
//@RequestMapping("/")
public class TestController {
    //@Reference注入的是分布式中的远程服务对象，@Resource和@Autowired注入的是本地spring容器中的对象。
    @com.alibaba.dubbo.config.annotation.Reference
    private IDBService idbService;

    @RequestMapping(value = "/test" , method = RequestMethod.GET)
    public ModelAndView test(ModelMap m ,@RequestParam("name_id") int id) throws ServletException, IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-consumer.xml");
        idbService = ctx.getBean(IDBService.class);
        user user = idbService.queryUser(id);
        ModelAndView mv = new ModelAndView("test");
        mv.addObject("account",user.getName());
        mv.addObject("pwd",user.getPassword());

        return mv;
    }
}
