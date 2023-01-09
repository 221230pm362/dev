package javaPrj04condition;

public class Main {

	public static void main(String[] args) {
		
		//제어문(조건문) // if , else , else if , switch
		/*
		 * [if]
		 * if(조건식){실행내용}
		 * 
		 * [else] : 앞 조건 통과 못하면, 실행됨
		 * 단독 사용 불가능
		 * 앞에 조건식 검사가 있을 때 만 사용 가능
		 * 조건식 X
		 * 
		 * [else if] : 앞 조건 통과 못하면, 내 조건 검사
		 * 단독 사용 불가능
		 * 앞에 조건식 검사가 있을 때 만 사용 가능
		 * 조건식 O
		 */
		
		//age 의 값이 20 초과하면, "성인입니다." 출력
		//앞에 조건 통과 못하면? "미성년자입니다." 출력
		
//		int age = 30;
//		
//		if( age > 20 ) { 
//			System.out.println("성인입니다."); 
//		}
//		else {
//			System.out.println("미성년자입니다.");
//		}
		
		int x = 3;
		
		if(x > 0) {
			System.out.println("양수");
		}
		else if(x < 0) {
			System.out.println("음수");
		}
		else if(x == 0) {
			System.out.println("zero");
		}
		
	}

}
//마지막 줄





























































