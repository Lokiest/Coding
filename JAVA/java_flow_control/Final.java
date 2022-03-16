
public class Final {

	public static void main(String[] args) {
		
		//String[] users = {"IronMan", "Thor", "Loki"};
		String[][] users = {
				{"IronMan", "1111"},
				{"Thor", "2222"},
				{"Loki", "3333"}
		};
		
		String IDinput = args[0];
		String PWDinput = args[1];
		
		boolean Login = false; //flag
		for (int i = 0; i < users.length; i++) {
			String[] Current = users[i];
			if (Current[0].equals(IDinput) && Current[1].equals(PWDinput)) {
				Login = true;
				break;
			}
		}
		if (Login = true) {
			System.out.println("Welcome");
		} else {
			System.out.println("Who're u?");
		}

	}

}
