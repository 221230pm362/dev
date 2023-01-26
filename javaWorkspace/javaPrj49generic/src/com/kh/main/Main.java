package com.kh.main;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("~~~~~ 제네릭 ~~~~~");
		
		ArrayList<Integer> scoreList = new ArrayList<Integer>();
		
		scoreList.add(100);
		scoreList.add(90);
		scoreList.add(200);
		
		int x = scoreList.get(0);
		
		System.out.println(scoreList);
		
		
	}//main

}//class






























