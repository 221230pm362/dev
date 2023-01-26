package com.kh.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class ListTest {
	
	public void m01() {
		
		ArrayList list = new ArrayList();
		
		list.add(100);
		list.add("kajsdhfklashdfklj");
		list.add(3.14);
		
		System.out.println(list);
//		for(int i = 0 ; i < list.size(); ++i) {
//			Object x = list.get(i);
//			System.out.println(x);
//		}
		
		list.remove(1);
		System.out.println(list);
		
		list.add(0, "apple");
		System.out.println(list);
		
	}
	
	
	public void m02() {
		
		LinkedList list = new LinkedList();
		
		list.add("apple");
		list.add(123);
		list.add(true);
		list.add(3.14);
		
		System.out.println(list);
		
//		Object x = list.get(2);
//		System.out.println(x);
		
		list.remove(2);
		System.out.println(list);
		
	}
	
	public void m03() {
		
		HashSet set = new HashSet();
		
		set.add("apple");
		set.add("apple");
		set.add("apple");
		set.add("orange");
		set.add(10);
		set.add(true);
		set.add(3.14);
		set.add("안녕ㅋㅋ");
		
		System.out.println(set);
		
		set.remove("apple");
		System.out.println(set);
		
	}
	
	public void m04() {
		
		HashMap map = new HashMap();
		
		map.put("k01" , "apple");
		map.put("age", 20);
		map.put("name", "심원용");
		map.put("hobby", new String[] {"코딩", "프로그래밍" , "개발"});
		
		System.out.println(map);
		
//		Object x = map.get("k01");
//		System.out.println(x);
		
		map.remove("name");
		System.out.println(map);
		
		map.put("age", 30);
		System.out.println(map);
		
		map.replace("zzz", "123123");
		System.out.println(map);
		
		String[] x = (String[]) map.get("hobby");
		System.out.println(x[0]);
		System.out.println(x[1]);
		System.out.println(x[2]);
		
	}

}//class




























