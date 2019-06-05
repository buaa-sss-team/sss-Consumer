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
//    @Reference
    private FileService fileService=new FileServiceImpl();

    public class FileServiceImpl implements FileService {
        // 1为有错误，0为正常返回
        public int FileUpload(MultipartFile file) {
            if (!file.isEmpty()){
                String storePath= "D:\\test";//存放我们上传的文件路径
                String fileName = file.getOriginalFilename();
                java.io.File filepath = new java.io.File(storePath, fileName);
                if (!filepath.getParentFile().exists()) {
                    filepath.getParentFile().mkdirs();//如果目录不存在，创建目录
                }
                try {
                    file.transferTo(new java.io.File(storePath+ java.io.File.separator+fileName));//把文件写入目标文件地址
                } catch (Exception e) {
                    e.printStackTrace();
                    return 0;
                }
                return 1;
            }
            return 0;
        }
        //使用最新的Firefox、Chrome、Opera、Safari则都可以正常下载文件名为中文的文件了
        //没考虑文件名不存在或错误
        public ResponseEntity<byte[]> FileDownload(String filename) {
            ResponseEntity<byte[]> res = null;
            String downloadFilePath = "D:\\test";
            File file = new File(downloadFilePath+File.separator+filename);
            HttpHeaders headers = new HttpHeaders();
            try {
                String downloadFileName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
                headers.setContentDispositionFormData("attachment" , downloadFileName);
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                res = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file) , headers, HttpStatus.OK);
            }catch (IOException e){
                return res;
            }
            return res;
        }
    }


    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    public String upload(@RequestParam("file")MultipartFile file , HttpServletRequest request)
            throws ServletException, IOException {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-consumer.xml");
//        fileService = ctx.getBean(FileService.class);
        fileService.FileUpload(file);
        return "test2";
    }

    @RequestMapping(value = "/filedownload/{filename:.+}")
    public ResponseEntity<byte[]> download(@PathVariable("filename") String filename, HttpServletRequest req) throws ServletException,IOException{
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-consumer.xml");
        //fileService = ctx.getBean(FileService.class);
        return fileService.FileDownload(filename);
    }
}
