package com.yedam.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
public class Ditest {
	//IoC(역제어) : 객체관리를 컨테이너가 해줌
	//DI : dependency Injection
	@Autowired Employees emp; //객체생성없이 컨테이너에서 주입받음
	@Test
	public void test1() {
		emp.getEmployeeId();
		//log.info(emp.getEmployeeId());
	}
}
