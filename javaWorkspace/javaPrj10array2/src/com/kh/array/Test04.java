package com.kh.array;

public class Test04 {
	
	public void method01() {
		System.out.println("Test04 > method01 called...");
		
		// 3x3 2차원 배열 만들기
		// 순서대로 10, 20 , 30 ... 90 값 할당
		// 모든 변수 (9개) 출력
		int[][] arr = new int[3][3];
		
		int value = 10;
		for(int x = 0; x < arr.length; x++) {
			for(int i = 0; i < arr[x].length; i++) {
				arr[x][i] = value;
				value += 10;
			}
		}
		
		for(int x = 0; x < 3; x++) {
			for(int i = 0; i < 3; i++) {
				System.out.println(arr[x][i]);
			}
		}
		
		
	}

}//class



















