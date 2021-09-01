package com.yedam.app.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yedam.app.Departments;

@Repository //DAO와 동일
public interface EmpMapper {
	List<Map> getEmp();
	
	//부서 목록 조회
	List<Departments> getDept();
}
