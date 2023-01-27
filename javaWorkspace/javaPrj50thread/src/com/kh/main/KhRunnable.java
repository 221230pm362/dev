package com.kh.main;

public class KhRunnable implements Runnable {

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		t.setName("신입쓰레드");
		String name = t.getName();
		
		System.out.print("[" + name + "] ");
		System.out.println("내가 만든 러너 ~~~ 너를 위해 ");
	}

}
