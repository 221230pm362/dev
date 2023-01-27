package com.kh.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain {

	public static void main(String[] args) throws Exception {
		
		System.out.println("=====클라이언트=====");
		
		Socket s = new Socket("127.0.0.1" , 12345);
		
		System.out.println("연결완료 !!! : " + s);
		
		//인풋 스트림 생성
		InputStream in = s.getInputStream();
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		
		while(true) {
			//데이터 읽기
			String msg = br.readLine();
			System.out.println(msg);
		}
		
	}//main

}//class



























