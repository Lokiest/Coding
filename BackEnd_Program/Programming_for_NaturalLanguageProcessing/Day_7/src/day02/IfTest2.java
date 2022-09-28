package day02;
import java.util.Scanner;

public class IfTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System.in : 키보드 입력을 받을 수 있는 입력장치
		System.out.println("2자리 정수 입력 : ");
		int a = sc.nextInt();
		int b = (a / 10);
		int c = (a % 10);
		if (a < 10 || a>= 100) {
			System.out.println("2자리 입력하세요");
			return; //main으로 돌아감 >> JVM이 호출 >> 프로세스 종료
		}
		if (b==c) {
	         System.out.println("OK, 10의 자리와 1의 자리가 같아요");
		}
	    else {
	         System.out.println("NO, 10의 자리와 1의 자리가 달라요");
	    }
		
		String st = (a%10 == a/10)? "OK, 10의 자리와 1의 자리가 같아요":"No, 10의 자리와 1의 자리가 달라요";
		System.out.println(st);
		
	}

}
