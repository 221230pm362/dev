package javaPrj06control;

public class Practice03 {

	public static void main(String[] args) {
		
		int h = 183;
		int w = 42;
		
		double stdw = (h - 100) * 0.9 ;
		double bmi = (w-stdw) * 100 / stdw;
		
		if(bmi <= 10) {
			System.out.println("정상");
		}else if(bmi <= 20) {
			System.out.println("과체중");
		}else {
			System.out.println("비만");
		}

	}

}




















