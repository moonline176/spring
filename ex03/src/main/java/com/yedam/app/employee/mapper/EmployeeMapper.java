package com.yedam.app.employee.mapper;

import java.util.List;

import com.yedam.app.employee.domain.EmployeeVO;


public interface EmployeeMapper {
	//CRUD
		//등록
		public int insert(EmployeeVO vo);
		
		//수정
		public int update(EmployeeVO vo);
		
		//삭제
		public int delete(EmployeeVO vo);
		
		//단건 조회
		public EmployeeVO getEmp(EmployeeVO vo);
		
		//전체 조회
		public List<EmployeeVO> getEmpList();
		
		public EmployeeVO getByEmail(EmployeeVO vo); 
		
}
