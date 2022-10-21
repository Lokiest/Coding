package day07;

import java.util.*;

public class Q26_SlidingWindow {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("며칠의 매출기록을 입력하실래요?");
		int n = sc.nextInt();
		System.out.println("연속 며칠의 매출을 구할까요?");
		int k = sc.nextInt();
		System.out.println(n + "일간의 매출기록을 입력하세요");
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		int max = getMaxOut(n, k, a);
		System.out.printf("연속 %d일간의 최대 매출액 : %d%n", k, max);
	}

	public static int getMaxOut(int n, int k, int[] a) {
		int max = 0, sum = 0;

		for (int i = 0; i < k; i++) {
			max += a[i];
		}
		sum = max;

		for (int i = k; i < n; i++) {
			sum += a[i];
			sum -= a[i - k];
			max = Math.max(max, sum);
		}

		return max;
	}

}
