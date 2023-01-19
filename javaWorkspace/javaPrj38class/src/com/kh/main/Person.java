package com.kh.main;

public class Person {
	
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age-1;
	}
	public void setAge(int age) {
		if(this.age < age) {
			this.age = age;
		}else {
			System.out.println("값 확인좀");
		}
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	
	

}
