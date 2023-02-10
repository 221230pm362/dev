package com.kh.app.member;

import com.kh.app.main.Main;

public class MemberInput {
	
	//회원가입 입력받기
	public MemberData join() {
		System.out.print("아이디 : ");
		String memberId = Main.sc.nextLine();
		System.out.print("비밀번호 : ");
		String memberPwd = Main.sc.nextLine();
		System.out.print("닉네임 : ");
		String memberNick = Main.sc.nextLine();
		
		MemberData data = new MemberData();
		data.setMemberId(memberId);
		data.setMemberPwd(memberPwd);
		data.setMemberNick(memberNick);
		return data;
	}
	
	//로그인 입력받기
	public MemberData login() {
		System.out.print("아이디 : ");
		String memberId = Main.sc.nextLine();
		System.out.print("비밀번호 : ");
		String memberPwd = Main.sc.nextLine();
		
		MemberData data = new MemberData();
		data.setMemberId(memberId);
		data.setMemberPwd(memberPwd);
		return data;
	}
	

}
