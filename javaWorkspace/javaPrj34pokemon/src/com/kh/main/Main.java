package com.kh.main;

import com.kh.mob.Ggobuki;
import com.kh.mob.Gugu;
import com.kh.mob.Pairi;
import com.kh.mob.Pikachu;
import com.kh.mob.Pokemon;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("=====포켓몬=====");
		
		Pokemon[] mobArr = new Pokemon[4];
		mobArr[0] = new Pikachu();
		mobArr[1] = new Pairi();
		mobArr[2] = new Ggobuki();
		mobArr[3] = new Gugu();
		
		for(int i = 0 ; i < mobArr.length; ++i) {
			mobArr[i].bodyAttack();
			mobArr[i].skill();
		}
		
//		for(Pokemon x : mobArr) {
//			x.bodyAttack();
//		}
		
//		mob01.skill();
//		mob02.skill();
//		mob03.skill();

	}//main

}//class























