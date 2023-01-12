package main;

import main.manager.GameManager;
import main.mob.Pokemon;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("=====포켓몬=====");
		
		//포켓몬 3마리 만들기
		Pokemon pikachu = new Pokemon();
		pikachu.name = "피카츄";
		pikachu.hp = 100;
		pikachu.atk = 30;
		
		Pokemon pairi = new Pokemon();
		pairi.name = "파이리";
		pairi.hp = 80;
		pairi.atk = 35;
		
		Pokemon ggobuki = new Pokemon();
		ggobuki.name = "꼬부기";
		ggobuki.hp = 120;
		ggobuki.atk = 25;
		
		//만들어진 포켓몬 정보 출력
		GameManager gm = new GameManager();
		gm.printPokemonInfo(pikachu, pairi, ggobuki);
		
		// 유저 : 피카츄
		// 상대 : 파이리
		Pokemon user = pikachu;
		Pokemon enemy = pairi;
		
		// 배틀 진행
		// 턴제로 진행 (무조건 돌아가면서 한번씩 공격)
		boolean isFinish = false;
		while(true) {
			isFinish = gm.fight(user, enemy);
			if(isFinish) {break;}
			
			isFinish = gm.fight(enemy, user);
			if(isFinish) {break;}
		}
		
		System.out.println("=====게임종료=====");
	}//main

}//class





























