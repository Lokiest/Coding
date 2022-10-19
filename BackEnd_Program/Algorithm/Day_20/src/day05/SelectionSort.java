package day05;

import java.util.Arrays;

//O(n^2)
public class SelectionSort {
	// 선택정렬: 최소(또는 최대) 값을 선택해서 해당 값을 앞 위치부터 가져다 두는 형태
	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				// 최소값이 있는 위치를 찾는 과정
				if (arr[min] > arr[j]) {
					min = j;
				}
			} // for-----
			int tmp = arr[min];
			arr[min] = arr[i];
			arr[i] = tmp;
		} // for------
	}// ----------------------------------------
		// 내림차순으로 선택정렬 해보세요

	public static void selectSortDesc(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int max = i;
			for (int j = i + 1; j < arr.length; j++) {
				// 최소값이 있는 위치를 찾는 과정
				if (arr[max] < arr[j]) {
					max = j;
				}
			} // for-----
			int tmp = arr[max];
			arr[max] = arr[i];
			arr[i] = tmp;
		} // for------
	}// ----------------------------------------

	public static void main(String[] args) {
		int arr[] = { 6, 5, 13, 7, 1, 9, 8 };
		System.out.println(Arrays.toString(arr));
//		selectSort(arr);
		selectSortDesc(arr);
		System.out.println("---선택 정렬 후--------------");
		System.out.println(Arrays.toString(arr));

	}

}
