package day04;

public class MyDemoTest {

	public static void main(String[] args) {
		MyDemo md = new MyDemo();
		
		MyDemo md2 = new MyDemo();
		MyDemo md3 = md2;
		System.out.println(md);
		System.out.println(md2);
		
		System.out.println(md2==md);
		System.out.println(md2==md3);
		
		System.out.println(md.x);
		System.out.println(md2.x);
		System.out.println(md3.x);
		
		md2.x = 500;
		System.out.println(md.x);
		System.out.println(md2.x);
		System.out.println(md3.x);
		
		System.out.println(MyDemo.y);		
		
		YDemo yd = new YDemo();
		System.out.println(yd.str);
		System.out.println(yd.pi);
		System.out.println(YDemo.add);
		
	}

}
