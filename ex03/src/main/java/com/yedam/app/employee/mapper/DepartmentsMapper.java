package com.yedam.app.employee.mapper;

import java.util.List;

import com.yedam.app.employee.domain.DepartmentsVO;


public interface DepartmentsMapper {
		//전체 조회
		public List<DepartmentsVO> getDeptList();
		
		//등록
		public int insertDept(DepartmentsVO vo);
		
}
