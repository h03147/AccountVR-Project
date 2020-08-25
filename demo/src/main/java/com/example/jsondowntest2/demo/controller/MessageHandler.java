package com.example.jsondowntest2.demo.controller;

import com.example.jsondowntest2.demo.entity.Message;
import com.example.jsondowntest2.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageHandler {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/findAll")
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Message findById(@PathVariable("id") Integer id){
        return messageRepository.findById(id).get();
    }

//    教师回复留言
    @PutMapping("/update")
    public String update(@RequestBody Message message){
//        前端传过来的修改留言请求
        System.out.println("前段传来的请求user"+message);
        //初始化一个date类型，注意要赋初值
//        Date date = null;
        //如果直接new一个Date对象，则采用的是系统时间
        Date systemDate = new Date();
        //这里采用上转型new一个简单日期格式对象，指定格式为（年-月-日）
//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //指定格式为（年-月-日 时:分:秒）
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        message.setResponse_time(format1.format(systemDate));
        Message result = messageRepository.save(message);
        if(result != null)
        {
            return "success";
        }
        else
        {
            return "error";
        }
    }

//    添加留言
    @PostMapping("/addmessage")
    public String addmessage(@RequestBody Message message){
        //        前端传过来的修改留言请求
        System.out.println("前段传来的请求user"+message);
        message.setRequest_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        message.setAnswer("未答复");
        Message addmessageresult = messageRepository.save(message);
        if(addmessageresult != null)
        {
            return "add message success!";
        }else
        {
            return "add message failed!";
        }
    }
//    根据id删除留言
    @DeleteMapping("/deleteById/{id}")
    public void DeleteById(@PathVariable("id") Integer id){
        //        前端传过来的修改留言请求
        System.out.println("前段传来的请求user"+id);
        messageRepository.deleteById(id);
    }
}
