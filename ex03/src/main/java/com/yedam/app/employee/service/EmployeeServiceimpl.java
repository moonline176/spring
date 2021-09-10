package com.yedam.app.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.employee.domain.EmployeeVO;
import com.yedam.app.employee.mapper.EmployeeMapper;
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
	public EmployeeVO getEmp(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return employeeMapper.getEmp(vo);
	}

	@Override
	public List<EmployeeVO> getEmpList() {
		// TODO Auto-generated method stub
		return employeeMapper.getEmpList();
	}


}
