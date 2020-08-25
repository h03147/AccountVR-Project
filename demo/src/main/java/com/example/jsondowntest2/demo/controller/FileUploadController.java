package com.example.jsondowntest2.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@RestController
public class FileUploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFiles(@RequestParam("fileName")MultipartFile[] multipartFiles,
                              HttpServletRequest httpServletRequest) {
        try {
            //创建文件在服务器的存放路径
            String dir = httpServletRequest.getServletContext().getRealPath("./");
            File fileDir = new File(dir);
            if(!fileDir.exists()){
                fileDir.mkdir();//不能存在就创一个
            }
            //生成文件在服务器的名字
            for (int i = 0; i < multipartFiles.length; i++){
                String fileSuffix = multipartFiles[i].getOriginalFilename()
                        .substring(multipartFiles[i].getOriginalFilename().lastIndexOf("."));
                String fileName = UUID.randomUUID().toString() + fileSuffix;
                File file = new File(fileDir + "/" + fileName);
                //上传
                multipartFiles[i].transferTo(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

}
