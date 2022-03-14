
public class Array_Loop {

	public static void main(String[] args) {
		
		// <li>Loki</li>의 형태를 1억개 만들어야하는 경우
		String[] user = {"IronMan", "Thor", "Loki"};
		System.out.println(user[2]);
		
		for (int i = 0; i < user.length; i++) {
			System.out.println("<li> " + user[i] + " </li>");
		}
	}

}
