package com.aditya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/test/helloWorld")
	public String helloWorld() {
		return "hello";
		
		
	}

}
