package com.kh.main;

import com.kh.person.Person;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("zzz");
		
		Person p1 = new Person();
		
		p1.setName("심투용");
		p1.setAge(22);
		
		p1.introduce();
		
		// p1의 name 변수의 값을 출력
		System.out.println( p1.getName() );
		System.out.println( p1.getAge() );
		

	}//main

}//class


























