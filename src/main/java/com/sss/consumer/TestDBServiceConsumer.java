package com.sss.consumer;

import com.sss.interfaces.model.*;
import com.sss.interfaces.IDBService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

public class TestDBServiceConsumer {
    private static Logger logger = LoggerFactory.getLogger(TestDBServiceConsumer.class);

    public static void main(String []args)throws SQLException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        IDBService testService =ctx.getBean(IDBService.class);
        user tem=new user();
        tem.setId(1);
        tem.setName("wjy2");
        tem.setPassword("wangjiayi");
        tem.setPersonalInformationJson("nope");
        tem.setBoughtThings("nope");
        tem.setCredit(100);

        logger.info("执行结果："+testService.addUser(tem) );

        //testService.delUser(1);
        tem=testService.queryUser(1);
        logger.info("第一个查询结果的name:"+tem.getName());
        tem.setName("hahaha");
        testService.updateUser(tem);
        tem=testService.queryUser(1);
        logger.info("第二个查询结果的name:"+tem.getName());

        //expert表
        logger.info("开始测试expert表");
        expert ex=new expert();
        ex.setId(1);
        ex.setSearchPopularity(200);
        ex.setAchievement("123");
        ex.setProfession("123");
        logger.info("执行结果："+testService.addExpert(ex));

        ex=testService.queryExpert(1);
        testService.queryExpert(1);
        logger.info("expertAchievement:"+ex.getAchievement());
        ex.setAchievement("new_achi");
        testService.updateExpert(ex);
        logger.info("new_achievement："+testService.queryExpert(1).getAchievement());

        logger.info("测试管理员表");
        administrator adm=new administrator(1,"zyz","123","456");
        testService.addAdministrator(adm);
        adm=testService.queryAdministrator(1);
        testService.updateAdministrator(adm);
        //testService.delAdministrator(1);
        logger.info("finished");

        logger.info("测试科技资源表");
        scientificRes sci=new scientificRes("123",1,"haha",80,80,"abc","abcd","www");
        testService.addScientificRes(sci);
        sci=testService.queryScientificRes(1);
        testService.updateScientificRes(sci);
        //testService.delScientificRes(1);
        logger.info("finished");

        logger.info("测试专利表");
        patent pat=new patent(1,1,"sci");
        testService.addPatent(pat);
        pat=testService.queryPatent(1);
        testService.updatePatent(pat);
        //testService.delPatent(1);
        logger.info("finished");

        logger.info("测试论文表");
        paper pap=new paper(1,"123","sci");
        testService.addPaper(pap);
        pap=testService.queryPaper(1);
        testService.updatePaper(pap);
        //testService.delPaper(1);
        logger.info("finished");

        logger.info("测试审核信息表");
        Time t=new Time(8,57,12);
        auditapplication aud=new auditapplication(1,1,1,t,1);
        testService.addAuditapplicayion(aud);
        aud=testService.queryAuditapplication(1);
        testService.updateAuditapplication(aud);
        //testService.delAuditapplication(1);
        logger.info("finished");

        logger.info("测试入驻信息");
        settleIn se=new settleIn(1,"123");
        testService.addSettleIn(se);
        testService.querySettleIn(1);
        testService.updateSettleIn(se);
        //testService.delSettleIn(1);
        logger.info("finished");

        logger.info("测试购买文献表");
        buyRes buy=new buyRes(1,1,20);
        testService.addBuyRes(buy);
        testService.queryBuyRes(1);
        testService.updateBuyRes(buy);
        logger.info("finished");

        logger.info("测试现金业务");
        payment pay=new payment(1,20,1);
        testService.addPayment(pay);
        testService.queryPayment(1);
        testService.updatePayment(pay);
        logger.info("finished");

        logger.info("测试修改科技资源");
        modifySciRes mo=new modifySciRes(1,1,1);
        testService.addModifySciRes(mo);
        testService.updateModifySciRes(mo);
        testService.queryModifySciRes(1);
        logger.info("finished");

        logger.info("测试已购买资源");
        boughtScientificRes bo=new boughtScientificRes(1,"123","123");
        testService.addBoughtScientificRes(bo);
        testService.updateBoughtScientificRes(bo);
        testService.queryBoughtScientificRes(1);
        logger.info("finished");

        logger.info("transaction");
        transaction tr=new transaction(1,1,1,1,t);
        testService.addTransaction(tr);
        testService.updateTransaction(tr);
        testService.queryTransaction(1);
        logger.info("finished");

        Timestamp tis=new Timestamp(2019,5,22,17,7,20,0);
        logger.info("测试日志");
        Logs log=new Logs(tis,"123");
        testService.addLogs(log);
        testService.updateLogs(log);
        testService.queryLogs(tis);
        log.setInfo("finished");

        logger.info("测试私信");
        message me=new message(1,1,1,"123",t);
        testService.addMessage(me);
        testService.updateMessage(me);
        testService.queryMessage(1);
        logger.info("finished");

        logger.info("测试标签");
        tags tag=new tags("123");
        testService.addTags(tag);
        logger.info("finished");

        logger.info("测试专家标签");
        expertTag ext=new expertTag(1,"123");
        testService.addExpertTag(ext);
        testService.updateExpertTag(ext);
        testService.queryExpertTag(1);
        logger.info("finished");

        logger.info("测试科技资源标签");
        scientificResTag sct=new scientificResTag(1,"123");
        testService.addScientificResTag(sct);
        testService.updateScientificResTag(sct);
        testService.queryScientificResTag(1);
        logger.info("finished");

    }
}


