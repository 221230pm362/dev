package main.mob;

public class Pokemon {
	
	// 데이터 (변수)
	public String name;
	public int hp;
	public int atk;
	
	// 행동 (메소드)
	
	//공격하기
	public void attack() {
		System.out.println(name + "이(가) " + atk + " 의 공격력으로 공격 !");
	}
	
	//포켓몬 정보 반환
	public String info() {
		return "이름은 " + this.name + ", 공격력은 " + this.atk + " , 체력은 " + this.hp;
	}

}//class





















