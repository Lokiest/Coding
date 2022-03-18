class Print1{
	public String Delimiter = "";
	public void A() {
		System.out.println(Delimiter);
		System.out.println("A");
		System.out.println("A");
	}
	
	public void B() {
		System.out.println(Delimiter);
		System.out.println("B");
		System.out.println("B");
	}
}

public class MyOOP3 {
	
	public static void main(String[] args) {
		Print1 p1 = new Print1();
		p1.Delimiter = "----";
		p1.A();
		p1.B();
		
		Print1 p2 = new Print1();
		p2.Delimiter = "****";
		p2.B();
		p2.A();
		
		// 1억줄
		p1.A();
		p2.A();
		// 1억줄

	}

	
}
