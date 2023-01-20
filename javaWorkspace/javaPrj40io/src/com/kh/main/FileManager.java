package com.kh.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	
	private File f = new File("abc.txt");
	
	//글자 내보내기
	public void test01(String str) throws IOException {
		//write
		FileWriter fw = new FileWriter(f);
		fw.write(str);
		fw.flush();
	}
	
	//글자 읽어오기
	public void test02() throws Exception {
		//read
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		String str = br.readLine();
		System.out.println(str);
	}
	
	public void join() throws IOException {
		System.out.print("아이디를 입력하세요 : ");
		String memberId = Main.SC.nextLine();
		FileWriter fw = new FileWriter(f);
		fw.write(memberId);
		fw.flush();
	}
	
	public void login() throws Exception {
		System.out.print("로그인 할 아이디 : ");
		String memberId = Main.SC.nextLine();
		
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String memoId = br.readLine();
		
		if( memberId.equals(memoId) ) {
			System.out.println("로그인 성공 !!!");
		}else {
			System.out.println("로그인 실패 ...");
		}
	}

}//class





















