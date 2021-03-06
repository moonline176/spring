package com.yedam.app.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.employee.domain.DepartmentsVO;
import com.yedam.app.employee.service.DepartmentsService;

@Controller
public class DeptController {

	@Autowired
	DepartmentsService departmentsService;
	// @ResponseBody //ajax 요청

	// 부서관리 페이지
	@GetMapping("dept")
	public String dept() {
		return "insa/dept";
	}

	// 단건조회
	@GetMapping("/{departmentId}")
	public DepartmentsVO getDept(@PathVariable int departmentId,DepartmentsVO vo) {
		vo.setDepartmentId(departmentId);
		System.out.println(departmentsService.getDept(vo)); 
		return vo;
	}

	// 삭제
	@DeleteMapping("/dept/{departmentId}")
	public int deletDept(@PathVariable int departmentId, DepartmentsVO vo) {
		vo.setDepartmentId(departmentId);
		int r = departmentsService.deleteDept(vo);
		return r;
	}

	// ajax : 목록, 등록, 수정, 삭제 --> responsebody 필요
	@GetMapping("deptList")
	@ResponseBody
	public List<DepartmentsVO> deptList() {
		return departmentsService.getDeptList();
	}

	// 등록
	@PostMapping("insertDept")
	@ResponseBody
	public DepartmentsVO insertDept(@RequestBody DepartmentsVO vo) {

		System.out.println(vo.toString());
		departmentsService.insertDept(vo);
		return vo;
	}

//	// 등록
//	@PostMapping("insertDept")
//	@ResponseBody
//	public Map<String, Object> insert(@RequestBody DepartmentsVO dvo) {
//		departmentsService.insertDept(dvo);
//		return Collections.singletonMap("result", true);
//	}

	// 수정
	@PutMapping("updateDept")
	@ResponseBody
	public DepartmentsVO updateDept(@RequestBody DepartmentsVO vo) {
		departmentsService.updateDept(vo);
		return vo;
	}
	
	// 1명 조회  --> 단건 조회 예시
//		@GetMapping("/users/{userid}")
//		public UserVO user(@PathVariable String userid) {
//			return dao.getUser(userid);
//		}

}
