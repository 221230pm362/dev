package com.kh.animal;

public class Dog {
	
	private String name;
	private int age;
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void cry() {
		System.out.println("멍멍");
	}
	
	public String toString() {
		return "name = " + name +" ,  age = " + age;
	}
	

}




















