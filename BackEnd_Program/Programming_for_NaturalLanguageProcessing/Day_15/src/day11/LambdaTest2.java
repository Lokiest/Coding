package day11;

/*함수형 인터페이스를 선언하세요
 * - 문자열 2개를 매개변수로 받으면 두 문자열을 연결하여 반환하는 메서드로 만들려고 한다
 * 인터페이스명: StringConcat
 * 추상메서드명: makeString(s1, s2)
 * - 람다식 이용해서 구현해보가
 * */

@FunctionalInterface
interface StringConcat {
	String makeString(String a, String b);
}

public class LambdaTest2 {

	public static void main(String[] args) {
		StringConcat sc = (x, y)-> {
			return x + " " + y;
		};
		System.out.println(sc.makeString("HHH", "LLL"));
		
		StringConcat sc2 = (x,y)-> {
			return x.toUpperCase() + " " + y.toUpperCase();
		};
		System.out.println(sc2.makeString("hhh", "lll"));
		
	}

}
