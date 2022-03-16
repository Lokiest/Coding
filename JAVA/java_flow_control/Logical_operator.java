
public class LogicalOperator {

	public static void main(String[] args) {
		
		//AND operator
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && false);
		
		//OR operator
		System.out.println(true || true);
		System.out.println(true || false);
		System.out.println(false || false);
		
		//NOT operator
		System.out.println(!true);
		System.out.println(!false);
		System.out.println(!false || false);
		System.out.println(!false && false);
		

	}

}
