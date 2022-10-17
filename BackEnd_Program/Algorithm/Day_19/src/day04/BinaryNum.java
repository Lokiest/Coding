package day04;

import java.util.Scanner;
//10진수 정수값을 넘기면 2진수 문자열로 출력하는 함수를 재귀함수로 구현해보세요

public class BinaryNum {
	
	public static void binaryNum(int num) {
		if(num<=0) return;
		binaryNum(num/2);
		System.out.print(num%2);		
	}//---------------------------
	
	public static void radixNum(int num, int radix) {
		if(num<=0) return;
		radixNum(num/radix, radix);
		int mod=num%radix;
		String str="0123456789ABCDEF";
		System.out.print(str.charAt(mod));
	}//---------------------------
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("정수를 입력하세요: ");
		int num=sc.nextInt();
		binaryNum(num);
		System.out.println();
		
		System.out.println(num+"의 8진수값: ");
		radixNum(num, 8);
		System.out.println();
		
		System.out.println(num+"의 16진수값: ");
		radixNum(num, 16);
		System.out.println();
		
		
	}

}
