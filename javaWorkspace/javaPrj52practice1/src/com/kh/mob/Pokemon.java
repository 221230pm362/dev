package com.kh.mob;

public class Pokemon {
	
	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", hp=" + hp + ", atk=" + atk + ", skillName=" + skillName + "]";
	}

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

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Pokemon(String name, int hp, int atk, String skillName) {
		super();
		this.name = name;
		this.hp = hp;
		this.atk = atk;
		this.skillName = skillName;
	}

	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String name;
	private int hp;
	private int atk;
	private String skillName;
	
	public void boddyAttack() {
		System.out.println(name + " 의 몸통박치기 !");
	}
	
	public void skill() {
		System.out.println(name + " 의 " + skillName + " !!!");
	}
	
	

}//class


























