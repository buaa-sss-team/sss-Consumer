package com.yuyuyzl.SSS;

import com.yuyuyzl.SSS.models.user;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class TestDBServiceConsumer {
    private static Logger logger = LoggerFactory.getLogger(TestDBServiceConsumer.class);
    public static void main(String []args)throws SQLException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        IDBService testService =ctx.getBean(IDBService.class);
        user tem=new user();
        tem.setId(2);
        tem.setName("wjy2");
        tem.setPassword("wangjiayi");
        tem.setPersonalInformationJson("nope");
        tem.setBoughtThings("nope");
        tem.setCredit(100);

        logger.info("执行结果："+testService.addUser(tem) );

        testService.delUser(1);
        tem=testService.queryUser(2);
        logger.info("第一个查询结果的name"+tem.getName());
        tem.setName("hahaha");
        testService.updateUser(tem);
        tem=testService.queryUser(2);
        logger.info("第二个查询结果的name"+tem.getName());

    }
}


