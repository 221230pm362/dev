package com.kh.main;

public class KhList {
	
	private int[] arr = new int[3];
	private int empty = 0;
	
	public int get(int n) {
		return arr[n];
	}
	
	public void add(int value) {
		increaseArr();
		arr[empty] = value;
		empty++;
	}//method
	
	//배열 사이즈 증가 기존배열값을 복사
	private void increaseArr() {
		if(empty == arr.length) {
			int[] tempArr = new int[arr.length * 2];
			
			//arr -> tempArr
			for(int i = 0 ; i < arr.length; ++i) {
				tempArr[i] = arr[i];
			}
			
			arr = tempArr;
		}
	}

}//class


























