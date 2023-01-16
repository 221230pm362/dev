package com.kh.person;

public class Person {
	
	//상수 : 항상 같은 값을 가지는 수 (재할당 불가능)
	//대문자로 작성 //띄어쓰기는 언더바로 대체
	//final double PI = 3.14;	//이거 값 바꾸지마셈
	
	//변수 (멤버변수 == 필드)
	private String name;
	private int age;
	
	//메소드
	public void introduce() {
		System.out.println("저는 " + name + "이고, " + age + "살 입니다.");
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}

}//class




















