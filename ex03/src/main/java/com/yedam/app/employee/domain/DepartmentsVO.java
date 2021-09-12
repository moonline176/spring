package com.yedam.app.employee.domain;

import lombok.Data;

@Data
public class DepartmentsVO {
	private int departmentId;
	private String departmentName;
	private String managerId;
	private String locationId;
}
