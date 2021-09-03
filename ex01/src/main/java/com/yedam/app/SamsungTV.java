package com.yedam.app;


public class SamsungTV implements TV{
	public void turnon() {
		System.out.println("Samsung TV turnon");
	}
	public void turnoff() {
		System.out.println("Samsung TV turnoff");
	}
	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
	}
	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		
	}
}
