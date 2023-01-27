package com.kh.chat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {

	public static void main(String[] args) throws IOException {
		
		System.out.println("=====서버=====");
		
		ServerSocket ss = new ServerSocket(12345);
		
		System.out.println("연결요청이 오기를 기다리는중 ....");
		Socket s = ss.accept();
		System.out.println("연결완료 ! : " + s);
		
		//아웃풋 스트림 생성
		OutputStream out = s.getOutputStream();
		PrintWriter pw = new PrintWriter(out);
		
		while(true) {
			//유저한테 메세지 입력받기
			Scanner sc = new Scanner(System.in);
			System.out.print("보낼메세지 : ");
			String msg = sc.nextLine();
			
			//종료 조건
			if(msg.equals("exit")) {break;}
			
			//메세지 보내기
			pw.println(msg);
			pw.flush();
		}
		

	}//main

}//class






























