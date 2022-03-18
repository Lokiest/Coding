class Print2{
	public String Delimiter = "";
	public Print2(String delimiter) {
			this.Delimiter = delimiter;
	}
	public void A() {
		System.out.println(this.Delimiter);
		System.out.println("A");
		System.out.println("A");
	}
	
	public void B() {
		System.out.println(this.Delimiter);
		System.out.println("B");
		System.out.println("B");
	}
}

public class MyOOP4 {
	
	public static void main(String[] args) {
		Print2 p1 = new Print2("----");
		p1.A();
		p1.B();
		
		Print2 p2 = new Print2("****");
		p2.B();
		p2.A();
	}

	
}
