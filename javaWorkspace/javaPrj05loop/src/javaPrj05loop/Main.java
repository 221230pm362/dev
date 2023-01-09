package javaPrj05loop;

public class Main {

	public static void main(String[] args) {

		//제어문(반복문) 
		// while , for , do while 
		// break , continue
		
		/*
		 * [while] 
		 * while(조건식) {실행할내용}
		 *    조건 검사 => 조건 통과 => 코드블록 실행 
		 * => 조건 검사 => 조건 통과 => 코드블록 실행
		 * => 조건 검사 => 조건 통과 => 코드블록 실행
		 * ...
		 * (조건식 통과 못하면 , 끝남)
		 * 
		 * [for]
		 * for(초기식 ; 조건식 ; 증감식) {실행내용}
		 * 초기식 실행 
		 * => 조건식 => 코드실행 => 증감식 
		 * => 조건식 => 코드실행 => 증감식
		 * ...
		 * (조건식 통과 못하면 , 끝남)
		 * 
		 */
		
//		int n = 1;			//초기식
//		while(n <= 3) {		//조건식
//			System.out.println(n);
//			n = n+1;		//증감식
//		}
		
		for(int n = 1 ; n <= 3 ; n = n+1) {
			System.out.println(n);
		}
		
	}

}//마지막 줄





















