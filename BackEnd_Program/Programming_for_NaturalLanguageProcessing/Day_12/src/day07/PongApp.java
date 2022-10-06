package day07;

public class PongApp {
	
	//boolean startsWith(String str),
	//boolean endWith(String str)
	public static void login(String name) throws NotSupportedNameException {
		//퐁씨 환영
		if(name.startsWith("퐁")) {
			System.out.println("Welcome");
		}
		
		//콩씨 안돼
		else if (name.startsWith("콩")) {
			throw new NotSupportedNameException("Can not");
		}
		else {
			throw new NotSupportedNameException("Nothing");
		}
		
	}

	public static void main(String[] args) {
		
		try {
			PongApp.login(args[0]);
		} catch (NotSupportedNameException e) {
			String msg = e.getMessage();
			System.out.println(msg);
		} catch (Exception e) {
			System.out.println("명령줄 인수");
		}

	}

}
