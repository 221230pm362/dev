package com.kh.mob;

public class Pokemon {
	
	//기본 생성자 (==파라미터 X)
	
	//파라미터 있는 생성자
	public Pokemon(String name, int hp , int atk , int def) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
	}
	
	private String name;
	private int hp;
	private int atk;
	private int def;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	//몸통 박치기
	public void boddyAttack() {
		System.out.println(name + " 의 몸통박치기 !!!");
	}

	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", hp=" + hp + ", atk=" + atk + ", def=" + def + "]";
	}

	
	

}//class




















