package com.sss.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sss.interfaces.dao.IHDBdao;
import com.sss.interfaces.hmodel.Paper;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class AddData {
    private static Logger logger = LoggerFactory.getLogger(AddData.class);
    //插入论文
    public static void addPaper(){
        String path="D:\\temp\\data\\aminer_papers_2.txt";      //读入路径
        String wpath="D:\\temp\\data\\paper_1k.txt";            //输出路径

        File f=new File(path);
        BufferedReader reader=null;
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-consumer.xml");
        IHDBdao hdbdao=ctx.getBean(IHDBdao.class);
        try{
            FileWriter writer=new FileWriter(wpath,false);
            FileReader tem=new FileReader(f);
            reader =new BufferedReader(tem);
            String tempString=null;
            int line=0;
            int MOD=233,now=133;
            int cnt=0;
            while(cnt<10){
                ++line;
                tempString=reader.readLine();
                logger.info(tempString);
                Paper x=new Paper();


                JSONObject obj=JSON.parseObject(tempString);

                //清洗数据 过滤掉比较重要却为空的
                if(!obj.keySet().contains("abstract"))continue;
                if(!obj.keySet().contains("title"))continue;
                if(!obj.keySet().contains("authors"))continue;
                if(!obj.keySet().contains("url"))continue;
                if(!obj.keySet().contains("keywords"))continue;

                //abstract
                x.setAbs(obj.getString("abstract"));
                //authorID
                x.setAuthorId(obj.getJSONArray("authors").toJSONString());

                //c_number
                x.setcNumber(obj.getInteger("n_citation"));
                //cost
                x.setCost(now);
                //doc_type
                x.setDocType(obj.getString("doc_type"));
                //ISBN
                x.setIsbn(obj.getString("isbn"));
                //ISSN
                x.setIssn(obj.getString("issn"));
                //issue
                x.setIssue(obj.getString("issue"));
                //key_words
                x.setKeywords(obj.getJSONArray("keywords").toJSONString());
                //title
                x.setTitle(obj.getString("title"));
                //url
                x.setUrl(obj.getString("url"));
                //publisher
                x.setPublisher(obj.getString("publisher"));
                //language
                x.setLang(obj.getString("lang"));
                //org
                x.setOrg(obj.getString("venue"));
                //volume
                x.setVolume(obj.getString("volume"));
                //year
                x.setYear(obj.getInteger("year"));

                if(!x.getLang().equals("en"))continue;

                logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!");
                ++cnt;
                hdbdao.insert(x);
                System.out.println(tempString);
                //writer.write(tempString+"\r\n\r\n");
                now=now*2%MOD;
            }
            System.out.println(cnt);
            writer.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        addPaper();
        //String path="D:\\temp\\data\\paper_1k.txt";
        /*              文件路径                    */
       // String path="D:\\temp\\data\\paper_1k-backup.txt";




    }
}
