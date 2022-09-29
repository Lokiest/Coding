package day04;

public class ArrayTest {

	public static void main(String[] args) {
		int x[] = {1,2,3,4};
		int y[];
		
		y = x;
		//y는 x가 참조한느 배열을 같이 참조하는 형태
		
		for (int i=0; i<x.length;i++) {
			System.out.println(x[i]);
		}
		System.out.println();
		for(int n:y)
			System.out.println(n);
		
		y[2] = 300;
		System.out.println(x[2]);
		System.out.println(y[2]);
		
		int a[] = {10, 20};
		int b[] = {9,8,7,6};
		int temp[];
		
		//서로의 배열을 바꿔서 참조하도록
		temp = a;
		a = b;
		b = temp; //swap
		for (int i=0; i<a.length;i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\n----------------------");
		for (int i=0; i<b.length;i++) {
			System.out.print(b[i] + " ");
		}
		
		//요소 4개 갖는 배열 선언하여 초기화하고 요소들의 평균값 구하기
		double[] arr = new double[4];
		arr[0] = 1.23;
		arr[1] = 2.82;
		arr[2] = -22.5;
		arr[3] = .78f;
		
		double sum = 0;
		for (double d:arr) {
			sum += d;
		}
		System.out.println("\n" + sum);
		double avg = sum / arr.length;
		System.out.println(avg);
		
		//[3] float 타입 배열 요소 받아들이는 배열 선언(3)
		float arr2[];
			arr2 = new float[3];
			arr2[0] = -16.1f;
			arr2[1] = (float)200.1;
			arr2[2] = 30e-7f;
		for (int i=0; i<arr2.length;i++) {
			System.out.print(arr2[i] + " ");
		}
		
		//String을 저장할 배열 생성, 배열에 문자열 3개 저장
		String[] arr3 = new String[3];
		arr3[0] = "\nHi";
		arr3[1] = new String("Hello");
		for (int i=0; i<arr3.length;i++) {
			System.out.print(arr3[i] + " ");
			if (arr3[i] != null)
				System.out.println(arr3[i].toUpperCase() + " ");
		}
		
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = o2;
		System.out.println("\n" + o1);
		System.out.println(o2);
		System.out.println(o3);
		
		//o1 o2 o3를 저장할 배열 선언하고 저장
		//for 이용해서 출력
		//Object 유형의 배열은 모든 클래스형의 객체들 저장 가능
		Object[] arr4 = new Object[5];
		arr4[0] = o1;
		arr4[1] = o2;
		arr4[2] = o3;
		arr4[3] = new String("hi");
		arr4[4] = new java.util.Date();
		
		for (int i=0; i<arr4.length;i++) {
			System.out.println(arr4[i] + " ");
		}
		
	}

}
