package com.sss.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sss.interfaces.IDBService;
import com.sss.interfaces.service.FileService;
import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class FileController {
    @Reference
    private FileService fileService;

    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    public String upload(@RequestParam("file")MultipartFile file , HttpServletRequest request)
            throws ServletException, IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-consumer.xml");
        fileService = ctx.getBean(FileService.class);
        fileService.FileUpload(file);
        return "test2";
    }

    @RequestMapping(value = "/filedownload/{filename.+}")
    public ResponseEntity<byte[]> download(@PathVariable("filename") String filename, HttpServletRequest req) throws ServletException,IOException{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-consumer.xml");
        fileService = ctx.getBean(FileService.class);
        return fileService.FileDownload(filename);
    }
}
