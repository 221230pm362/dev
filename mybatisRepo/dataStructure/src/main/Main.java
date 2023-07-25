package main;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		KhList<String> list = new KhList();
		
		list.add("zzz");
		list.add("zzz");
		list.add("zzz");
		list.add("zzz");
		list.add("zzz");
		list.add("zzz");
		list.add("zzz");
		list.add("zzz");
		list.add("zzz");
		list.add("zzz");
		
		System.out.println( list.toString() );
		
		System.out.println( "size : " + list.size() );
		
		System.out.println( "0번 인덱스의 데이터 : " + list.get(0) );
		System.out.println( "1번 인덱스의 데이터 : " + list.get(1) );
		
		list.remove(0);
		
		System.out.println( list.toString() );

	}

}//class

























