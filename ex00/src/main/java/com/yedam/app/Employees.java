package com.yedam.app;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component //컨테이너 등록
public class Employees {
	
	private String employeeId;
	private String firstName;
	private String jobId;
	
}
