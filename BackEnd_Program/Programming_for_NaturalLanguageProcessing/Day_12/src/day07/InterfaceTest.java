package day07;

interface MyInter {
	void foo(); //public, abstract가 자동으로 붙음
}

interface MyInter2 {
	String STR = "Hi"; //public, final, abstract가 자동으로 붙음
	String bar();
}

//인터페이스 상속받을 때는 implements, 다중 상속 가능
class MyClass implements MyInter, MyInter2{
	public void foo() {
		System.out.println("foo()");
	}
	
	public String bar() {
		return "bar()";
	}
}

public class InterfaceTest {

	public static void main(String[] args) {
//		MyInter mi = new MyInter(); 인터페이스로 객체화 불가
		MyInter mi = new MyClass();
		mi.foo();
//		mi.bar(); [x]
		String s = ((MyClass)mi).bar();
		System.out.println(s);
		System.out.println(((MyInter2)mi).bar());
		
		MyClass mc = new MyClass();
		mc.foo();
		System.out.println(mc.bar());
		
		//MyInter2타입 변수 선언하고 MyClass객체 생성해서
		//foo bar STR 출력
		MyInter2 mi2 = new MyClass();
		String s2 = mi2.bar();
		System.out.println(s2);
		((MyInter)mi2).foo();
		System.out.println(MyInter2.STR);
		System.out.println(MyClass.STR);
		
	}

}
