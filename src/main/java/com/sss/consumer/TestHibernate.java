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
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        IHDBdao hdbdao=ctx.getBean(IHDBdao.class);

        User x=new User();
        x.setId(1);
        x.setName("LiMing");
        x.setBoughtThings("");
        x.setCredit(40);
        x.setPassword("Safe");
        x.setPersonalInformationJson("");
        hdbdao.insert(x);
       // hdbdao.insertUser(x);

        x.setId(3);
        x.setName("LiMing");
        hdbdao.insert(x);
        //hdbdao.insertUser(x);


        List<User> z;
        z=hdbdao.getUserByName("LiMing");
        logger.info("#######################输出结果:#####################");
        Iterator<User>it=z.iterator();
        while(it.hasNext()){
            Integer tem=it.next().getId();
            logger.info(tem.toString());
        }

        User y=(User)hdbdao.getByID(User.class,1);
        logger.info(y.getName());
        logger.info(y.getPassword());

    }
}
