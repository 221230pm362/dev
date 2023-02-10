package com.kh.app.main;

import com.kh.app.board.BoardService;
import com.kh.app.member.MemberService;

public class MainService {
	
	private MemberService ms = new MemberService();
	private BoardService bs = new BoardService();
	
	public boolean startService() throws Exception {
		//선택지 보여주기
		showMenu();
		
		//입력받기
		String input = Main.sc.nextLine();
		
		if("9".equals(input)) {
			return true;
		}
		
		//선택지에 따라 로직 실행
		processService(input);
		
		return false;
	}
	
	private void processService(String input) throws Exception {
		switch(input) {
		case "1" : ms.join(); break;
		case "2" : ms.login(); break;
		case "3" : bs.write(); break;
		case "4" : bs.selectBoardList(); break;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	private void showMenu() {
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 게시글 작성");
		System.out.println("4. 게시글 목록 조회");
		System.out.println("9. 종료");
	}

}//class



























