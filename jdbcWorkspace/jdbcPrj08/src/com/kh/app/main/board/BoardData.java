package com.kh.app.main.board;

public class BoardData {

	private String title;
	private String content;
	private String writer;
	@Override
	public String toString() {
		return "BoardData [title=" + title + ", content=" + content + ", writer=" + writer + "]";
	}
	public BoardData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardData(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
	
}
