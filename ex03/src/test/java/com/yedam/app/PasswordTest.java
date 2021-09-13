package com.yedam.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")

public class PasswordTest {
	@Test
	public void encodingTest() { //spring 사이트 제공 인코딩
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16); //숫자가 올라갈 수 록 시간지연 + 해킹공격에 대한 방어 good 
		String result = encoder.encode("1234"); //암호화 할 평서문
		log.info(result); //암호화 할때마다 다른 값이 나타남
		assertTrue(encoder.matches("1234", result)); //(사용자가 입력한 암호(평서문), 암호화된 값)
	}
}
