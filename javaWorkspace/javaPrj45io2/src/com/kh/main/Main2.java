package com.kh.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main2 {

	public static void main(String[] args) throws Exception {
		
		//파일객체 생성
		File f = new File("abc.txt");
		
		//통로 생성
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		String[] strArr = new String[10];
		
		while(true) {
			//데이터 읽기
			String str = br.readLine();
			//마지막인지 검사
			if(str == null) {break;}
			//출력
			System.out.println(str);
		}
		

	}//main

}//class


























