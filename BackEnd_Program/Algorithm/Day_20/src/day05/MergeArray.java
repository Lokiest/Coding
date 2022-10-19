package day05;

import java.util.Arrays;

//정렬을 완료한 2개의 배열을 병합해보자.
public class MergeArray {

	public static void main(String[] args) {
		int[] a = { 2, 4, 6, 8, 11, 13 };
		int b[] = { 1, 2, 3, 5, 9, 12, 21, 15, 23 };
		int c[] = new int[a.length + b.length];
		System.out.println("a: " + Arrays.toString(a));
		System.out.println("b: " + Arrays.toString(b));
		System.out.println("c: " + Arrays.toString(c));

		merge(a, b, c);

		System.out.println("----배열 a와 b를 병합하여 c에 저장했습니다.----------");
		System.out.println("c: " + Arrays.toString(c));

	}

	// 정렬이 완료된 배열 a,b를 병합하여 c에 저장하는 메서드
	private static void merge(int[] a, int[] b, int[] c) {
		int pa = 0;
		int pb = 0;
		int pc = 0;
		// a에 저장된 값과 b에 저장된 값을 비교해서 더 작은 쪽을 c에 저장한다. 그러면서 작은쪽의 포인터를 증가
		/*
		 * while(pa<a.length && pb < b.length) { if(a[pa]<b[pb]) { c[pc++]=a[pa++];
		 * }else { c[pc++]=b[pb++]; } }//while---------
		 */
		while (pa < a.length && pb < b.length)
			c[pc++] = (a[pa] < b[pb]) ? a[pa++] : b[pb++];

		printProcess(a, b, c);

		while (pa < a.length)// a에 남아있는 요소를 모두 c에 저장
			c[pc++] = a[pa++];

		while (pb < b.length)// b에 남아있는 요소를 모두 c에 저장
			c[pc++] = b[pb++];

	}

	static public void printProcess(int[] a, int[] b, int[] c) {
		System.out.println("---------------------");
		System.out.println("a: " + Arrays.toString(a));
		System.out.println("b: " + Arrays.toString(b));
		System.out.println("c: " + Arrays.toString(c));
		System.out.println("---------------------");
	}

}
