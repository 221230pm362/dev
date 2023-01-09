package javaPrj04condition;

public class Practice04 {

	public static void main(String[] args) {
		
		//100 넘음
		
			// 홀수
		
			// 짝수
		
		//100 안넘음
		
			// 홀수
		
			// 짝수
		
		int x = 150;
		
		if(x > 100) {
			// x가 100 넘음
			if(x % 2 == 1) {
				System.out.println("100넘음 , 홀수");
			}else {
				System.out.println("100넘음 , 짝수");
			}
		}else {
			// x가 100 안넘음
			if(x % 2 == 1) {
				System.out.println("100안넘음 , 홀수");
			}else {
				System.out.println("100안넘음 , 짝수");
			}
		}

	}

}










