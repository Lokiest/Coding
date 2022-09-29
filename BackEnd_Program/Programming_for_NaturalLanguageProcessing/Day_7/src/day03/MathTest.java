package day03;

import java.lang.Math;
// 주요 메서드
// static final double PI : 원주율(상수) "클래스명.변수"
// static int abs(int a)
// static double floor(double a)
// static double ceil(double a)

public class MathTest {

	public static void main(String[] args) {
		double p = Math.PI;
		System.out.println(Math.abs(-p));
		System.out.println(Math.floor(p));
		System.out.println(Math.ceil(p));
		
		System.out.println(Math.round(p));
		for (int i =0;i<3;i++) {
			double r = Math.random();
			System.out.println(r);
		}
		System.out.println("----------------------");
		
		/*
		[문제1] 0<= v2 <10 사이의 임의의 정수를 발생시키세요.		
		[문제2] 5<= v3 <15 사이의 임의의 정수를 발생시키세요.				
		*/
		int r2 = (int)(Math.random() * 10);
		System.out.println(r2);
		int r3 = (int)(Math.random() * 10 + 5);
		System.out.println(r3);
		int r4 = (int)(Math.random() * 32 + 23);
		System.out.println(r4);
		//Math.random() * 범위 + 시작수
		
		//랜덤하게 알파벳 대문자 출력
		char r5 = (char)((Math.random() * 26) + 65);
		System.out.println("랜덤 대문자 : "+ r5);
		
		//아래와 같은 형태로 랜덤한 알파멧을 출력하세요
		/*		E W Q R P
				U I Z W X
				M O G H A

				중첩 반복문 활용
		 * 
		 * */
		for (int i=0;i<3;i++) {
			for (int j=0;j<5;j++) {
				char r6 = (char) (Math.random() * 26 + 65);
				System.out.print(r6 + " ");
			}
			System.out.println();
		}
	}

}
