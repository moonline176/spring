package com.yedam.app.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.employee.domain.DepartmentsVO;
import com.yedam.app.employee.service.DepartmentsService;

@Controller
public class DeptController {
	
	@Autowired DepartmentsService departmentsService;
	//@ResponseBody //ajax 요청
	
	//부서관리 페이지
	@GetMapping("dept")
	public String dept() {
		return "insa/dept";
	}
	
	
	//ajax : 목록, 등록, 수정, 삭제 --> responsebody 필요
	@GetMapping("deptList")
	@ResponseBody
	public List<DepartmentsVO> deptList(){
		return departmentsService.getDeptList();
	}
	
	@PostMapping("insertDept")
	public DepartmentsVO insertDept(@ModelAttribute("indept") DepartmentsVO vo) {
		
		departmentsService.insertDept(vo);
		return vo;
	}
	
	
	
}
