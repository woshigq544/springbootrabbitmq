package com.example.springbootrabbit.rabbitmqs.controllers;

import com.example.springbootrabbit.rabbitmqs.mail.TestMail;
import com.example.springbootrabbit.rabbitmqs.sender.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private HelloSender producer;


    @Autowired
    private TestMail testmail;


    @RequestMapping("/ok")
    public String asdas(){

        System.out.println("新的代码");

        System.out.println("邮件发送");

        //testmail.reportCurrentTime();
        producer.topicTopic1Send();
        producer.topicTopic2Send();
        producer.topicTopic3Send();
        return  "页面已跳转，你会发现后台的异步方法仍在执行，你可以选择先玩玩<a href='http://www.4399.com'>小游戏</a>放松一下打发时间";
    }
}
