package com.yedam.app;

public class BuilderTest {
	
	public static void main(String[] args) {
		
		Member member = Member.builder()
							.id("aa")
							.pw("aaa")
							.build(); //생성자와 동시에 이용
		
							
	}
}
