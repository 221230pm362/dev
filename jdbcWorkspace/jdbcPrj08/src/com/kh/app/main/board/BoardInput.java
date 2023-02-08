package com.kh.app.main.board;

import com.kh.app.main.Main;

public class BoardInput {
	
	//작성하기 데이터 받기
	public BoardData write() {
		System.out.print("제목 : ");
		String title = Main.SC.nextLine();
		System.out.print("내용 : ");
		String content = Main.SC.nextLine();
		System.out.print("작성자 : ");
		String writer = Main.SC.nextLine();
		
		BoardData data = new BoardData();
		data.setTitle(title);
		data.setContent(content);
		data.setWriter(writer);
		
		return data;
	}

}


















