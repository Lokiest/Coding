package day02;

import java.util.Scanner;

public class Q7_CardConv {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char arr[] = new char[32];
		System.out.println("양수 입력 : ");
		int n = sc.nextInt();
		System.out.println("몇 진수로? (2~36)");
		int radix = sc.nextInt();
		printRadix(n, radix, arr);

	}
	
	public static void printRadix(int num, int r, char[] arr) {
		System.out.printf("%d를 %d진수로 변환 : ", num, r);
		
		int i = conversion(num, r, arr);
		for(int k=i-1;k>=0;k--) {
			System.out.println(arr[k]);
		}
	}
	
	public static int conversion(int num, int radix, char[] arr) {
		String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int count = 0;
		do {
			int mod = num % radix;
			arr[count++] = str.charAt(mod);
			num = num/radix;
		} while (num != 0);
		
		return count;
	}

}
