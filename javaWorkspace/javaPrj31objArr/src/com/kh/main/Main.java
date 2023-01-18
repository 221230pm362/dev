package com.kh.main;

import com.kh.mob.Pokemon;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("=====객체배열=====");
		
		Pokemon[] arr = new Pokemon[3];
		arr[0] = new Pokemon("피카츄" , 100 , 30);
		arr[1] = new Pokemon("파이리" , 80 , 35);
		arr[2] = new Pokemon("꼬부기" , 120 , 25);
		
		for(int i = 0 ; i < arr.length; i++) {
			System.out.println(arr[i].getName());
		}
		
		//enhanced for
		System.out.println("----------------------");
		for(Pokemon x : arr) {
			System.out.println(x);
		}

	}

}



















