package com.sss.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;

import java.io.*;

public class addData {
    private static Logger logger = LoggerFactory.getLogger(addData.class);
    public static void main(String args[]){
        //String path="D:\\temp\\data\\paper_1k.txt";
        String path="D:\\temp\\data\\aminer_papers_2.txt";
        String wpath="D:\\temp\\data\\paper_1k.txt";



        File f=new File(path);
        BufferedReader reader=null;
        try{
            FileWriter writer=new FileWriter(wpath,false);
            FileReader tem=new FileReader(f);
            reader =new BufferedReader(tem);
            String tempString=null;
            int line=1;
            while(line<10){
                ++line;
                tempString=reader.readLine();
                writer.write(tempString);
                System.out.println("line "+line+ " "+tempString);
                System.out.println("");
            }
            writer.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }



    }
}
