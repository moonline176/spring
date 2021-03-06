package com.yedam.app2.employee.mapper;

import java.util.List;

import com.yedam.app2.board.domain.Criteria;
import com.yedam.app2.employee.domain.EmployeeVO;


public interface EmployeeMapper {
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
		public List<EmployeeVO> getList(Criteria cri);
		
		//전체 게시글 수
		public int getTotalCount(Criteria cri);
}
