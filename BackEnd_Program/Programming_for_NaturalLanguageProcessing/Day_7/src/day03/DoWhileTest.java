package day03;

public class DoWhileTest {

	public static void main(String[] args) {
		/*
		 * do{ 반복 실행 문장 }while(조건문);
		 * 
		 * while문의 경우 조건문이 true일 경우에 반복 실행하지만, do ~while문의 경우 조건문이 false일지라도 한번은 실행을 하고
		 * 루프문을 벗어난다. 조건문이 true라면 반복 실행.
		 * ctrl + shift + f : 코드정렬
		 */ 
		int a = 5;
		do {
			System.out.println(a);
//			a -= 10;
			a++;
		} while (a<10); {
			System.out.println("-------------------");
		}
	}

}
