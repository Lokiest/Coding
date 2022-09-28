package day02;

public class Primitive2 {
	public static void main(String[] args) {
		//실수형 : Float, Double
		float ft1 = 10.123F; //float의 부동소수점일 경우 : 접미사 F 필요
		System.out.println("ft1 : " + ft1);
		float ft2 = 900; //자동형변환 : 작은 유형에서 큰 유형으로 자동으로 형변환 발생 
		System.out.println("ft2 : " + ft2);
		
		double db1 = 123.456;
		double db2 = 7778.41d; //접미사 안붙여도 상관 x
		System.out.println("db1 : " + db1);
		System.out.println("db2 : " + db2);
		
		double db3 = 3e-2;
		double db4 = 3e+2;
		System.out.println("db3 : " + db3);
		System.out.println("db4 : " + db4);
	}
}
