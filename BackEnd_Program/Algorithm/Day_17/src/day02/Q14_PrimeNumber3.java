package day02;

public class Q14_PrimeNumber3 {

	public static void main(String[] args) {
		int count = 0;
		int ptr = 0;
		int[] prime = new int[500];
		prime[ptr++] = 2;
		prime[ptr++] = 3;
		for(int n=5;n<=100;n+=2) {
			boolean flag = false;
			for(int i=1;prime[i]<=Math.sqrt(n);i++) {
				if(n % prime[i] == 0) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				prime[ptr++] = n;
			}
		}
		for(int i=0;i<ptr;i++)
			System.out.println(prime[i]);
		System.out.println(count);
	}

}
