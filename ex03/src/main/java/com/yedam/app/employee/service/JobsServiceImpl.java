package com.yedam.app.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.employee.domain.JobsVO;
import com.yedam.app.employee.mapper.JobsMapper;
@Service
public class JobsServiceImpl implements JobsService {

	@Autowired JobsMapper jobsMapper;
	
	@Override
	public List<JobsVO> getJobsList() {
		// TODO Auto-generated method stub
		return jobsMapper.getJobsList();
	}
	
	

}
