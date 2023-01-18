package com.kh.animal;

public class Rabbit {
	
	private String name;
	private int age;
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
	public Rabbit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rabbit(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return "Rabbit [name=" + name + ", age=" + age + "]";
	}
	
	

}
