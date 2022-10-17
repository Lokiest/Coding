package day02;

import java.util.*;

public class Q17_LinearSearch {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("배열 크기 입력 : ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("저장할 값 입력 : ");
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("검색값 입력 : ");
		int key = sc.nextInt();
		
		int idx = search(arr, n, key);
		System.out.println((idx<0)?key+"값은 배열에 없음":key+"값은 배열 인덱스 "+idx+"에 존재");

	}
	
	public static int search(int[] arr, int n, int key) {
		int idx = -1;
		int i;
		for(i=0;i<n;i++) {
			if(arr[i]==key) {
				return i;
			}
		}
		if(i==n-1) {
			return -1;
		}
		
		return idx;
	}

}
