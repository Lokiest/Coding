package day02;

import java.util.Arrays;

public class Q15_PrimeNumber4 {

	public static void getPrime() {
		int[] prime = new int[1001];
		// 1.반복문 돌면서 2~1000까지의 값을 prime에 저장
		for (int i=2;i<prime.length;i++) {
			prime[i] = i;
		}
		System.out.println(Arrays.toString(prime));
		
		// 2. 2부터 시작해서 특정 수의 배수에 해당하는 수를 모두 지운다==>0을 넣는다
		// 지울 때 자기자신은 지우지 않고, 이미 지워진 수는 건너뛴다
		for(int i=2;i<prime.length;i++) {
			if(prime[i]==0) continue; //이미 지워진 숫자 건너뛰기
			for(int j=2*i;j<prime.length;j+=i) {
				prime[j] = 0;
			}
		}
		// 3. 2부터시작해서 배열에 남아있는 수를 모두 출력한다(단, 0값은 제외하고 출력)
		System.out.println(Arrays.toString(prime));
		for(int i=2;i<prime.length;i++) {
			if(prime[i]!=0)
				System.out.print(prime[i] + ", ");
		}

	}

	public static void main(String[] args) {
		getPrime();
	}

}
