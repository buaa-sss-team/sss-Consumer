package com.yuyuyzl.SSS.web;

import com.yuyuyzl.SSS.ITestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class staticTest {
    public static int i=0;
    public static ITestService testService;
    public static void init(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        testService = ctx.getBean(ITestService.class);
    }
}
