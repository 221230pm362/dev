package com.kh.main;

import com.kh.animal.Cat;
import com.kh.animal.Dog;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("main called...");
		
		//강아지 객체 (name , age 값 채우기)
		//강아지의 모든 변수 값 출력
		Dog d = new Dog();
		d.setName("바둑이"); 
		d.setAge(2);
		
//		System.out.println(d.getName());
//		System.out.println(d.getAge());
		
		System.out.println( d );
		
		//고양이 객체 (name , age 값 채우기)
		//고양이의 모든 변수 값 출력
		Cat c = new Cat();
		c.setName("나비");
		c.setAge(3);
		
		System.out.println(c);
		

	}//main

}//class





















