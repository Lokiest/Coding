package day02;

public class Q12_PrimeNumber {

	public static void getPrime() {
		int count = 0;
		for (int i = 2; i <= 1000; i++) {
			for (int j = 2; j <= i; j++) {
				if (i % j == 0)
					count++;
			}
			if (count == 1)
				System.out.println(i + " ");
			count = 0;
		} // for---------
	}

	public static void main(String[] args) {

		getPrime();

	}

}
