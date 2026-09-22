package com.softara.mockker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("mockker")
public class Test {
	 
	@GetMapping("/test")
	public String getOverviewCount(){	
		return "tested - online!";
	}  
}
