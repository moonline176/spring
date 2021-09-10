package com.yedam.app.employee.mapper;

import java.util.List;

import com.yedam.app.employee.domain.JobsVO;


public interface JobsMapper {
	//CRUD
		
		//전체 조회
		public List<JobsVO> getJobsList();
		
}
