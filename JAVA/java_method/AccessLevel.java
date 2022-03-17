
class Greeting {
	//public, protected, default, private
		private static void Hi() {
			System.out.println("Hi~");
		}
}
public class AccessLevel {
	
	public static void main(String[] args) {
		//Greeting.Hi(); >> private이기 때문에
		//다른 클래스에서는 사용 불가능
		

	}

}
