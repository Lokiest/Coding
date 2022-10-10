package day10;
//스레드 구현 방법
// [1] java.lang.Thread 클래스를 상속
// [2] java.lang.Runnable 인터페이스를 상속

class SnailThread extends Thread {
	
	public SnailThread(String name) {
		this.setName(name);
		
	}
	
	@Override
	public void run() {
		for(int i = 0;i<5;i++)
			System.out.println(this.getName() + "진행");
//			try {
//				Thread.sleep(100);
//				//1초간 sleep >> block 상태로 (sleep()/IO작업시)
//			} catch(InterruptedException e) {
//				e.printStackTrace();
//				break;
//			}
			
			
	}
}

public class ThreadTest2 {
	
	public static void main(String[] args) {
		SnailThread tr1 = new SnailThread("달팽이1");
		SnailThread tr2 = new SnailThread("달팽이2");
		SnailThread tr3 = new SnailThread("달팽이3");
		
		//우선순위 부여 : 1~10 (10이 가장 우선순위 높음)
		//안먹음 ;;
//		tr1.setPriority(Thread.MIN_PRIORITY);
//		tr2.setPriority(Thread.NORM_PRIORITY);
//		tr3.setPriority(Thread.MAX_PRIORITY);
		
		tr1.start();
		tr2.start();
		tr3.start();
		
//		tr2.interrupt();
//		Thread.yield();
		//우선순위가 같거나 높은 스레드에게만 양보
		
		try {
			tr2.join();
			//tr2 스레드가 작업을 다 마칠 때까지 tr2.join() 호출한
			//스레드가 block 상태로
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("Main");
		
		
	}

}
