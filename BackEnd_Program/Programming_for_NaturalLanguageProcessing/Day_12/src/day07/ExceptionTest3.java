package day07;

public class ExceptionTest3 {

	public static void main(String[] args) {
		
		for(int i=1;i<=5;i++) {
			try {
				int a=50/(i-3);
				System.out.println("a: " + a);
			}catch(Exception e){
				System.out.println("0으로 나누기 불가");
			}
		}
		System.out.println("The End");
		
		
	}

}
