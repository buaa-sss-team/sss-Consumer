package com.sss.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sss.consumer.FileUtil;
import com.sss.interfaces.IDBService;
import com.sss.interfaces.service.FileService;
import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FileController {
//    @Reference
    //private FileServiceImpl fileService=new FileServiceImpl();




    @RequestMapping(value = "/fileupload/{prefix}", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, @PathVariable String prefix)
            throws ServletException, IOException {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-consumer.xml");
//        fileService = ctx.getBean(FileService.class);

        String filename = FileUtil.FileUpload(file, prefix);
        return filename;
    }



    @RequestMapping(value = "/filedownload/{filename:.+}")
    public ResponseEntity<byte[]> download(@PathVariable("filename") String filename, HttpServletRequest req) throws ServletException,IOException{
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-consumer.xml");
        //fileService = ctx.getBean(FileService.class);
        return FileUtil.FileDownload(filename);
    }
}
