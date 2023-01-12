package main.manager;

import main.mob.Pokemon;

public class GameManager {
	
	//포켓몬 3마리 받아서, 정보를 출력
	public void printPokemonInfo(Pokemon p1 , Pokemon p2 , Pokemon p3) {
		System.out.println(p1.info());
		System.out.println(p2.info());
		System.out.println(p3.info());
	}//method
	
	//배틀 관리
	public boolean fight(Pokemon attacker , Pokemon deffender) {
		System.out.println(attacker.name + " 의 공격!!!");
		deffender.hp -= attacker.atk;
		System.out.println(deffender.name + "의 체력 : " + deffender.hp);
		if(deffender.hp <= 0) {
			System.out.println(deffender.name + " 사망");
			System.out.println(attacker.name + " 승리!!!");
			//break;	//게임종료
			return true;
		}else {
			return false;
		}
	}
	
	

}//class
























