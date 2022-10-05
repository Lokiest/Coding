package mac.java;

import window.java.*;

public class Son2 extends Parent {
	
	public void go() {
		System.out.println("publicVar : " + publicVar);
		System.out.println("protectedVar : " + protectedVar);
//		System.out.println("defaultVar : " + defaultVar);
//		System.out.println("private : " + privateVar);
	}
	
	public static void main(String[] args) {
		Son2 s = new Son2();
		s.go();
	}
}
