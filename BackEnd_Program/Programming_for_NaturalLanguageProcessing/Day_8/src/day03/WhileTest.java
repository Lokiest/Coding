package day03;

public class WhileTest {

	public static void main(String[] args) {
		
		int i = 1;
		while (i<5) {
			System.out.println("Hi " + i);
			i++;
		}
		
		i = 5;
		while (i>0) {
			System.out.println("Hello " + i);
			i--;
		}
		
		System.out.println("-------------------");
		
//		while (true) { // = for(;;)
//			System.out.println("무한루프");
//		}
		
		
	}

}
