package day06;
//final + class : 상속받지 못함
class Base {
	int a;
}

class Child// extends Base [x] 
{
		void foo() {
			System.out.println("foo()");
		}
		final void bar() {
			System.out.println("bar()");
		}
}

class Demo extends Child {
	//final + 변수 : 값 할당하지 못 함
	public static final int OK = 100;
	@Override
	protected void foo() {
		System.out.println("Foo()###");
	}
}
public class FinalTest {

	public static void main(String[] args) {
		System.out.println(Demo.OK);

	}

}
