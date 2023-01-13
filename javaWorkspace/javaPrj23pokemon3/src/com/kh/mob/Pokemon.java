package com.kh.mob;

public class Pokemon {
	
	//기본생성자 (파라미터 X) , JVM이 자동으로 만들어줌 (단, 다른 생성자가 없을 때)
	public Pokemon() {
		
	}
	
	//파라미터 있는 생성자
	public Pokemon(String name, int hp, int atk) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
	}
	
	//멤버변수 == 필드
	public String name;
	public int hp;
	public int atk;
	
	//멤버 메소드
	public String info() {
		return name + " / " + hp + " / " + atk;
	}
	

}





















