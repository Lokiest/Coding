class Print {
	public String Delimeter;
	public void a() {
		System.out.println(this.Delimeter);
		System.out.println("a");
		System.out.println("a");
	}

	public void b() {
		System.out.println(this.Delimeter);
		System.out.println("b");
		System.out.println("b");
	}
}
public class StaticeMethod {
	
	public static void main(String[] args) {
//		Print.a("-");
//		Print.b("-");
		Print t1 = new Print();
		t1.Delimeter = "-";
		t1.a();
		t1.b();
		
//		Print.a("&");
//		Print.b("&");
		Print t2 = new Print();
		t2.Delimeter = "+";
		t2.a();
		t2.b();

	}

}
