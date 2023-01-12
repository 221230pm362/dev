package main;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("main method called...");
		
		//철수 객체 준비
		CounterEmp chulsoo = new CounterEmp();
		chulsoo.nickName = "철수";
		chulsoo.hello();

		//영희 객체 준비
		CounterEmp younghee = new CounterEmp();
		younghee.nickName = "영희";
		younghee.hello();
		
		
		

	}//main

}//class

































