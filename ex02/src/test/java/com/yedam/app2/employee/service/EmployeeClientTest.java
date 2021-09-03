package com.yedam.app2.employee.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class EmployeeClientTest {
	
		@Autowired EmployeeService employeeMapper;
	//전체조회
		@Test
		public void getList() {
			log.info(employeeMapper.getList().toString());
		}
}
