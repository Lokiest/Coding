package day01;

public class Q1_Max {
	public static int max2(int a, int b) {
//		int max = 0;
//		if (a>b) max = a;
//		else max = b;
		int max = Math.max(a, b);
		return max;
	}
	
	public static int max3(int a, int b, int c) {
		int max = a;
		if(b>max) {
			max = b;
		}
		if(c>max) {
			max = c;
		}
		return max;
	}
	
	public static int max4(int a, int b, int c, int d) {
//		int max = 0;
//		int temp = 0, temp2 = 0;
//		temp = (a>b)?a:b;
//		temp2 = (temp>c)?temp:c;
//		max = (temp2>d)?temp2:d;
//		return max;
		int x = max2(a,b);
		int y = max2(c,d);
		int z = max2(x,y);
		return z;
	}

	public static void main(String[] args) {
		int a = 10;
		int b = 30;
		int c = 50;
		int d = 70;
		
		int mx = max2(a,b);
		System.out.println("최대 값 : " + mx);
		
		mx = max3(a,b,c);
		System.out.println("최대 값 : " + mx);
		
		mx = max4(a,b,c,d);
		System.out.println("최대 값 : " + mx);


	}

}
