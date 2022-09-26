package day01;
//클래스명과 파일명은 같아야함 
public class VarTest {
	int global = 100; //인스턴스 변수 
	public static void main(String[] args) {
		//변수 선언
		int a = 123;
		int b;
		int c = 0;
		
		b = 20; //초기화
		System.out.printf("a = %d, b = %d%n", a, b);
		
		//사칙연산 출력
		System.out.printf("%d + %d = %d%n", a, b, (a+b));
		System.out.printf("%d - %d = %d%n", a, b, (a-b));
		System.out.printf("%d * %d = %d%n", a, b, (a*b));
		System.out.printf("%d / %d = %d%n", a, b, (a/b));
		
		System.out.println("c = " + c); //무조건 초기값이 필요 
		
		//명명규칙 : 명사형, 소문자, 카멜표기법, 스네이크표기법, 
		//숫자로 시작하면 안됨(영문자로 시작), 특문 사용 불가(_,$제외)
		//한글, 한자 등 가능, 예약어 불가능
		
		
		
	}
}
