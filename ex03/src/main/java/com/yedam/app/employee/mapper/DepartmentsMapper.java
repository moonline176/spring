package com.yedam.app.employee.mapper;

import java.util.List;

import com.yedam.app.employee.domain.DepartmentsVO;


public interface DepartmentsMapper {
		//전체 조회
		public List<DepartmentsVO> getDeptList();
		
		//등록
		public int insertDept(DepartmentsVO vo);
		
		//수정
		public int updateDept(DepartmentsVO vo);
		
		//삭제
		public int deleteDept(DepartmentsVO vo);
		
		//단건 조회
		public DepartmentsVO getDept(DepartmentsVO vo);
		
}
