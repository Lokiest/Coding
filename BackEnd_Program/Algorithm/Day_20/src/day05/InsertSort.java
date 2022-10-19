package day05;

import java.util.Arrays;

//선택한 요소와 배열에 저장된 값의 비교를 통해 삽입할 위치를 찾는 방식
//삽입정렬은 어느정도 정렬이 되어 있는 배열일 경우 O(n) 
//         정렬이 잘 안되어 있는 배열일 경우 O(n^2) ===> O(n^2)
public class InsertSort {

	public static void insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int tmp = arr[i];
			int j = i - 1;
			for (; j >= 0; j--) {
				if (arr[j] > tmp) {
					arr[j + 1] = arr[j];
				} else {
					break;
				}
			}
			arr[j + 1] = tmp;
			// 삽입할 위치를 찾았다면 tmp를 해당 위치에 삽입한다
		} // for-------
	}// -------------------

	public static void insertSort2(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int tmp = arr[i];
			int j = i - 1;
			for (; j >= 0 && arr[j] > tmp; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = tmp;
			// 삽입할 위치를 찾았다면 tmp를 해당 위치에 삽입한다
		} // for-------
	}// -------------------

	public static void main(String[] args) {
		int arr[] = { 7, 8, 4, 1, 9, 2 };
		System.out.println(Arrays.toString(arr));
//		insertSort(arr);
		insertSort2(arr);
		System.out.println("--삽입 정렬 후-----------------");
		System.out.println(Arrays.toString(arr));

	}

}
