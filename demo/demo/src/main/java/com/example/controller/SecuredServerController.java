package com.example.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ssl")
public class SecuredServerController {
		
    @GetMapping("/secured")
    public String secured(){
        System.out.println("Inside secured()");
        return "Hello USER !!! : " + new Date();
    }
}
