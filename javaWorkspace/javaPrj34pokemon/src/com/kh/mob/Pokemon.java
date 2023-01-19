package com.kh.mob;

public abstract class Pokemon {
	
	public int hp;
	public int atk;
	public int def;
	
	//기본공격
	public void bodyAttack() {
		System.out.println("몸통박치기 ( " + atk*1 + " )");
	}
	
	public abstract void skill();
	
	//스킬
	public void skill(String str) {
		System.out.println(str + " ( " + atk*2 +" )");
	}

}






