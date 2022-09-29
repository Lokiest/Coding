package day04;

public class YDemo {
	String str = "YDemo's Variable";
	float pi; //생성자 구성하고 초기값 부여
	static int add;
	static {
		add = 3;
		//static 블럭은 main메서드보다 먼저 메모리에 올라감
	}
	public YDemo() {
		pi = 3.14f;
	}
	public void foo() {
		System.out.println("foo-------------");
		System.out.print(pi);
	}
	public static void bar() {
		System.out.println("bar-------------");
		System.out.println(new YDemo().pi);
	}
	
	public static void main(String[] args) {
		System.out.println("main() method----------------");
		System.out.println(add);
		YDemo y = new YDemo();
//		System.out.println(pi); [x]
		System.out.println(y.pi);
		
		//bar call
		YDemo.bar();
		//foo call
		new YDemo().foo();
		y.foo();
	}
}
