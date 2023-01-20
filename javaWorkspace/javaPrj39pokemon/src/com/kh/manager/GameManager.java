package com.kh.manager;

import java.util.Scanner;

import com.kh.mob.Pokemon;

public class GameManager {
	
	Pokemon[] mobArr = new Pokemon[3];
	Pokemon user;
	Pokemon enemy; 
	
	public void startGame() {
		// 몬스터 생성
		generateMob();
		
		// 유저 포켓몬 선택
		selectUserMob();
		
		// 적 포켓몬 선택
		selectEnemyMob();
		
		// 배틀
		startBattle();
	}
	
	private void generateMob(){
		// 초기 포켓몬 생성
		mobArr[0] = new Pokemon("피카츄" , 100 , 30 , 10);
		mobArr[1] = new Pokemon("파이리" , 100 , 35 , 7);
		mobArr[2] = new Pokemon("꼬부기" , 100 , 25 , 15);
		
		// 생성된 몬스터 들 정보 출력
		printMobInfo();
	}
	
	private void printMobInfo() {
		for(int i = 0 ; i < mobArr.length; ++i) {
			System.out.println(mobArr[i]);
		}
	}
	
	//유저 포켓몬 선택
	private void selectUserMob() {
		System.out.print("포켓몬을 선택하세요 : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		user = mobArr[num-1];
		System.out.println("유저 포켓몬 : " + user);
	}
	
	//상대 포켓몬 선택
	private void selectEnemyMob() {
		int random = (int)(Math.random() * 3 + 0);
		enemy = mobArr[random];
		System.out.println("상대 포켓몬 : " + enemy);
	}
	
	private void startBattle(){
		BattleManager bm = new BattleManager();
		bm.battleStart(user , enemy);
	}
	

}//class































