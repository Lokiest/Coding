package day11;
//만원씩 저축하는 Thread
public class UserIn extends Thread {
	
	private Account account;
	
	public UserIn(String name, Account ac) {
		this.account = ac;
		setName(name);
	}
	
	public void run() {
		for(int i=0;i<5;i++) {
			account.save(1);
		}
	}
}
