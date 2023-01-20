package com.kh.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static final Scanner SC = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		
		
		System.out.println("파일 입출력 ~~~");
		
		FileManager fm = new FileManager();
		
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		
		String num = SC.nextLine();
		if(num.equals("1")) {
			fm.join();
		}else {
			fm.login();
		}
		
		
		
		
		
		
//		System.out.println("문자열을 입력하세요");
//		String msg = sc.nextLine();
//		fm.test01(msg);
//		
//		fm.test02();
		
		
		
		
		
		

	}//main

}//class






























