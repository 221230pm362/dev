package com.kh.app.main;

public class MemberInput {
	
	//회원가입 입력받기
	public MemberData join() {
		//회원가입 데이터 입력받기
		System.out.print("아이디 : ");
		String memberId = Main.SC.nextLine();
		System.out.print("패스워드 : ");
		String memberPwd = Main.SC.nextLine();
		System.out.print("닉네임 : ");
		String memberNick = Main.SC.nextLine();
		
		MemberData data = new MemberData();
		data.setMemberId(memberId);
		data.setMemberPwd(memberPwd);
		data.setMemberNick(memberNick);
		
		return data;
	}
	
	//로그인 입력받기
	public MemberData login() {
		//로그인 데이터 입력받기
		System.out.print("아이디 : ");
		String memberId = Main.SC.nextLine();
		System.out.print("패스워드 : ");
		String memberPwd = Main.SC.nextLine();
		
		MemberData data = new MemberData();
		data.setMemberId(memberId);
		data.setMemberPwd(memberPwd);
		
		return data;
	}

}










