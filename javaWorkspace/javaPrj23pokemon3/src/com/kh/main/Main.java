package com.kh.main;

import com.kh.mob.Pokemon;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("zzz");
		
		//포켓몬 객체 2개 생성
		//포켓몬 객체의 변수에 값 넣기
		Pokemon p1 = new Pokemon("피카츄" , 100, 30);
//		p1.name = "피카츄";
//		p1.hp = 100;
//		p1.atk = 30;
		
		Pokemon p2 = new Pokemon("라이츄" , 150 , 40);
//		p2.name = "라이츄";
//		p2.hp = 150;
//		p2.atk = 40;
		
		//포켓몬 정보 출력
		System.out.println(p1.info());
		System.out.println(p2.info());
		
		

	}//main

}//class
























