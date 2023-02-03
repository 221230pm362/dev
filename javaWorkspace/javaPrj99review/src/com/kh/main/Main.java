package com.kh.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("=====자바 복습=====");
		
//		String[] strArr = {"apple", "google" , "amazon"};
//		
//		for(int i = 0 ; i < strArr.length; ++i) {
//			System.out.println(strArr[i]);
//		}
		
//		String str = "user01,1234,nick01";
//		
//		String[] arr = str.split(",");
		
//		for(int i = 0 ; i < arr.length; ++i) {
//			System.out.println(arr[i]);
//		}
		
//		for(String x : arr) {
//			System.out.println(x);
//		}
		
		//////////////////////////////////////
		
		File f = new File("abc.txt");
		
//		FileWriter fw = null;
//		try {
//			fw = new FileWriter(f);
//			fw.write("hello~~~!!!");
//			fw.flush();
//		}catch(Exception e) {
//			System.out.println("예외 발생 ~~~");
//			e.printStackTrace();
//		}finally {
//			try {fw.close();} catch (IOException e) {e.printStackTrace();}
//		}
		
		//try with resource
		try (
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
			) {
			fw.write("~~~");
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}//main

}//class






































