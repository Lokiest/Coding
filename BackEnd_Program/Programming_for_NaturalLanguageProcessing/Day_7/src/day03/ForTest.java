package day03;

public class ForTest {

	public static void main(String[] args) {
		//[1] for 루프 사용해서 1~10까지의 합과 곱 출력
		//[2] 1~20까지 정수 중 2 또는 3의 배수가 아닌 수를
				//출력하고, 이 수들의 총합을 구하세요.
		//[3] 1~100까지 정수를 다음과 같은 식으로
		//계산한 수식과 결과값을 출력하세요
		//1 + (-2) + 3+(-4)+5 +(-6) ....+(-100) = 결과값
		int sum = 0;
		int total = 1;
		for (int i=1;i<=10;i++) {
			sum += i;
			total *= i;
			if (i<10) {
				System.out.print(i + "+");
			}
			else
				System.out.print(i + "=");
		}
		System.out.println(sum);
		System.out.println(total);
		
		//[2]
		sum = 0;
		for (int i =1;i<=20;i++) {
			if ((i % 2 !=0) && (i % 3 !=0)) {
				System.out.print(i + " ");
				sum += i;
			}
		}
		System.out.println("의 합 : " + sum);
		
		//[3]
		sum = 0;
		int d = 0;
		for (int i = 1; i<=100; i++) {
			if (i % 2 == 0)
				d = -i;
			else
				d = +i;
			System.out.print(d + " ");
			sum += d;
		}
		System.out.println("의 합 : " + sum);
		
		//[4] A~Z를 for루프로 출력
		for (int i=65;i<=90;i++) {
			System.out.print((char)i + " ");
		}
		
		//[5] 1+(1+2)...(1+2+...+10)
		sum = 0;
		int result = 0;
		for (int i = 1;i<=10;i++) {
			sum += i;
			result += sum;
		}
		System.out.println("\nsum : " + sum);
		System.out.println("result : " + result);
	}

}
