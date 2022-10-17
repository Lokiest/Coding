package day02;

import java.util.Scanner;

public class Q5_ArrayEqual {
	
	public int[] getArray(int a) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("요소수 입력 : ");
		int num = sc.nextInt();
		int arr[] = new int[num];
		
		for(int i=0;i<num;i++) {
			System.out.println("arr" + a +"["+i+"] : ");
			arr[i] = sc.nextInt();
		}
		return arr;
	}
	
	public boolean equalsArray(int[] a, int[] b) {
		if (a.length != b.length) return false;
		for (int i=0;i<a.length;i++) {
			if(a[i] != b[i]) return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		Q5_ArrayEqual app = new Q5_ArrayEqual();
		int[] arr1 = app.getArray(1);
		int[] arr2 = app.getArray(2);
		boolean b = app.equalsArray(arr1, arr2);
		System.out.println((b)?"같음":"다름");

	}

}
