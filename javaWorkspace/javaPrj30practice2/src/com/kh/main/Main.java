package com.kh.main;

import com.kh.animal.Cat;
import com.kh.animal.Dog;
import com.kh.animal.Rabbit;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("main called...");
		
		//강아지 객체 생성
		//강아지 정보 출력
		Dog d = new Dog();
		d.setName("바둑이");
		d.setAge(2);
		
//		System.out.println(d.getName());
//		System.out.println(d.getAge());
		
		System.out.println( d );
		
		//고양이 객체 생성
		//고양이 정보 출력
		Cat c = new Cat("야옹이" , 1);
		
		System.out.println( c );
		
		// 토끼 파라미터 있는 생성자 이용해서 객체 생성
		Rabbit r = new Rabbit("김토끼" , 2);
		System.out.println(r);
		

	}//main

}//class


























