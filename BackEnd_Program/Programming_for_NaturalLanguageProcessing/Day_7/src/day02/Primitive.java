package day02;

public class Primitive {
	public static void main(String[] args) {
		//public static : modifier(지정자, 제한자, 한정자)
		//void : 반환타입을 지정하는 부분이 void라면 반환값이 없는 것
		//String[] : 문자열 유형의 배열타
		System.out.println("----------------정수형----------------");
		//byte < short < int < long
		byte bt1 = -128; //1byte : -128 ~ 127
		byte bt2 = 127;
		System.out.println("bt1 : " + bt1);
		System.out.println("bt2 : " + bt2);
		
		short st = 25000; //2byte : -2^15 ~ 2^15 - 1
		System.out.println("st : " + st);
		
		int i = 2500000;
		
		long ln1 = 40000000;
		long ln2 = 40L; //접미사 L을 붙인다 
		System.out.println("ln1 : " + ln1);
		System.out.println("ln2 : " + ln2);
		
		int a1 = 010; //8진수의 정수 (접두어가 0이면 8진수)
		int b1 = 011;
		System.out.println("a1 : " + a1);
		System.out.println("b1 : " + b1);
		
		int c1 = 0x1af; //16진수의 정수 (접두어 x)
		System.out.println("c1 : " + c1);
	}
	public static int getNum() {
		//반환타입 int로 지정, return 필요
		return 100;
	}
	
	
}
