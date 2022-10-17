package day03;

/* 이진탐색
 * - 리스트, 배열 이용
 * - 정렬되어 있는 자료구조로 적용해야 함
 * - O (log n)
*/

import java.util.*;

public class Q19_BinarySearch {
	
	public static int binarySearch(int[] arr, int length, int key) {
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		int left = 0;
		int right = length - 1;
		int center = (left + right) / 2;
		int count = 0;
		while(left <= right) {
			count++;
			center = (left + right) / 2;
			if(key == arr[center]) {
				System.out.println(count);
				return center;
			} else if (key > arr[center]) {
				left = center + 1;
			} else if (key < arr[center]) {
				right = center - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("배열 크기 입력 : ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("배열에 저장할 정수값 입력 : ");
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("검색값 입력 : ");
		int key = sc.nextInt();
		int idx = binarySearch(arr, n, key);
		System.out.println((idx<0)?key + "값 없음":idx +" 번에" + key + "존재");

	}

}
