package com.sss.consumer.controller;

import com.sss.consumer.DubboServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class ResourcesPageController extends CommonPageController{
    @RequestMapping(value = "/paper/{id}", method = RequestMethod.GET)
    public ModelAndView getPaper(ModelMap m, @PathVariable String id, HttpSession session)throws ServletException, IOException {
        ModelAndView mv=get(m,"paper",session);
        mv.addObject("paper", DubboServices.INSTANCE.commonService.getPaperInfo(Integer.valueOf(id)));
        return mv;

    }
}
