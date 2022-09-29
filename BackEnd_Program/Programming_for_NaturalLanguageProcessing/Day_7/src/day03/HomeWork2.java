package day03;
//배열
// 하나의 변수에 인덱스 번호를 붙여 여러 개의 데이터를 저장할 수 있도록 하는 자료구
// 자바의 배열 : 고정크기 
// 동종의 데이터만 저장 가능

public class Array {

	public static void main(String[] args) {
		//[1] 배열 선언 int []a, int a[], 크기 잡기x
		int []a;
		//[2] 메모리 할당 
		a = new int[3];
		//[3] 초기화 
		a[0] = 10;
		a[1] = 20;
		a[2] = 30;
//		a[3] = 40; 불가능 
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		System.out.println(a.length);
		
		double b[] = new double[4];
		//초기화 하지 않으면 default값이 
		System.out.println(b[0]);
		b[0] = 'A';
		b[1] = 20;
		b[2] = 10e-5;
		b[3] = .123f;
		for (int i=0;i<b.length;i++) {
			System.out.println(b[i]);
		}
		
		//모든 단계 한 번에 하는 방법
		char [] ch = {'J', 'A', 'V', 'A'}; //같은 유형만 저장 가능 
		for (int i=0;i<ch.length;i++) {
			System.out.println(ch[i]);
		}
		
		//확장 for루프
		//for(변수선언문:자료구조) {}
		for(char c:ch) {
			System.out.print(c);
		}
		
		for(double value:b) {
			System.out.println(value);
		}
	}

}
