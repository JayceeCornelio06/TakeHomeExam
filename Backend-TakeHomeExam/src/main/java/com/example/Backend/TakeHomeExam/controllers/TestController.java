package com.example.Backend.TakeHomeExam.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/fortest")
public class TestController {

    @GetMapping("/test")
    public String Test(){

        System.out.println("test");
        return "Test Connection Success";
    }

}
