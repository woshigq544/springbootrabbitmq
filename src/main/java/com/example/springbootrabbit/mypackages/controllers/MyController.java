package com.example.springbootrabbit.mypackages.controllers;

import com.example.springbootrabbit.mypackages.mail.TestMail;
import com.example.springbootrabbit.mypackages.sender.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private HelloSender producer;

    @Autowired
    private TestMail tm;

    @RequestMapping("/ok")
    public String asdas(){
        System.out.println("ko");
        for (int i = 0 ; i < 5 ; i++){
            producer.stringSend();
        }
        return  "ASDDAS";
    }
}
