package main;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===== 메인 =====");
		
		CounterEmp c = new CounterEmp();
		c.nick = "철수";
		
		KitchenEmp k = new KitchenEmp();
		
		// 인사하기
		c.hello();
		
		// 주문받기
		c.takeOrder();
		
		// 음료제조
		k.makeTea();
		
		// 설거지
		k.wash();
		
	}//main

}//class

























