package day02;
import java.util.Scanner;

public class IfTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System.in : 키보드 입력을 받을 수 있는 입력장치
		System.out.println("정수 입력 : ");
		int a = sc.nextInt();
		System.out.println("a : " + a);
		
		//입력 받은 값 짝수, 홀수 나누기
		if (a % 2 == 0) {
			System.out.println("짝수");
		}
		else {
			System.out.println("홀수");
		}
		
	}

}
