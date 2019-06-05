package com.sss.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sss.interfaces.dao.IHDBdao;
import com.sss.interfaces.hmodel.Expert;
import com.sss.interfaces.hmodel.Paper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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
            while(true){
            //while(cnt<10000){
                ++line;
                tempString=reader.readLine();
                if(tempString==null)break;
                //logger.info(tempString);
                /*
                Paper x=new Paper();
                JSONObject obj=JSON.parseObject(tempString);
                //清洗数据 过滤掉比较重要却为空的
                if(!obj.keySet().contains("abstract"))continue;
                if(!obj.keySet().contains("title"))continue;
                if(!obj.keySet().contains("authors"))continue;
                if(!obj.keySet().contains("url"))continue;
                if(!obj.keySet().contains("keywords"))continue;
                if(!obj.keySet().contains("id"))continue;
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
                //SID!!!!!!
                x.setSid(obj.getString("id").hashCode());
                //language
                x.setLang(obj.getString("lang"));
                //org
                x.setOrg(obj.getString("venue"));
                //volume
                x.setVolume(obj.getString("volume"));
                //year
                x.setYear(obj.getInteger("year"));
                if(!x.getLang().equals("en"))continue;

                ++cnt;
                hdbdao.insert(x);
                //System.out.println(tempString);
                //writer.write(tempString+"\r\n\r\n");
                now=now*2%MOD;

                if(cnt%100==0)System.out.println(cnt);
                */
            }
            writer.write(line);
            System.out.println(line);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            //System.out.println(cnt);
            writer.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    //插入专家
    public static void addExpert(){
        String path="D:\\temp\\data\\aminer_authors_2.txt";      //读入路径
        String wpath="D:\\temp\\data\\author_1k.txt";            //输出路径

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
            while(true){
            //while(cnt<3000){
                try {
                    ++line;

                    tempString = reader.readLine();
                    if(tempString==null)break;
 /*
                    Expert x = new Expert();
                    JSONObject obj = JSON.parseObject(tempString);
                    if (obj == null) break;
                    //清洗数据 过滤掉比较重要却为空的
                    if (obj.keySet().size() == 0) continue;
                    if (!obj.keySet().contains("name")) continue;
                    if (!obj.keySet().contains("orgs")) continue;
                    if (obj.getString("orgs").length() == 0) continue;
                    if (!obj.keySet().contains("position")) continue;
                    //h_index
                    x.sethIndex(obj.getInteger("h_index"));
                    //name
                    x.setName(obj.getString("name"));
                    //ncitation
                    x.setnCitation(obj.getInteger("n_citation"));
                    //n_pubs
                    x.setnPubs(obj.getInteger("n_pubs"));
                    //orgs
                    x.setOrgs(obj.getJSONArray("orgs").toJSONString());
                    //position
                    x.setPosition(obj.getString("position"));
                    //pubid
                    JSONArray temp=obj.getJSONArray("pubs");
                    int len=temp.size();
                    for(int u=0;u<len;u++){
                        JSONObject lin=temp.getJSONObject(u);
                        int sid=lin.getString("i").hashCode();
                        if(hdbdao.getPaperBySID(sid)!=null) {
                            lin.put("i", hdbdao.getPaperBySID(sid).getTitle());
                            lin.put("id",hdbdao.getPaperBySID(sid).getId());
                        }
                        else{
                            lin.put("id",-100);
                        }
                        //int who=lin.getString()
                        temp.set(u,lin);
                    }
                    x.setPubid(temp.toJSONString());
                    x.setPubid(obj.getJSONArray("pubs").toJSONString());
                    //tags
                    x.setTags(obj.getJSONArray("tags").toJSONString());

                    //aid!!!!!
                    x.setAid(obj.getString("id").hashCode());
                    ++cnt;
                    //logger.info(tempString);
                    //hdbdao.insert(x);
                    //System.out.println(tempString);
                    //writer.write(tempString+"\r\n\r\n");
                    now = now * 2 % MOD;
                    */
                }
                catch (Exception t){

                }


            }
            //System.out.println(cnt);
            writer.write(line);
            System.out.println(line);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            writer.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static boolean check(JSONObject obj){
        if (obj.keySet().size() == 0) return false;
        if (!obj.keySet().contains("name")) return false;
        if (!obj.keySet().contains("orgs")) return false;
        if (obj.getString("orgs").length() == 0) return false;
        if (obj.getString("orgs").contains("?"))return false;
        if (!obj.keySet().contains("h_index"))return false;
        if (obj.getInteger("h_index")<2)return false;
        if (!obj.keySet().contains("position")) return false;
        return true;
    }
    //第一遍初插 只保留要插入的专家的完整信息
    public static void addExpert1(){
        String path="D:\\temp\\data\\aminer_authors_2.txt";      //读入路径
        String wpath="D:\\temp\\data\\author_1W-v2.txt";            //输出路径
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
            while(true){
                try {
                    ++line;
                    tempString = reader.readLine();
                    if(tempString==null)break;
                    Expert x=new Expert();
                    JSONObject obj=JSON.parseObject(tempString);
                    if(obj==null)break;
                    if(!check(obj))continue;
                    else{
                        ++cnt;
                        writer.write(tempString);
                        writer.write("\r\n");
                        if(cnt==4000)break;
                    }
                }
                catch (Exception t){
                }
            }
            System.out.println(cnt);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            writer.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //对初插的数据 获取其应分配的ID
    public static void getExpertID(){
        String path="D:\\temp\\data\\author_1W-v2.txt";      //读入路径
        String wpath="D:\\temp\\data\\author_id.txt";            //输出路径
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
            while(true){
                try {
                    ++line;
                    int t;
                    tempString = reader.readLine();
                    if(tempString==null)break;
                    JSONObject obj=JSON.parseObject(tempString);
                    ++cnt;
                    writer.write(obj.getString("id")+" "+new Integer(cnt));
                    writer.write("\r\n");
                }
                catch (Exception t){

                }


            }
            System.out.println(line);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            writer.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Set<String> st=new TreeSet<String>();                     //expert的id的set
    public static Map<String,Integer> mp=new HashMap<String, Integer>();    //exper的id的对应关系
    public static Set<String> pst=new TreeSet<String>();                    //paper的id的set
    public static Map<String,Integer> pmp=new HashMap<String, Integer>();   //paper的id的对应关系
    public static Map<String,String> ptitle=new HashMap<String, String>();  //paper的原id与标题的对应关系

    public static boolean check2(JSONObject obj){
        if(!obj.keySet().contains("title"))return false;
        if(!obj.keySet().contains("authors"))return false;
        if(!obj.keySet().contains("id"))return false;
        JSONArray ar=obj.getJSONArray("authors");
        int len=ar.size();
        for(int i=0;i<len;i++) {
            JSONObject tem= (JSONObject) ar.get(i);
            if(st.contains(tem.getString("id"))){
                return true;
            }
        }
        return false;
    }
    //初始化exper的set和map
    public static void initst(){
        String aipath="D:\\temp\\data\\author_id.txt";            //读入authro id 对应的数据
        File ai=new File(aipath);
        BufferedReader reader=null;
        try {
            //插入set
            FileReader aitem = new FileReader(ai);
            reader = new BufferedReader(aitem);
            while (true) {
                String sid, rid;
                String lin = reader.readLine();
                if (lin == null) break;
                String[] str = lin.split(" ");
                String tem = str[0].trim();
                st.add(tem);
                String numval=str[1];
                mp.put(tem,Integer.parseInt(numval));
                if (st.size() < 5) logger.info(tem + "\r\n");
            }
        }
        catch (Exception e){
        }
    }
    //初始化paper的set和map
    public static void initst2(){
        String aipath="D:\\temp\\data\\paper_1W-toadd.txt";
        File ai=new File(aipath);
        BufferedReader reader=null;
        int cnt=0;
        try {
            //插入set
            FileReader aitem = new FileReader(ai);
            reader = new BufferedReader(aitem);
            while (true) {
                String sid, rid;
                String lin = reader.readLine();
                if (lin == null) break;
                JSONObject obj= (JSONObject) JSON.parse(lin);
                String tem=obj.getString("id");
                String title=obj.getString("title");
                ++cnt;
                Integer val=new Integer(cnt);
                pst.add(tem);
                pmp.put(tem,val);
                ptitle.put(tem,title);
                if (st.size() < 5) logger.info(tem + "\r\n");
            }
        }
        catch (Exception e){
        }
    }
    //输出这些作者（作为前5作者）需要的论文 （论文也只保留前5作者）
    public static void getPaper(){


        String aipath="D:\\temp\\data\\author_id.txt";            //读入authro id 对应的数据
        String path="D:\\temp\\data\\aminer_papers_2.txt";        //实际要读入的文件的路径
        String wpath="D:\\temp\\data\\paper_1W.txt";            //输出路径

        File ai=new File(aipath);

        File f=new File(path);
        BufferedReader reader=null;
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-consumer.xml");
        IHDBdao hdbdao=ctx.getBean(IHDBdao.class);

        try{

            initst();
            FileWriter writer=new FileWriter(wpath,false);
            FileReader tem=new FileReader(f);
            reader =new BufferedReader(tem);
            String tempString=null;
            int line=0;
            int MOD=233,now=133;
            int cnt=0;
            while(true){
                try {
                    ++line;
                    tempString = reader.readLine();
                    if(tempString==null)break;
                    JSONObject obj=JSON.parseObject(tempString);
                    if(!check2(obj))continue;
                    ++cnt;
                    writer.write(tempString+"\r\n");

                }
                catch (Exception t){
                }
            }
            System.out.println(cnt);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            writer.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    //更新paper的JSON  将已有的作者转换为其真实id
    public static void UpdatePaperJson(){
        initst();

        String path="D:\\temp\\data\\paper_1W.txt";      //读入路径
        String wpath="D:\\temp\\data\\paper_1W-toadd.txt";            //输出路径
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
            while(true){
                ++line;
                tempString=reader.readLine();
                if(tempString==null)break;
                JSONObject obj=JSON.parseObject(tempString);
                JSONArray ar=obj.getJSONArray("authors");
                int len=ar.size();
                for(int i=0;i<len;i++){
                    JSONObject x=ar.getJSONObject(i);
                    if(!x.keySet().contains("id"))continue;
                    String pastid=x.getString("id");
                    if(st.contains(pastid)){
                        x.put("id",mp.get(pastid).toString());
                    }
                    ar.set(i,x);
                }
                obj.put("authors",ar);
                writer.write(obj.toJSONString()+"\r\n");
                ++cnt;
                if(cnt<5)
                    logger.info(obj.toJSONString()+"\r\n");
            }
            System.out.println(cnt);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            //System.out.println(cnt);
            writer.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //更新Expert 的JSON 将已有的论文转换为其真实id
    public static void UpdateExpertJson(){
        initst();
        initst2();
        String path="D:\\temp\\data\\author_1W-v2.txt";      //读入路径
        String wpath="D:\\temp\\data\\author_1W-toadd.txt";            //输出路径
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
            while(true){
                ++line;
                tempString=reader.readLine();
                if(tempString==null)break;
                JSONObject obj=JSON.parseObject(tempString);
                JSONArray ar=obj.getJSONArray("pubs");
                int len=ar.size();
                int pcnt=0;
                for(int i=len-1;i>=0;i--){
                    JSONObject x=ar.getJSONObject(i);
                    if(!x.keySet().contains("i"))continue;
                    String pastid=x.getString("i");
                    if(pst.contains(pastid)){
                        x.put("i",pmp.get(pastid).toString());//更新id
                        x.put("title",ptitle.get(pastid));      //更新title
                        ++pcnt;
                        ar.set(i,x);
                    }
                    else{
                        ar.remove(i);
                    }
                }
                obj.put("pubs",ar);
                if(obj.values().contains("n_pubs")){
                    obj.put("n_pubs",pcnt);
                }
                writer.write(obj.toJSONString()+"\r\n");
                ++cnt;
                if(cnt<10){
                    logger.info(obj.toJSONString()+"\r\n");
                }
            }
            System.out.println(cnt);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            //System.out.println(cnt);
            writer.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //实际上传Expert
    public static void UploadExpert(){
        initst();
        initst2();
        String path="D:\\temp\\data\\author_1W-toadd.txt";

        File f=new File(path);
        BufferedReader reader=null;
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-consumer.xml");
        IHDBdao hdbdao=ctx.getBean(IHDBdao.class);
        try{
            FileReader tem=new FileReader(f);
            reader =new BufferedReader(tem);
            String tempString=null;
            int line=0;
            int MOD=233,now=133;
            int cnt=0;
            while(true){
                ++line;
                //if(line<1009)continue;
                tempString=reader.readLine();
                if(tempString==null)break;
                JSONObject obj=JSON.parseObject(tempString);
                Expert x=new Expert();
                //h_index
                if(obj.keySet().contains("h_index"))
                x.sethIndex(obj.getInteger("h_index"));
                //name

                x.setName(obj.getString("name"));
                //ncitation
                if(obj.keySet().contains("n_citation"))
                x.setnCitation(obj.getInteger("n_citation"));
                //n_pubs
                if(obj.keySet().contains("n_pubs"))
                x.setnPubs(obj.getInteger("n_pubs"));
                //orgs
                if(obj.keySet().contains("orgs"))
                x.setOrgs(obj.getJSONArray("orgs").toJSONString());
                //position
                x.setPosition(obj.getString("position"));
                //pubid
                if(obj.keySet().contains("pubs"))
                x.setPubid(obj.getJSONArray("pubs").toJSONString());
                //tags
                if(obj.keySet().contains("tags"))
                    x.setTags(obj.getJSONArray("tags").toJSONString());


                x.setId(mp.get(obj.getString("id")));
                x.setAid(obj.getString("id"));
                hdbdao.insert(x);
                ++cnt;

                //assert(checkval(cnt)==true);
                if(cnt<10){
                    logger.info(x.getId().toString());
                    //logger.info(obj.toJSONString()+"\r\n");
                }
                if(cnt%100==0)
                    logger.info(new Integer(cnt).toString());

            }
            System.out.println(cnt);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            //System.out.println(cnt);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void UploadPaper(){
        initst();
        initst2();
        String path="D:\\temp\\data\\paper_1W-toadd.txt";

        File f=new File(path);
        BufferedReader reader=null;
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-consumer.xml");
        IHDBdao hdbdao=ctx.getBean(IHDBdao.class);
        try{
            FileReader tem=new FileReader(f);
            reader =new BufferedReader(tem);
            String tempString=null;
            int line=0;
            int MOD=233,now=133;
            int cnt=0;
            while(true){
                ++line;

                tempString=reader.readLine();
                if(tempString==null)break;
                JSONObject obj=JSON.parseObject(tempString);
                Paper x=new Paper();


                //abstract
                if(obj.keySet().contains("abstract"))
                x.setAbs(obj.getString("abstract"));
                //authorID
                if(obj.keySet().contains("authors"))
                x.setAuthorId(obj.getJSONArray("authors").toJSONString());

                //c_number
                if(obj.keySet().contains("n_citation"))
                x.setcNumber(obj.getInteger("n_citation"));
                //cost
                x.setCost(now);
                //doc_type
                if(obj.keySet().contains("doc_type"))
                x.setDocType(obj.getString("doc_type"));
                //ISBN
                if(obj.keySet().contains("isbn"))
                x.setIsbn(obj.getString("isbn"));
                //ISSN
                if(obj.keySet().contains("issn"))
                x.setIssn(obj.getString("issn"));
                //issue
                if(obj.keySet().contains("issue"))
                x.setIssue(obj.getString("issue"));
                //key_words
                if(obj.keySet().contains("keywords"))
                x.setKeywords(obj.getJSONArray("keywords").toJSONString());
                //title
                if(obj.keySet().contains("title"))
                x.setTitle(obj.getString("title"));
                //url
                if(obj.keySet().contains("url"))
                x.setUrl(obj.getString("url"));



                //language
                if(obj.keySet().contains("lang"))
                x.setLang(obj.getString("lang"));
                //org
                if(obj.keySet().contains("venue"))
                x.setOrg(obj.getString("venue"));
                //volume
                if(obj.keySet().contains("volume"))
                x.setVolume(obj.getString("volume"));
                //year
                if(obj.keySet().contains("year"))
                x.setYear(obj.getInteger("year"));

                //id
                x.setId(pmp.get(obj.getString("id")));
                x.setSid(obj.getString("id"));

                hdbdao.insert(x);
                ++cnt;
                if(cnt<10){
                    logger.info(obj.toJSONString()+"\r\n");
                }
                if(cnt%100==0)
                    logger.info(new Integer(cnt).toString());
            }
            System.out.println(cnt);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            //System.out.println(cnt);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static boolean checkval(int val){
        initst();
        initst2();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-consumer.xml");
        IHDBdao hdbdao=ctx.getBean(IHDBdao.class);
        Expert x= (Expert) hdbdao.getByID(Expert.class,val);
        if(x.getId().equals(mp.get(x.getAid()))){
            logger.info("all right");
            return true;
        }
        else{
            logger.info(x.getId().toString());
            logger.info(mp.get(x.getAid()).toString());
            logger.info("no!!!");
            return false;
        }
    }

    public static boolean checkPaperVal(int val){
        initst();
        initst2();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-consumer.xml");
        IHDBdao hdbdao=ctx.getBean(IHDBdao.class);
        Paper x=(Paper)hdbdao.getByID(Paper.class,val);
        if(x.getId().equals(pmp.get(x.getSid()))){
            logger.info("all right");
            return true;
        }
        else{
            logger.info(x.getId().toString());
            logger.info(pmp.get(x.getSid()).toString());
            logger.info("no!!!");
            return false;
        }
    }
    public static void main(String args[]){

        //addPaper();
        //addExpert();
        //addExpert1();
        //getExpertID();
        //getPaper();
        //UpdatePaperJson();
        //UpdateExpertJson();
        //UploadExpert();
        //UploadPaper();
        //checkval(3980);
        //checkPaperVal(13560);

        Paper u=new Paper();
        u.setTitle("TestTest");

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-consumer.xml");
        IHDBdao hdbdao=ctx.getBean(IHDBdao.class);
        int id=hdbdao.insertPaper(u);
        System.out.println(id);
        System.out.println("!!!!!!!!");
        //String path="D:\\temp\\data\\paper_1k.txt";
        /*              文件路径                    */
       // String path="D:\\temp\\data\\paper_1k-backup.txt";





    }
}
