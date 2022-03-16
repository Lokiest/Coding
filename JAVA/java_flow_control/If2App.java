
public class If2 {

	public static void main(String[] args) {
		
		System.out.println(args[0]);
		
		String id = "DoRyeon";
		String IDinput = args[0];
		
		String pwd = "12345";
		String pwdinput = args[1];
		
		//if (id == IDinput) {
		if (IDinput.equals(id)) {
			if (pwdinput.equals(pwd)) {
				System.out.println("Welcome");
			} else {
				System.out.println("Wrong password");
			}
		} else {
			System.out.println("Who're u?");
		}

	}

}
