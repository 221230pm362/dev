package com.kh.animal;

public abstract class Animal {

	//생성자
//	public Animal(String s) {
//		
//	}

	public String name = "애니멀클래스에서할당한네임";
	public int age;
	
	public void eat() {
		System.out.println("밥먹음");
	}
	
	public abstract void cry();

}










