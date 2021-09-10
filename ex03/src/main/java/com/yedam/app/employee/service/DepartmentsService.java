package com.yedam.app.employee.service;

import java.util.List;

import com.yedam.app.employee.domain.DepartmentsVO;

public interface DepartmentsService {
	//전체 조회
	public List<DepartmentsVO> getDeptList();
	
	//등록
	public int insertDept(DepartmentsVO vo);
}
