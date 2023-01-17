package com.kh.animal;

public class Cat {
	
	private String name;
	private int age;
	
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public void jump() {
		System.out.println("고양이 점프!!!");
	}

}//class


















