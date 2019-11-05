package com.quinnox.demo2.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
		
		@RequestMapping("/")
		public String home(Map<String,Object> model){
			model.put("Message", "HowToDoInJava Reader !!");
			return "index";
		}
		
		@RequestMapping("/next")
		public String next(Map<String,Object> model){
			model.put("NEW MESSAGE", "You are in new page !!");
			return "next";
		}
	
}
