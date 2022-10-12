package day11;
//추상메소드가 1개인 인터페이스는 함수형 인터페이스로 선언 가능
//함수형 인터페이스에 있는 메소들은 람다식으로 구현 가능

@FunctionalInterface
interface MyNum {
	int getMax(int a, int b);
}

public class LambdaTest {

	public static void main(String[] args) {
		MyNum mn = (x, y)-> {
			if (x>=y) {
				return x;
			} else {
				return y;
			}
		};
		
		int mx = mn.getMax(11, 5);
		System.out.println(mx);

		MyNum mn2 = (x,y)->(x>=y)?x:y;
		System.out.println(mn2.getMax(33, -33));
	}

}
