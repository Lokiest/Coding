package day11;

//java.lang.Runnable interface 상속 받아 구현 >> 추상메소드 : run()

public class Snail implements Runnable {
	
	@Override
	public void run() {
		for (int i=0;i<5;i++) {
			System.out.println("달팽이 기는 중");
			int sec = (int)(Math.random()* 2000);
			
			try {
				Thread.sleep(sec);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
	}

	}
}
