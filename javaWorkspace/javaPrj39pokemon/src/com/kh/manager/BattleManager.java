package com.kh.manager;

import com.kh.mob.Pokemon;

public class BattleManager {
	
	public void battleStart(Pokemon user , Pokemon enemy){
		boolean isFinish;
		while(true) {
			isFinish = fight(user , enemy);
			if(isFinish) { break; }
			isFinish = fight(enemy , user);
			if(isFinish) { break; }
		}
	}
	
	public boolean fight(Pokemon attacker , Pokemon deffender){
		
		attacker.boddyAttack();
		int damage = attacker.getAtk() - deffender.getDef(); 
		deffender.setHp(deffender.getHp() - damage);
		if(deffender.getHp() <= 0) {
			System.out.println(attacker.getName() + " 승리 !");
			return true;
		}else {
			return false;
		}
		
	}//method

}//class
































