package com.kh.util;

import java.util.Scanner;

public class DataInputManager {
	
	public static final Scanner SC = new Scanner(System.in);
	
	// 아이디 입력받기
	public String scanMemberId() {
		System.out.print("아이디 : ");
		return SC.nextLine().trim();
	}
	// 패스워드 입력받기
	public String scanMemberPwd() {
		System.out.print("패스워드 : ");
		return SC.nextLine().trim();
	}
	// 닉네임 입력받기
	public String scanMemberNick() {
		System.out.print("닉네임 : ");
		return SC.nextLine().trim();
	}

}
