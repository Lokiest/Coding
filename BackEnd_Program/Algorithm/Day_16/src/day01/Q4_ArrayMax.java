package day01;

import java.util.Scanner;

public class Q4_ArrayMax {

	public static int[] max_min(int[] arr) {
		int m[] = new int[2]; // 최대키m0, 최소키m1
		m = arr;
		int a = 0;
		if (m[0] < m[1]) {
			a = m[0];
			m[0] = m[1];
			m[1] = a;
		}
		return m;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("인원수를 입력하세요 [키의 최대, 최소 구합니다] : ");
		int num = sc.nextInt();
		int height[] = new int[num];
		// 반복문 돌면서 height에 랜덤한 키를 저장하기
		for (int i = 0; i < num; i++) {
			height[i] = (int) (Math.random() * 91 + 100);
		}
		int m[] = max_min(height);
		System.out.printf("제일 큰 키 : " + m[0] + "\n");
		System.out.printf("제일 작은 키 : " + m[1]);
	}

}
