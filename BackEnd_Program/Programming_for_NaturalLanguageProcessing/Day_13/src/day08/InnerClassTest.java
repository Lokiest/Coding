package day08;

public class InnerClassTest {

	public static void main(String[] args) {

		Outer o = new Outer();
		System.out.println(o.a);
		System.out.println(Outer.b);
		o.test();
		
		Outer o1 = new Outer();
		Outer.Inner oi = o1.new Inner();
		System.out.println(oi.c);
		oi.sub();
		
		System.out.println(Outer.Inner2.e);
		Outer.Inner2.bar();
		Outer.Inner2 o2 = new Outer.Inner2();
		System.out.println(o2.d);
		o2.foo();
		
		Outer.Inner oi2 = new Outer().new Inner();
		oi2.sub();
		
		

	}

}
