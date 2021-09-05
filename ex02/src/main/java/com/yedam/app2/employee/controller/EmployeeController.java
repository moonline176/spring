package com.yedam.app2.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.app2.employee.service.EmployeeService;

@Controller
@RequestMapping("/employee/*")
public class EmployeeController {
	
	@Autowired EmployeeService employeeService;
	
	//전체조회
	@GetMapping("/elist")
	public void list(Model model) {
		model.addAttribute("elist", employeeService.getList());
	}
	
	

}
