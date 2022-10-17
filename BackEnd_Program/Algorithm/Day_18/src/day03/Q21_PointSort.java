package day03;

import java.util.Arrays;
import java.util.Scanner;

class Point implements Comparable<Point>{
	int x;
	int y;
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public int compareTo(Point obj) {
		//x좌표 내림차순, x좌표 같을 경우 y값을 비교하여 y값도 내림차순
		if(this.x==obj.x) {
			//return this.y-obj.y; //y 오름차순
			return obj.y-this.y;//y 내림차순
		}else {
			//return this.x-obj.x;//오름차순
			return obj.x-this.x;//x좌표 내림차순
		}
	}
	
}//////////////////
public class Q21_PointSort {
	
	public static void sortingPoint() {
		Scanner sc=new Scanner(System.in);
		System.out.println("몇개의 좌표를 입력하겠습니까? : ");
		int n=sc.nextInt();
		//반복문 이용해서 x,y좌표 값을 입력받아 배열에 저장한다
		Point[] arr=new Point[n];
		for(int i=0;i<arr.length;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			Point p=new Point(x,y);
			arr[i]=p;
		}
		//Arrays.sort()활용
		Arrays.sort(arr);
		//배열 출력
		for(Point p:arr) {
			System.out.println(p.x+" "+p.y);
		}
	}

	public static void main(String[] args) {
		
		sortingPoint();
	}

}
