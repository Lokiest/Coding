
public class If4 {

	public static void main(String[] args) {
		
		System.out.println(args[0]);
		
		String id = "DoRyeon";
		String IDinput = args[0];
		
		String pwd = "12345";
		String pwd2 = "67890";
		String pwdinput = args[1];
		
		//if (id == IDinput) {
		boolean pwdisTrue = (pwdinput.equals(pwd) || pwdinput.equals(pwd2));
		
		if (IDinput.equals(id) && pwdisTrue) {
			System.out.println("Welcome");
		} else {
			System.out.println("Who're u?");
		}

	}

}
