package day02;

/*알고리즘 개선 [교재 74p]
 * n이 2또는 3으로 나누어 떨어지지 않으면 2x2인 4 또는 2x3 인 6으로도 나눠 떨어지지 않는다.
 * 즉 정수 n이 소수인지 여부는 2부터 n-1까지 어떤 소수로도 나누어 떨어지지 않는다.
 * 예를 들어 7이 소수인지는 7보다 작은 소수 2,3,5로 나눗셈을 하면 충분하다
 * 이렇게 하면 계산 시간을 줄일 수 있다.
 * */

public class Q13_PrimeNumber2 {
	
	public static void getPrime() {
		int[] prime = new int[500]; //소수 저장할 배열
		int ptr = 0;
		prime[ptr++] = 2; //prime[0] = 2, ptr = 1
		int count = 0;
		for(int n=3;n<1000;n+=2) { //짝수는 먼저 배제
			int i;
			for(i=1;i<ptr;i++) {
				count++;
				if(n % prime[i] == 0) { //나누어 떨어지면 소수가 X
					break;
				}
			}
			if(ptr==i) {
				prime[ptr++] = n;
			}
		}
		
		for (int i=0;i<ptr;i++) {
			System.out.print(prime[i] + ", " );
		}
		System.out.println("\n" + count);
	}

	public static void main(String[] args) {

		getPrime();

	}

}
