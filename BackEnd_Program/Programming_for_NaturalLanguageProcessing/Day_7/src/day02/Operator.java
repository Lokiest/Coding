package day02;

public class Operator {

	public static void main(String[] args) {
		print("1. 부호 연산자");
		byte a = 5;
		byte b = 7;
		print("+a = " + (+a));
		print("-b = " + (-b));
		
		print("2. 증감 연산자");
		int c = 9;
		int d = 3;
		c++;
		d--;
		print("c = " + c);
		print("d = " + d);
		++c;
		--d;
		print("c = " + c);
		print("d = " + d); //단독으로 쓰일 때는 연산자의 위치가 의미 없음
		print("c = " + c--);
		print("d = " + d++);
		print("c = " + c);
		print("d = " + d);

		print("3. 비트별 not연산자(~)");
		int m = 42;
		print("~m = " + (~m)); //-43
		//비트로 바꿔서 연산을 해야
		
		print("4. 논리부정 연산자");
		//논리식에서만 사용
		boolean b1 = false;
		print("b1 = " + b1);
		print("!b1 = " + (!b1));
		
		print("4. 비교 연산자");
		// = : 대입, == : 비교연산자, === : 값과 위치가 같은 (java에는 없음)
		// > 기본 자료형 : 값이 같은지 비교, 참조형 : 주소값이 같은지 비교
		// != : 값이 서로 다른지, 
		int e = 5;
		float f = 5.0f;
		String g = "Hello";
		String h = new String("Hello");
		print("e == f : " + (e == f));
		print("g == h : " + (g == h));
		print("e != f : " + (e != f));
		print("g != h : " + (g != h));
		
	}
	
	public static void print(String str) {
		System.out.println(str);
	}
}
