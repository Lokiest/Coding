package day04;
/*클래스의 member
 * 1. 생성자(Constructor) : 객체를 생성할 때 호출되는 일종의 메서드, new 연산자와 함께 사용
 * 			역할 - 멤버변수(인스턴스변수)들의 초기화
 * 			구성하는 방법 - public 생성자이름	([parameters]){
 * 						}
 * 					생성자 이름은 클래스 이름과 동일해야 함
 * 					반환타입은 기술 X
 * 2. 변수 - 인스턴스변수 : 객체 먼저 생성하고, 객체명.변수로 접근
 * 			, 클래스 변수 : 메모리에 가장 먼저 올라가는 변수
 * 3. 메서드 - 인스턴스 메서드 (non-static method) 객체명.메서드명()
 * 				class method (static method) 클래스명.메서드명() > 전역변수
 */
public class MyDemo {
	int x;
	static int y;
	static {
		y = 300;
	}
	//생성자
	public MyDemo() { //dafault constructor
		x = 100;
		System.out.println("MyDemo 생성자");
	}
}
