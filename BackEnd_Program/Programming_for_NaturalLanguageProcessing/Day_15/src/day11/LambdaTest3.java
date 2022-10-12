package day11;

@FunctionalInterface
interface MyFunc {
	void method();
}

@FunctionalInterface
interface YourFunc {
	void method(int a);
}

@FunctionalInterface
interface Ourfunc {
	int method(int a, int b);
}

public class LambdaTest3 {

	public static void main(String[] args) {
		MyFunc m1 = ()->System.out.println("###");
		m1.method();
		
		YourFunc y = (x) -> System.out.println("x : " + x);
		y.method(3);
		
		y = a-> {
			int res = a * 5;
			System.out.println(res);
		};
		y.method(10);
		
		Ourfunc o = (a,b) -> (int)Math.pow(a,b);
		int z = o.method(2, 5);
		System.out.println(z);

	}

}
