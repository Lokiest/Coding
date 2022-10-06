package day07;

public class ExceptionTest2 {

	public static void main(String[] args) {
		
		try {
			for(int i=1;i<=5; i++) {
				int a=50/(i-3);
				System.out.println("a: " + a);
			}
		} catch(Exception e) {
			System.out.println("0으로 나누기 불가");
		}
		System.out.println("The End");
	}


}
