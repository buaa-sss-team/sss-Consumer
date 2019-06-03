package com.sss.consumer;

import com.sss.interfaces.IESService;
import com.sss.interfaces.dao.IHDBdao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TestESService {

    public static void main(String []args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-consumer.xml");
        IESService hesservice=ctx.getBean(IESService.class);
        //List<Map<String, Object>> res = hesservice.FuzzyQueryAbstract("paper","abstract","test");
        //for (Map<String, Object> now:res) {
        //    System.out.println(now.toString());
        //}
        System.out.println("END!!!!!!!!!!!!!!!!!");
    }
}
