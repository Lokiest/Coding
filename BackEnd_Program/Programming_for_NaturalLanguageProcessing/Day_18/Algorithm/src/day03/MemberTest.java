package day03;

import java.util.Arrays;

public class MemberTest {

	public static void main(String[] args) {
		Member u1=new Member("홍길동",22,177);
		Member u2=new Member("홍길동",22,177);
		Member u3=new Member("홍길동",22,178);

		//equals():원래는 주소값 비교
		//==> 오버라이드함 (이름,나이,키값들을 비교)
		System.out.println(u1.equals(u2));
		System.out.println(u3.equals(u2));
		System.out.println(u1==u2);
		System.out.println(u3==u2);
		
		System.out.println(u1);
		
		Member u4=new Member("김길동",27,177);
		Member u5=new Member("이길동",12,178);
		Member[] users= {u1, u4,u5};//22 27 12
		System.out.println(Arrays.toString(users));
		System.out.println("**********************************");
		Arrays.sort(users);
		System.out.println(Arrays.toString(users));
		
	}

}
