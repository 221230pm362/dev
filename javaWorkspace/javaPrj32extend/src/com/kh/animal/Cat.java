package com.kh.animal;

public class Cat extends Animal {
	
	public String name;
	
	//이 메소드는 오버라이드 한 메소드임
	@Override
	public void cry() {
		System.out.println("야옹~");
	}

	public String getName() {
		return super.name;
	}

	public void setName(String name) {
		super.name = name;
	}
	
	

}
