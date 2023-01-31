package com.kh.main;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("=====컬렉션과 제네릭=====");
		
		// 컬렉션 : 자료구조 모음
		// 자료구조 : 자료들 잘 담으려고 만든 구조물
		
		List<Integer> x = new ArrayList<Integer>();
		
		//add
		x.add(333);
		
		//get
		int temp = x.get(0);
		
		//remove
		x.remove(0);
		
		MyVar<String> v = new MyVar<String>();
		v.setX("123");
		String result = v.getX();
		
	}//main

}//class





























