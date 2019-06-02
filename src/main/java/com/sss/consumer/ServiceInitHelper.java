package com.sss.consumer;

import com.sss.interfaces.IDBService;
import com.sss.interfaces.ITestService;
import com.sss.interfaces.dao.IHDBdao;
import com.sss.interfaces.service.Authorization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServiceInitHelper implements ServletContextListener {

    public static void init(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-consumer.xml");
        DubboServices.INSTANCE.dbService= ctx.getBean(IDBService.class);
        DubboServices.INSTANCE.hdbDAO= ctx.getBean(IHDBdao.class);
        DubboServices.INSTANCE.authorization= ctx.getBean(Authorization.class);
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        init();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
