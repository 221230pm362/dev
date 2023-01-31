package com.kh.manager;

import com.kh.mob.Pokemon;

public class GameManager {

	private Pokemon[] pArr = new Pokemon[3];
	
	//포켓몬 생성
	public void generateMob() {
		pArr[0] = new Pokemon("피카츄" , 100 , 30 , "백만볼트");
		pArr[1] = new Pokemon("파이리" , 90 , 33 , "파이어볼");
		pArr[2] = new Pokemon("꼬부기" , 120 , 25 , "물대포");
		
		printMobInfo();
	}
	
	//모든 포켓몬 정보 출력
	public void printMobInfo() {
		for(Pokemon p : pArr) {
			System.out.println(p);
		}
	}

}//class































