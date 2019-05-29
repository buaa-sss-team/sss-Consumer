package com.yuyuyzl.SSS;

import com.yuyuyzl.SSS.ITestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestServiceConsumer {
    private static Logger logger = LoggerFactory.getLogger(TestServiceConsumer.class);
    public ITestService bean;

    public static void main(String args[]) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        ITestService testService = ctx.getBean(ITestService.class);
        logger.info("执行结果：" + testService.login("你好", "密码"));

        List<Map<String,String>> lm= testService.getListMapTest().getLm();
        for(Map<String,String> m: lm){
            Iterator<Map.Entry<String,String>> it=m.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry<String,String> e=it.next();
                logger.info("--------------"+e.getKey()+" "+e.getValue());
            }
        }
    }
}
