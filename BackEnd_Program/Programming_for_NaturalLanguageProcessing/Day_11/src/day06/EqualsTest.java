package day06;

public class EqualsTest {

	public static void main(String[] args) {

		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = o2;
		
		System.out.println(o1.equals(o2));
		System.out.println(o2.equals(o3));
		System.out.println(o1.equals(o3));
		
		String s1 = new String("Hi");
		String s2 = new String("Hi");
		String s3 = "Hi";
		String s4 = "Hi";
		
		System.out.println(s1 == s2); //주소값 비교
		System.out.println(s2 == s3);
		System.out.println(s3 == s4);
		System.out.println(s1.equals(s2)); //내용비교 > override
		System.out.println(s2.equals(s3));
		System.out.println(s3.equals(s4));
	}

}
