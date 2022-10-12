package day11;

public class AccountTest {

	public static void main(String[] args) {
		
		Account ac = new Account();
		
		UserIn u1 = new UserIn("개미", ac);
		UserOut u2 = new UserOut("베짱이", ac);
		
		u1.start();
		u2.start();

	}

}
