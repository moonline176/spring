package com.yedam.app2.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app2.employee.domain.EmployeeVO;
import com.yedam.app2.employee.mapper.EmployeeMapper;
@Service

public class EmployeeServiceimpl implements EmployeeService {

	@Autowired EmployeeMapper employeeMapper;
	
	@Override
	public int insert(EmployeeVO vo) {
		return employeeMapper.insert(vo);
	}

	@Override
	public int update(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EmployeeVO read(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeVO> getList() {
		// TODO Auto-generated method stub
		return employeeMapper.getList();
	}

}
