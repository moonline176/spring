package com.yedam.app.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.employee.domain.EmployeeVO;
import com.yedam.app.employee.service.DepartmentsService;
import com.yedam.app.employee.service.EmployeeService;
import com.yedam.app.employee.service.JobsService;

@Controller
@RequestMapping("/employee/*")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	@Autowired
	JobsService jobsService;
	@Autowired
	DepartmentsService departmentService;

	@ModelAttribute("opt") // --> 아래 핸들러가 실행되기 전에 model에 값을 담아 처리됨
	public Map<String, Object> jobs() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jobs", jobsService.getJobsList());
		map.put("depts", departmentService.getDeptList());
		return map;
	}

	// 등록폼
	@GetMapping("insertEmp")
	public String insertFormEmp(EmployeeVO vo) {
		return "insa/insertEmp";
	}

	// 수정폼
	@GetMapping("updateEmp")
	public String insertFormEmp(EmployeeVO vo, Model model) {
		model.addAttribute("emp", employeeService.getEmp(vo));
		return "insa/insertEmp";
	}

	// 등록
	@PostMapping("insertEmp")
	public EmployeeVO insertEmp(@ModelAttribute("evo") EmployeeVO vo) {
		
		//서비스 호출
		employeeService.insert(vo);
		return vo;
	}

	// 수정
	@PutMapping("/")
	public EmployeeVO update(@RequestBody EmployeeVO vo) {
		employeeService.update(vo);
		return employeeService.getEmp(vo);
	}

	// 전체조회
	@GetMapping("/elist")
	public void list(Model model) {

		model.addAttribute("list", employeeService.getEmpList());
		System.out.println(model.toString());
	}

	// 사원조회
	@GetMapping("empSearch")
	public String empSearch(Model model, EmployeeVO vo) {
		model.addAttribute("empList", employeeService.getEmpList());
		return "insa/empSearch";
	}

	// 삭제
	@DeleteMapping("/{employeeId}")
	public boolean delete(@PathVariable int employeeId, EmployeeVO vo) {
		vo.setEmployeeId(employeeId);
		int r = employeeService.delete(vo);
		return r == 1 ? true : false;
	}

	// 사원검색
	@RequestMapping("empSearch2")
	public String empSearch2(Model model, EmployeeVO vo) {
		model.addAttribute("empList", employeeService.getEmpList());
		return "insa/empSearch";
	}

	@RequestMapping("ajaxEmp")
	@ResponseBody
	private EmployeeVO ajaxEmp(EmployeeVO vo) {
		return employeeService.getEmp(vo);
	}

//	@RequestMapping("ajaxEmail")
//	@ResponseBody
//	private EmployeeVO ajaxEmail(EmployeeVO vo) {
//		return employeeService.getByEmail(vo);
//	}
}
