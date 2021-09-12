package com.yedam.app.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.employee.domain.DepartmentsVO;
import com.yedam.app.employee.mapper.DepartmentsMapper;
@Service
public class DepartmentsServiceImp implements DepartmentsService {
	
	@Autowired DepartmentsMapper departMapper;
	
	@Override
	public List<DepartmentsVO> getDeptList() {
		// TODO Auto-generated method stub
		return departMapper.getDeptList();
	}

	@Override
	public int insertDept(DepartmentsVO vo) {
		// TODO Auto-generated method stub
		return departMapper.insertDept(vo);
	}

	@Override
	public int updateDept(DepartmentsVO vo) {
		// TODO Auto-generated method stub
		return departMapper.updateDept(vo);
	}

	@Override
	public int deleteDept(DepartmentsVO vo) {
		// TODO Auto-generated method stub
		return departMapper.deleteDept(vo);
	}

	@Override
	public DepartmentsVO getDept(DepartmentsVO vo) {
		// TODO Auto-generated method stub
		return departMapper.getDept(vo);
	}

}
