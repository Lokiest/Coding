package window.java;

public class Son1 extends Parent{
	
	public void go() {
		System.out.println("publicVar : " + publicVar);
		System.out.println("protectedVar : " + protectedVar);
		System.out.println("defaultVar : " + defaultVar);
//		System.out.println("private : " + privateVar);
	}
	
	public static void main(String[] args) {
		Son1 s = new Son1();
		s.go();
	}
}
