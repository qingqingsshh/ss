package com.tedu.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name){
		
		return "1: "+name;   //这个内容直接做业务，称为提供者
	}
	
}
