package com.kh.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===== 입출력 =====");
		
		File f = new File("abc.txt");
		
		try {
			FileWriter fw = new FileWriter(f);
			fw.write("zzzzz");
			fw.flush();
		} catch (IOException e) {
			System.out.println(e);
		}

	}//main

}//class






















