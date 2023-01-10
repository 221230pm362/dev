package com.kh.array;

public class Test06 {
	
	public void method01() {
		
		System.out.println("Test06 > method01 called...");
		
		String[] arr = {"red" , "blue", "green"};
		
		String[] b = arr;
		
		System.out.println(arr[1]);
		System.out.println(b[1]);
		
	}//method01
	
	public void method02() {
		System.out.println("Test06 > method02 called...");
		
		String[] a = {"red" , "green" , "blue"};
		String[] b = new String[3];
		
		b[0] = a[0];
		b[1] = a[1];
		b[2] = a[2];
		
		System.out.println(b[0]);
		System.out.println(b[1]);
		System.out.println(b[2]);
		
	}

}//class


















