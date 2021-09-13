package com.yedam.app.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	
	@GetMapping("/loginForm")
	public String String() {
		return "insa/login";
	}
	
}
