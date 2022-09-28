package day02;
//Reference type (참조형)
//클래스형, 인터페이스형, 배열
//참조형은 반드시 new 연산자로 객체를 생성해서 사용해야 함
//예외 존재 : String의 경우 자주 사용하기 때문에
//기본자료형처럼 문자열값을 직접 할당하도록 하고 있음
//Int, Float, Double 등 문자열값으로 직접 할당 가능
import java.util.Date;

public class Reference {
	public static void main(String[] args) {
		Date today = new Date(); //객체 생성해서 그 객체를 today 변수 이름으로 참
		System.out.println(today);
		
		String str = new String("Hello");
		System.out.println(str);
		
		String str2 = "Blar";
		Integer i = 100;//클래스유형 : Wrapper 클래스
		System.out.println(str2);
		System.out.println(i);
		
		//+ 연산자 사용 : String 결합
		String str3 = " World";
		System.out.println(str + str3);
		
		int m = 30;
		int n = 20;
		System.out.println(m+n+" : 합");
		System.out.println(" : 합" + m+n);
		System.out.println(" : 합" + (m+n));
	}
}
