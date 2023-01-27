package com.kh.main;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("=====쓰레드=====");
		
//		KhRunnable m = new KhRunnable();
		
		//신입쓰레드의 할일 생성
		Runnable m = new Runnable() {
			@Override
			public void run() {
				System.out.println("신규업무시작");
				
				//현재 쓰레드 3초 재우기
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					System.out.println("쓰레드 자는데 누가 방해함 그래서 예외 발생");
					e.printStackTrace();
				}
				
				Thread t = Thread.currentThread();
				//t.setName("신입쓰레드");
				String name = t.getName();
				for(int i = 1; i <= 10; ++i) {
					System.out.println("[" + name + "] " + i);
				}
				System.out.println("신규업무종료");
			}
		};
		
		//신입쓰레드 생성 및 업무지시
		Thread t01 = new Thread( () -> { System.out.println("람다식으로 만든 함수~~~!"); } );
		t01.start();
		
		//메인쓰레드가 본인 이름 가져오는 코드
		Thread mt = Thread.currentThread();
		String name = mt.getName();
		
		//메인쓰레드가 처리하는 반복문
		for(int i = 1; i < 11; ++i) {
			System.out.print("[" + name + "] ");
			System.out.println(i);
		}
		t01.interrupt();
		
		//t01.run();	//메인쓰레드가 run 메소드를 실행하러 감

	}//main

}//class
































