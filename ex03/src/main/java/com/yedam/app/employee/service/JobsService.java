package com.yedam.app.employee.service;

import java.util.List;

import com.yedam.app.employee.domain.JobsVO;

public interface JobsService {
	//전체 조회
	public List<JobsVO> getJobsList();
}
