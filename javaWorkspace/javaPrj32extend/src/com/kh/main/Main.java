package com.kh.main;

import com.kh.animal.Animal;
import com.kh.animal.Cat;
import com.kh.animal.Dog;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("=====상속=====");
		
		Animal d = new Dog();
		Cat c = new Cat();
//		Animal a = new Animal();	//추상클래스는 객체화 불가능
		
		d.cry();
		c.cry();
		
		
	}//main

}//class




























