package day01;

import java.util.Scanner;
//중앙값 구할 때, 대소비교시 경우의 수가 많이 나옴 >> 나무형태가 되어 결정 트리

public class Q2_Median {
	
	public static int median(int a , int b , int c){
        int[] arr = {a,b,c};
        int temp = 0;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i+1 ; j < arr.length ; j++){
                if(arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr[1];
    }
	
	public static int median2(int a, int b, int c) {
		int res = 0;
		if(a>=b) {
			if (b>=c) {
				return b;
			} else if (a>c) {
				return c;
			} else {
				return a;
			}
		} else if (a>c) {
			return a;
		} else if(b>c) {
			return c;
		} else {
			return b;
		}
	}

	public static int median3(int a , int b , int c) {
        int[] arr = {a,b,c};
        int temp = 0;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i+1 ; j < arr.length ; j++){
                if(arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr[1];
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("3개의 정수 입력 : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int res = median(a,b,c);
		
		System.out.println("중앙값 : " + res);
		
	}

}
