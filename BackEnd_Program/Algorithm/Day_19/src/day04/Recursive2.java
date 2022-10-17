package day04;

import java.util.Scanner;
//출력물의 결과를 예측해서 적어보기
public class Recursive2 {
	
	static void recur(int n) {
		if(n>0) {
			recur(n-1);
			System.out.println(n);
			recur(n-2);
		}
	}

	public static void main(String[] args) {
		System.out.println("정수값 입력: ");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		recur(n);

	}

}
