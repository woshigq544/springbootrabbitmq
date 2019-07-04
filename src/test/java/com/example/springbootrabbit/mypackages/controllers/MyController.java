package com.example.springbootrabbit.mypackages.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping("/ok")
    public String asdas(){
        return  "ASDDAS";
    }
}
