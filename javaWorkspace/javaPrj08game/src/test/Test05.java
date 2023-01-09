package test;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//int x = (int) sc.nextLine();	//String -> int 캐스팅 X
		String s = sc.nextLine();
		int x = Integer.parseInt(s);
		double d = Double.parseDouble(s);
		float f = Float.parseFloat(s);
		long l = Long.parseLong(s);
		
		System.out.println(x);
		System.out.println(d);
		System.out.println(f);
		System.out.println(l);
				
	}//main

}//class
























