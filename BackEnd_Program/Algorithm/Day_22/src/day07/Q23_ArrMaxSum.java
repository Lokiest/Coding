package day07;

import java.util.*;

public class Q23_ArrMaxSum {
	
	public static void main(String[] args) {
		Q23_ArrMaxSum app = new Q23_ArrMaxSum();
		Scanner sc = new Scanner(System.in);
		System.out.println("배열 크기 입력: ");
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		System.out.printf("%d행 %d열의 배열에 저장할 값 입력: %n",n,n);
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.printf("%d행 %d열: ",i,j);
				arr[i][j] = sc.nextInt();
			}
			System.out.println();
		}//for---
		int max = app.getArrayMaxSum(n, arr);
		System.out.println("대각선을 포함한 각 라인의 합계 중 가장 큰 합계는 "+max+"입니다.");
	}//main-----------
	
	public int getArrayMaxSum(int n, int[][] arr) {
		int[] add = new int[4]; // 행합, 열합, 대각합1, 대각합2
		int max=0;
		for(int i=0; i<n; i++) {
			add[0]=0;
			add[1]=0;
			for(int j=0; j<n; j++) {
				System.out.print(arr[i][j]+"\t");
				if(i==j) {
					add[2] += arr[i][j];
					add[3] += arr[arr.length-1 - i][j];
				}//if
				add[0] += arr[i][j];
				add[1] += arr[j][i];
			}//for j
			System.out.println();
			for(int k=0; k<add.length; k++) {
				if(max < add[k]) max=add[k];
			}//for k
		}//for i
		return max;
	}//-------------------------
}/////////////////////////////////
