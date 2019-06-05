package com.sss.consumer;

import com.sss.interfaces.dao.IHDBdao;
import com.sss.interfaces.hmodel.User;
import com.sss.interfaces.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.List;

public class TestHibernate {
    private static Logger logger = LoggerFactory.getLogger(TestHibernate.class);
    public static void main(String args[]){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-consumer.xml");
        CommonService commonService = ctx.getBean(CommonService.class);
        User x=(User)commonService.getUserInfo(5);
        logger.info("Account:"+x.getAccount()+"    Password:"+x.getPassword());
        /*
        x.setId(1);
        x.setAccount("6.3test2");
        x.setPassword("nope");
        //x.setInfo("hello");
        x.setType(1);
        x.setCredit(1);
        hdbdao.insert(x);
        */

    }
}

