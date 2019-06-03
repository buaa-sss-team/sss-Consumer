package com.sss.consumer;

import com.sss.interfaces.IESService;
import com.sss.interfaces.dao.IHDBdao;
import javafx.util.Pair;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestESService {

    public static void main(String []args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-consumer.xml");
        IESService hesservice=ctx.getBean(IESService.class);

        List<Pair<String, List<Pair<String, Pair<String, String>>>>> limits = new LinkedList<Pair<String, List<Pair<String, Pair<String, String>>>>>();
        LinkedList<Pair<String, Pair<String, String>>> fir=new LinkedList<Pair<String, Pair<String, String>>>();
        fir.add(new Pair("instruction",new Pair("matchQuery","sss")));
        limits.add(new Pair("abstract",fir));
        List<Map<String, Object>> res = hesservice.Query("paper",limits, 100);
        if (res == null) {
            System.out.println("数据获取失败");
            return;
        }
        for (Map<String, Object> now : res) {
            System.out.println(now.toString());
        }

        System.out.println("END!!!!!!!!!!!!!!!!!");
    }
}
