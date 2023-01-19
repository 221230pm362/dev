package com.kh.main;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("main called...");
		
		Person p = new Person();
		
		p.setName("심원용");
		p.setAge(20);
		
		System.out.println(p.getAge());
		
		p.setAge(2);
		System.out.println(p.getAge());

	}//main

}//class






















