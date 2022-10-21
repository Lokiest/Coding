package day07;

import java.util.Arrays;
import java.util.Scanner;

public class Q24_ArrMerge {

	public int[] merge(int []a,int []b) {
		int sum[] = new int[a.length+b.length];
		for(int i=0;i<a.length+b.length;i++) {
			sum[i] = (i<a.length)?a[i]:b[i-a.length];
		}
		Arrays.sort(sum);
		return sum;
	}
	
	public int[] merge2(int[]a, int[] b) {
		Arrays.sort(a);
		Arrays.sort(b);
		int pa=0;
		int pb=0;
		int c[]=new int[a.length+b.length];
		int pc=0;
		while(pa<a.length && pb<b.length) {
			c[pc++]=(a[pa]<b[pb])? a[pa++]: b[pb++];
		}
		if(pa<a.length) c[pc++]=a[pa++];
		if(pb<a.length) c[pc++]=a[pb++];
		return c;
	}

	
	public static void main(String[] args) {

		Q24_ArrMerge app = new Q24_ArrMerge();
		Scanner sc=new Scanner(System.in);
		int a[],b[];
		System.out.println("배열 1의 크기: ");
		int n = sc.nextInt();
		a=new int[n];
		System.out.println("배열 2의 크기: ");
		int m = sc.nextInt();
		b=new int[m];
		System.out.println("배열 1의 값: ");
		for(int i=0; i<n;i++) {
			a[i]=sc.nextInt();
		}
		System.out.println("배열 2의 값: ");
		for(int i=0; i<m;i++) {
			b[i]=sc.nextInt();
		}
		
		System.out.println(Arrays.toString(app.merge(a,b)));
	}
}
