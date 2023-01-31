package com.kh.car;

public class Tesla extends Car implements ElectronicCar {

	@Override
	public void go() {
		System.out.println("전기로 ㄱㄱ");
	}

	@Override
	public void stop() {
		System.out.println("전기 ㄴㄴ");
	}

	@Override
	public void escape() {
		System.out.println("ㅌㅌ");
	}

}




















