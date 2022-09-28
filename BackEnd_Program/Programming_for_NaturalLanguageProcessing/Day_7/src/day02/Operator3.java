package day02;

public class Operator3 {

	public static void main(String[] args) {
		print("-----------조건연산자(삼항연산자)-----------");
		int a = 5, b = 6;
		int result = (a<b)?a:b;
		print("result : " + result);
		
		String s=(a>b)? a+"":String.valueOf(b);
		print("s : " + s);
		
		print("-----------연산 후 대입 연산자(할당연산자)-----------");
		//+=, -= 등
		int i = 3;
		i += 5;
		print("i : " + i);
		i *= 3;
		print("i : " + i);
		i %= 4;
		print("i : " + i);
		
		

	}
	public static void print(String str) {
		System.out.println(str);
	}
}
