package com.yedam.app2.employee.service;

import java.util.List;

import com.yedam.app2.employee.domain.EmployeeVO;


public interface EmployeeService {
	//CRUD
		//등록
		public int insert(EmployeeVO vo);
		
		//수정
		public int update(EmployeeVO vo);
		
		//삭제
		public int delete(EmployeeVO vo);
		
		//단건 조회
		public EmployeeVO read(EmployeeVO vo);
		
		//전체 조회
		public List<EmployeeVO> getList();
}
