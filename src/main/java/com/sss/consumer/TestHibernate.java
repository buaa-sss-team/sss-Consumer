package com.sss.consumer;

import com.sss.interfaces.dao.IHDBdao;
import com.sss.interfaces.hmodel.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHibernate {
    private static Logger logger = LoggerFactory.getLogger(TestHibernate.class);
    public static void main(String args[]){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        IHDBdao hdbdao=ctx.getBean(IHDBdao.class);
        hdbdao.init();
        User x=new User();
        x.setId(1);
        x.setName("LiMing");
        x.setBoughtThings("");
        x.setCredit(40);
        x.setPassword("Safe");
        x.setPersonalInformationJson("");
        hdbdao.insertUser(x);
    }
}
