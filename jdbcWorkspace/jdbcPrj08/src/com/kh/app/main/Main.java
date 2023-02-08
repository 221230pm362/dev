package com.kh.app.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.kh.app.main.board.BoardService;

public class Main {
	
	public static final Scanner SC = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		
		MainService ms = new MainService();
		
		System.out.println("=====게시판=====");
		
		//게시판 관련 서비스 처리
		ms.processBoard();
		
	}//main

}//class























