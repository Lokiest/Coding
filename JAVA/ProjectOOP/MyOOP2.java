class Print{
	public static String Delimiter = "";
	public static void A() {
		System.out.println(Delimiter);
		System.out.println("A");
		System.out.println("A");
	}
	
	public static void B() {
		System.out.println(Delimiter);
		System.out.println("B");
		System.out.println("B");
	}
}

public class MyOOP2 {
	
	public static void main(String[] args) {
		// 1억줄
		Print.Delimiter = "----";
		Print.A();
		
		Print.Delimiter = "****";
		Print.B();
		// 1억줄

	}

	
}
