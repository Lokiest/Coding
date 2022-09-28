package day02;

public class Primitive3 {
	public static void main(String[] args) {
		print("===================문자형===================");
		//문자형 : char (2byte ~ 16bit), 유니코드 체계 사
		char c = 'A';
		print("c = " + c);
		char c2 = '\uff34'; //유니코드 
		print("c2 = " + c2);
		print("c2+1 = " + (c2+1)); //아스키코드값을 반환
		//char + int = 큰 자료유형으로 자동형변환이 발생
		//int보다 작은 유형 데이터가 연산에 사용될 경우 자동으로 int유형으로 형변환 발생
		//int보다 작은 유형 : byte, short, char
		
		byte b1 = 10;
		byte b2 = 20;
		int b3 = b1 + b2;
		print("b3 = " + b3);
		
		byte b4 = (byte)(b2-b1);
		//강제적 형변환
		print("b4 = " + b4);
		
		byte b5 = (byte)128;
		print("b5 = " + b5);
		/*
		 *    128
		 *     64 ... 0
		 *     32 ... 0
		 *     16 ... 0
		 *      8 ... 0
		 *      4 ... 0
		 *      2 ... 0
		 *      1 ... 0
		 *      
		 *       128: 00000000 00000000 00000000 10000000   <=int형
		 * (byte)128: 10000000 
		 * */
		
		char c1 = 'A';
		char d= (char)(c1+1);
		print("d = " + d);
		
		boolean boo1 = true;
		boolean boo2 = false;
		boolean boo3 = 2 > 5;
		//자바의 논리형은 0,1로 호환 x, 형변환도 x
		
	}
	
	public static void print(String str) {
		System.out.println(str);
	}
}
