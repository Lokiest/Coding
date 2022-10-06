package day08;

public class Outer {
	int a = 10; //instance
	static int b = 20; //class
	
	public void test() {
		Inner in = new Inner();
		System.out.println(in.c);
	}
	
	class Inner { //Inner Member - non static
		int c= 30;
		public void sub() {
			System.out.println("sub()");
		}
	}
	
	static class Inner2 { //static
		int d = 40;
		static int e = 50;
		void foo() {
			System.out.println("foo()");
		}
		static void bar() {
			System.out.println("bar()");
		}
	}
}
