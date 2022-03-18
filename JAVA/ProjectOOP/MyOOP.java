
public class MyOOP {
	public static String Delimiter = "";
	public static void main(String[] args) {
		// 1억줄
		Delimiter = "----";
		PrintA();
		
		Delimiter = "****";
		PrintB();
		// 1억줄

	}

	public static void PrintA() {
		System.out.println(Delimiter); //매우 중요한 코드
		System.out.println("A");
		System.out.println("A");
	}
	
	public static void PrintB() {
		System.out.println(Delimiter); //매우 중요한 코드
		System.out.println("B");
		System.out.println("B");
	}
}
