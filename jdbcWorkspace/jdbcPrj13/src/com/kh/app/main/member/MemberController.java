package com.kh.app.main.member;

import com.kh.app.main.Main;

public class MemberController {
	
	private MemberServiceInterface ms;
	
	//생성자
	public MemberController(MemberServiceInterface x) {
		ms = x;
	}
	
	//회원가입
	public int join() {
		
		//데이터 입력받기
		System.out.print("아이디 : ");
		String memberId = Main.SC.nextLine();
		System.out.print("패스워드 : ");
		String memberPwd = Main.SC.nextLine();
		System.out.print("닉네임 : ");
		String memberNick = Main.SC.nextLine();
		
		//데이터 뭉치기
		MemberVo vo = new MemberVo();
		vo.setId(memberId);
		vo.setPwd(memberPwd);
		vo.setNick(memberNick);
		
		int result = 0;
		try {
			//서비스 호출
			result = ms.join(vo);
		}catch(Exception e) {
			System.out.println("[ERROR] 회원가입 중 예외 발생");
			e.printStackTrace();
		}
		
		//결과 리턴
		return result;
		
	}//method 

}//class 




















