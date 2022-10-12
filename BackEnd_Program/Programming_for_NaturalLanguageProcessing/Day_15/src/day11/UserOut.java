package day11;
//랜덤하게 인출하는 스레드
import java.util.*;

public class UserOut extends Thread {
	
	private Account account;
	
	public UserOut(String name, Account ac) {
		this.account = ac;
		setName(name);
	}
	
	public void run() {
		Random ran = new Random();
		
		for(int i=0;i<5;i++) {
			int val = ran.nextInt(5) + 1;
			account.get(val);
		}
	}
}
