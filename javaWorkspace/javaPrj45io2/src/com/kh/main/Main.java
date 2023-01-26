package com.kh.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//파일객체
		File f = new File("abc.txt");
		
		//통로 생성
		FileOutputStream fos = new FileOutputStream(f);
		PrintWriter pw = new PrintWriter(fos);
		
		//데이터 보내기
		pw.println("hello~~~!");
		pw.flush();

	}//main

}//class


























