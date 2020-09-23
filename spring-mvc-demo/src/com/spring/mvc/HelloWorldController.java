package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	// Need controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		
		return "helloworld-form";
	}
	
	// Need controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		
		return "helloworld";
	}
	
}
