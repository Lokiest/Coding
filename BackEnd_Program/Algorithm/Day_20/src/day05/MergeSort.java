package day05;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 6, 5, 13, 7, 1, 9, 8, 15, 3 };
		System.out.println(Arrays.toString(arr));

		partition(arr, 0, arr.length - 1);
		System.out.println("--병합 정렬 이후--------------");
		System.out.println(Arrays.toString(arr));
	}// -----------------------------

	static void partition(int[] arr, int left, int right) {
		if (left == right)
			return;
		// 분할하다 보면(2로 나누기) left==right순간이 생긴다
		int mid = (left + right) / 2;
		partition(arr, left, mid);// 전반부 분할
		partition(arr, mid + 1, right);// 후반부 분할
		merge2(arr, left, right);// 2개로 나뉜 배열을 병합해주는 메서드 호출
	}// --------------------------

	static void merge(int[] a, int left, int right) {
		int tmp[] = new int[a.length];// 임시 저장소
		int index;
		int pc = (left + right) / 2;
		int pl = left;// 첫번째 배열방의 인덱스를 저장
		int pr = pc + 1;// 두번째 배열방의 인덱스를 저장
		index = left;
		while (pl <= pc && pr <= right) {
			tmp[index++] = a[pl] < a[pr] ? a[pl++] : a[pr++];
		}
		int i;
		if (pl > pc) {
			for (i = pr; i <= right; i++)
				tmp[index++] = a[i];
		} else {
			// 반대인 경우는 왼쪽에 있는 부분배열의 남은 값을 전부 복사
			for (i = pl; i <= pc; i++)
				tmp[index++] = a[i];
		}
		for (i = left; i <= right; i++)
			a[i] = tmp[i];// 원본배열에 임시배열값을 카피
	}// ------------------------------------------

	static void merge2(int[] arr, int left, int right) {
		int tmp[] = new int[arr.length];
		int index = 0;
		// 비교해서 병합해준 뒤
		int pc = (left + right) / 2;
		int pl = left;
		int pr = pc + 1;
		index = left;
		while (pl <= pc && pr <= right) {
			tmp[index++] = (arr[pl] < arr[pr]) ? arr[pl++] : arr[pr++];
			// 두 배열 중 더 작은 값을 tmp배열에 넣어준다
		}
		// 남은 것들이 있으면 옮기자
		int i;
		if (pl > pc) {
			for (i = pr; i <= right; i++)
				tmp[index++] = arr[i];
		} else {
			for (i = pl; i <= pc; i++)
				tmp[index++] = arr[i];
		}
		// tmp에 있는 값을 다시 arr에 옮겨준다
		System.out.println(left + "/" + right);
		for (i = left; i <= right; i++) {
			arr[i] = tmp[i];
		}
		// System.out.println(Arrays.toString(tmp));

	}// --------------------------

}//////////////////////////////////
