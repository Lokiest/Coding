package day11;

public class ThreadTest {

	public static void main(String[] args) {
		// 1. Runnnable 객체 생성
		Snail r = new Snail();
		// 2. Thread 객체 생성
		Thread tr = new Thread(r);
		//3.strat() 호출
		tr.start();
	}

}
