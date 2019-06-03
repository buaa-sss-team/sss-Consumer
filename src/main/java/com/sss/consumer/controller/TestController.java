package com.sss.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sss.consumer.DubboServices;
import com.sss.interfaces.IDBService;
import com.sss.interfaces.dao.IHDBdao;
import com.sss.interfaces.hmodel.User;
import com.sss.interfaces.model.*;
import com.sss.interfaces.model.TestUser;
import com.sss.interfaces.ITestUserService;
import com.sss.interfaces.service.CommonService;
import com.sss.interfaces.service.InquireService;
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
    //@com.alibaba.dubbo.config.annotation.Reference
    @com.alibaba.dubbo.config.annotation.Reference
    private CommonService service;
    @Reference
    private IHDBdao ihdBdao;
    @RequestMapping(value = "/test" , method = RequestMethod.GET)
    public ModelAndView test(ModelMap m ,@RequestParam("name_id") int id) throws ServletException, IOException {
        user user = DubboServices.INSTANCE.dbService.queryUser(id);
        ModelAndView mv = new ModelAndView("test");
        mv.addObject("account",user.getName());
        mv.addObject("pwd",user.getPassword());
        return mv;
    }

    @RequestMapping(value = "/test2" , method = RequestMethod.GET)
    public ModelAndView test2(ModelMap m ,@RequestParam("name_id") int id) throws ServletException, IOException {
        ModelAndView mv = new ModelAndView("test");
        if (service != null){
            User user = service.getUserInfo(1);
            int temp = ihdBdao.delete(user);
            mv.addObject("account",temp);
            mv.addObject("pwd",temp);
        }
        return mv;
    }
}
