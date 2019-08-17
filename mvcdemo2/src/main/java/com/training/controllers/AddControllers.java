package com.training.controllers;
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
@Controller  
public class AddControllers {
	
	@RequestMapping("/add")
	public String add()
	{
		//System.out.println("hello");
		return "empedit";
	}
}
