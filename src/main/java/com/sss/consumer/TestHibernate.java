package com.sss.consumer;

import com.sss.interfaces.dao.IHDBdao;
import com.sss.interfaces.hmodel.User;
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
        IHDBdao hdbdao=ctx.getBean(IHDBdao.class);

        User x=new User();
        x.setId(1);
        x.setAccount("6.3test");
        x.setPassword("nope");
        x.setInfo("hello");
        x.setType(1);
        x.setCredit(1);
        hdbdao.insert(x);

    }
}
