package com.kh.animal;

public class Dog extends Animal {

	//기본생성자
	public Dog() {
		//super("zzz");
		//super();
		//return Dog객체;
	}

	public String name;
	
	@Override
	public void cry() {
		System.out.println("멍멍!");
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
