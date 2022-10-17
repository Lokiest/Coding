package day02;

import java.util.*;

public class Q18_LinearSearch2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("배열 크기 입력 : ");
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		System.out.println("저장할 값 입력 : ");
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("검색값 입력 : ");
		int key = sc.nextInt();
		
		int idx = searchSentinel(arr, n+1, key);
		System.out.println((idx!=n)? key+"값은 배열 인덱스 "+idx+"에 존재":"노존재");

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
	
	public static int searchSentinel(int[] arr, int n, int key) {
		arr[n-1] = key;
		int i = -1;
		for(i=0;i<n;i++) {
			if(arr[i]==key) {
				return i;
			}
		}
		return i;
	}
}
