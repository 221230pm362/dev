package main.mob;

public class Pokemon {
	
	//변수 (멤버변수 == 객체변수 == 인스턴스변수 == 필드)
	public String name;
	public int hp;
	public int atk;
	  
	// 메소드 (멤버메소드 == 객체메소드 == 인스턴스메소드) 
	// 공격하기
	public void attack() {
		System.out.println(name + "이(가) " + atk + "의 공격력으로 공격!!!");
	}
	
	// 메소드 
	// 포켓몬 정보 (자기소개)
	public String info() {
		return "내 이름은 " + name + ", 체력은 " + hp + " , 공격력 " + atk;
	}

}//class


























