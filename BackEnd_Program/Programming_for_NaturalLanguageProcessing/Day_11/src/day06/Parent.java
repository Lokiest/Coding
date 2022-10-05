package window.java;

/*
 * private : 자기 클래스 내에서만 접근 가능
 * 생략형    : 같은 패키지 내에서만 접근 가능
 * protected: 같은 패키지 + 부모자식 상속관계면 접근 가능
 * public : 어디서든 접근 가능
 * 
 * */

public class Parent {
	public int publicVar = 10;
	protected int protectedVar = 20;
		int defaultVar = 30;
	private int privateVar = 40;
}
