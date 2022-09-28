package day02;

public class Operator2 {

	public static void main(String[] args) {
		print("2항 연산자");
		print("5. 산술연산자");
		int a = 5;
		int b = 3;
		int c = -10;
		print("a/b = " + (a/b)); //int / int = int
		print("a%b = " + (a%b));
		
		print("6. 비트 연산자");
		print("a&b = " + (a & b));
		print("a|b = " + (a | b));
		print("a^b = " + (a ^ b));
		
		print("7. 시프트 연산자");
		/*
		1) << : 왼쪽으로 비트수만큼 이동.
				오른쪽에 남은 빈칸은 0으로 채움
		2) >> : 오른쪽으로 비트수만큼 이동.
				앞에 남은 빈칸은 부호비트로 채움
		3) >>>: 오른쪽으로 비트수만큼 이동.
				앞에 남은 빈칸은 무조건 0으로 채움
		
		*/
		print("c << 3 = " + (c<<3));
		print("c >> 3 = " + (c>>3));
		print("c >>> 3 = " + (c>>>3));
		
		print("7. 논리 연산자");
		/* 1) &
		   2) |
		   : 앞의 연산으로 결과를 알 수 있어도 뒤의
		     문장까지 비교한다.
			
        3) &&
		   4) ||
		   : &&의 경우 앞의 연산 결과가 false라면
		     뒤의 연산을 생략한다.
			 ||의 경우는 앞의 연산결과가 true라면
			 뒤의 연산을 생략한다.
		
			 [문제1] 다음 출력 결과를 예측하세요
		*/
		boolean d = true;
		boolean e = false;
		/* 1) &
		   2) |
		   : 앞의 연산으로 결과를 알 수 있어도 뒤의
		     문장까지 비교한다.
			
        3) &&
		   4) ||
		   : &&의 경우 앞의 연산 결과가 false라면
		     뒤의 연산을 생략한다.
			 ||의 경우는 앞의 연산결과가 true라면
			 뒤의 연산을 생략한다.
		*/
		print("d&e = " + (d & e));
		print("d|e = " + (d | e));
		print("d&&e = " + (d && e));
		print("d||e = " + (d || e));
		
		//[1]
		int f = 1;
		int h = f++;
		
		if ((f>++h) & (f++ ==h)) {
			f = f + h;
		}
		print("f = " + f);
		
		if ((f>++h) && (f++ ==h)) {
			f = f + h;
		}
		print("f = " + f);
		
		//[2]
		int k = 0;
		int p = 1;
		if ((k ++ == 0) | (p++ ==2)) {
			k = 42;
		}
		print("k = " + k + " p = " + p);

		if ((k ++ == 0) || (p++ ==2)) {
			k = 42;
		}
		print("k = " + k + " p = " + p);
		
		
	}
	
	public static void print(String str) {
		System.out.println(str);
	}
}
