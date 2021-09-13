package com.book.app.domain;

import java.util.Date;

import lombok.Data;

@Data
public class RentVO {
	private int rentNo;
	private int bookNo;
	private int rentPrice;
	private Date rentDate;
	private String rentStatus;
}
