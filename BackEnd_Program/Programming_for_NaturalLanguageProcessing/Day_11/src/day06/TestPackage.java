package day06;

import pack.demo.my1;
import pack.demo.my2; //public이 아니면 import 불가능
import pack.demo.foo.*; //서브패키지가 있다면 서브패키지까지는 불러와야

public class TestPackage {

	public static void main(String[] args) {
		my1 m1 = new my1();
		m1.sub1();
		
		my2 m2 = new my2();
		m2.sub2();
		
		//데모 객체 생성후 호출
		pack.demo.foo.Demo dm = new pack.demo.foo.Demo();
		dm.demo1();
	}

}
