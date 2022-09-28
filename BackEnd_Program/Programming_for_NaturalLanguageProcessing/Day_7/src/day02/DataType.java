package day02;

public class DataType {
	//멤버변수(인스턴스변수, 클래스변수)
	//인스턴스변수 > "객체명.변수" 식으로 접근해야 
	byte b; //default 값이 존재 0
	short s;//0
	char c;//uff000
	int i;//0
	long l;//0L
	float f;//0.0f
	double d;//0.0
	boolean boo;//false
	String str; //참조형 null
	
	
	public static void main(String[] args) {
		int k = 5; //지역변수 (local, automatic변수)
		System.out.println(k);
//		System.out.println(b); 접근 방법 오류 
		DataType obj = new DataType();
		System.out.println(obj.b);
		System.out.println(obj.s);
		System.out.println(obj.c);
		System.out.println(obj.i);
		System.out.println(obj.l);
		System.out.println(obj.f);
		System.out.println(obj.d);
		System.out.println(obj.boo);
		System.out.println(obj.str);
	}

}
