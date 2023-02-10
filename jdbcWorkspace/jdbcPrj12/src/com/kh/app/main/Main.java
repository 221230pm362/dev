package com.kh.app.main;

import java.sql.Connection;
import java.util.Scanner;

import com.kh.app.jdbc.JdbcTemplate;

public class Main {
	
	public static final Scanner sc = new Scanner(System.in);
	public static String loginMemberNick;

	public static void main(String[] args) throws Exception {
		
		System.out.println("==========");

		//비니지스 로직
		MainService ms = new MainService();
		while(true) {
			boolean isFinish = ms.startService();
			if(isFinish) {break;}
		}
		
		System.out.println("=====프로그램 종료=====");
		
	}//main

}//class

























