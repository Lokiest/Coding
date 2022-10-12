package day11;

public class Account {
	
	private int money = 10;
	private boolean flag = false;
	
	//동기화하면 해당 객체의 lock을 쥐어야만 해당 블럭을 수행 가능
	public void save(int val) {
		synchronized(this) {
			if (flag) {
				try {
					wait();
					//wait 호출되면 스레드는 수행 권한 포기하고 wait pool 가서 대기
					//이 때, 락을 반납하고 대기 상태에 들어감
				} catch (InterruptedException e) {}
			}
			
			money += val;
			System.out.printf("입금 금액 : %d, 입금 후 잔액 : %d%n", val, money);
			flag = true;
			notify();
		}
	}
	
	synchronized public void get(int val) {
		if(!flag) {
			try {
				wait();
				//wait 호출되면 스레드는 수행 권한 포기하고 wait pool 가서 대기
				//이 때, 락을 반납하고 대기 상태에 들어감
			} catch (InterruptedException e) {}
		}
		
		if (money - val < 0) {
			System.out.printf("현금 부족 : 현재 잔액 : %d, 요청 금액 : %d%n", money, val);
			flag = false;
			notify();
			return;
		}
		
		money -= val;
		System.out.printf("출금 금액 : %d, 출금 후 잔액 : %d%n", val, money);
		flag = false;
		notify();

	}
	
}
