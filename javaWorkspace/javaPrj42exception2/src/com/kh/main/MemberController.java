package com.kh.main;

public class MemberController {
	
	public boolean join(String id , String pwd, String nick) {
		
		//아이디 검사
		if(id.length() < 2) {
			System.out.println("아이디 너무 짧음");
			return false;
		}
		
		//패스워드 검사
		if(pwd.length() < 2) {
			System.out.println("패스워드 너무 짧음");
			return false;
		}
		
		//닉네임 검사
		if(nick.length() < 2) {
			System.out.println("닉네임 너무 짧음");
			return false;
		}
		
		System.out.println("회원가입 완료!");
		return true;
		
	}//method
	
	public void join2(String id , String pwd , String nick) throws Exception {
		
		checkIdLen(id);
		checkPwdLen(pwd);
		checkNickLen(nick);
		
		System.out.println("회원가입 성공!!!");
	}
	
	private void checkNickLen(String nick) throws Exception {
		if(nick.length() < 2) {
			throw new Exception("닉네임 길이 짧음");
		}
	}

	private void checkPwdLen(String pwd) throws Exception {
		if(pwd.length() < 2) {
			throw new Exception("패스워드 길이 짧음");
		}
	}

	private void checkIdLen(String id) throws Exception {
		if(id.length() < 2) {
			throw new Exception("아이디 길이 짧음");
		}
	}
	
	public void m99() {
		
	}

}//class





























