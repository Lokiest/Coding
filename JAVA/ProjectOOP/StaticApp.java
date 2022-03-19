class Something {
	
	public static String Classvar = "I class var";
	public String Instancevar = "I Instance var";
	
	public static void ClassMethod() {
		System.out.println(Classvar); // OK
//		System.out.println(Instancevar); // ERROR
	}
	
	public void InstanceMethod() {
		System.out.println(Classvar); // OK
		System.out.println(Instancevar); // OK
	}
}
public class StaticApp {

	public static void main(String[] args) {
		
		System.out.println(Something.Classvar); // OK
//		System.out.println(Something.Instancevar); // ERROR
		Something.ClassMethod(); // OK
//		Something.InstanceMethod(); // ERROR
		
		Something a1 = new Something();
		Something a2 = new Something();
		
		System.out.println(a1.Classvar); // I class var
		System.out.println(a1.Instancevar); // I Instance var
		
		a1.Classvar = "changed by a1";
		System.out.println(Something.Classvar); // changed by a1
		System.out.println(a2.Classvar); //changed by a1
		
		a1.Instancevar = "changed by a1";
		System.out.println(a1.Instancevar); // changed by a1
		System.out.println(a2.Instancevar); // I Instance var
		

	}

}
