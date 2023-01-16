package com.kh.main;

import com.kh.person.Person;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("main~~~!");
		
		Person p1 = new Person();
		p1.setName("심삼용");
		p1.setAge(33);
		
		System.out.println(p1.getName());
		System.out.println(p1.getAge());

	}//main

}//class

























