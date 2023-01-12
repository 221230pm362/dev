package main;

import main.mob.Pokemon;

public class Main {

	public static void main(String[] args) {
		
		System.out.println(" ===== 포켓몬 ===== ");
		
		//피카츄
		Pokemon pikachu = new Pokemon();
		pikachu.name = "피카츄";
		pikachu.hp = 100;
		pikachu.atk = 30;
		
		//파이리
		Pokemon pairi = new Pokemon();
		pairi.name = "파이리";
		pairi.hp = 80;
		pairi.atk = 35;
		
		//꼬부기
		Pokemon turtle = new Pokemon();
		turtle.name = "꼬부기";
		turtle.hp = 120;
		turtle.atk = 25;
		
		//포켓몬들의 정보 출력
		System.out.println( pikachu.info() );
		System.out.println( pairi.info() );
		System.out.println( turtle.info() );
		
	}//main

}//class





















