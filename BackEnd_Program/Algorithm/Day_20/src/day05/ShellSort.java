package day05;

import java.util.Arrays;

/*쉘정렬 알고리즘은 삽입정렬 알고리즘의 느린 속도를 보완하기 위해 만들어진 알고리즘.
 * 데이터의 그룹을 나누어 그룹 안에서 쉘 정렬을 수행하고, 마지막에 삽입정렬을 수행하는 알고리즘이다.
 * 삽입정렬의 장점: 대부분이 정렬되어 있는 상태에 가까울 때 속도가 아주 빠르다
 *         단점: 삽입할 곳이 멀리 떨어지면 이동(대입)하는 횟수가 많다.
 *         ex) 1 2 3 4 5 0 6  식의 배열일 경우 0을 삽입하려면 총 6회에 걸쳐 요소를 이동시켜야 한다.
 *셀정렬의 시간복잡도는 O(n^1.25), 삽입정렬 O(n^2)보다는 빠르다. but안정적이진 않음 멀리 떨어진 요소를 교환함으로         
 * */
public class ShellSort {

	public static void main(String[] args) {
		int[] arr = { 23, 12, 45, 55, 2, 18, 49, 7 };
		System.out.println(Arrays.toString(arr));
//		intervalSort(arr);
		intervalSort2(arr);
		System.out.println("--셀 정렬 이후-----------------");
		System.out.println(Arrays.toString(arr));
	}
	// 23,12,7(1),55,2,18,49,7(2)
	// 23,12,7(2),7(1),55,2,18,49,

	// interval을 4, 2, 1 순으로 건너뛰기 하면서 삽입정렬을 수행한다=> 셀정렬

	static void intervalSort(int[] arr) {
		for (int interval = arr.length / 2; interval > 0; interval = interval / 2) {
			// interval: 4, 2, 1 순으로 진행된다. => 수열
			for (int k = interval; k < arr.length; k++) {
				int j;
				int tmp = arr[k];// arr[4]=2
				for (j = k - interval; j >= 0; j -= interval) {
					if (arr[j] > tmp) {
						arr[j + interval] = arr[j];// tmp보다 큰 값을 일정 간격 만큼 건너뛴 부분에 채워넣기(뒤로 밀어내기)
					} else {
						break;
					}
				} // for-----
				arr[j + interval] = tmp;
			} // for-------
		} // for-------
	}// insertSort()-------------------------
		// interval을 n배수로 증가시키면 나눈 그룹이 서로 섞이지 않고 같은 멤버로 구성될 수도 있다.
		// 이것을 개선해보자. 3*n+1 ==>interval

	static void intervalSort2(int[] arr) {
		// interval의 초기값을 구하자.
		int inter;
		for (inter = 1; inter < arr.length; inter = inter * 3 + 1)
			;// 13
//		System.out.println("inter: "+inter);
		for (; inter > 0; inter /= 3) {
			for (int k = inter; k < arr.length; k++) {
				System.out.println("k: " + k + ", inter: " + inter);
				int j;
				int tmp = arr[k];
				for (j = k - inter; j >= 0 && arr[j] > tmp; j -= inter) {
					arr[j + inter] = arr[j];
				}
				arr[j + inter] = tmp;
			}
		}
	}// ------------------------------------

}//////////////////////////////////////////////
