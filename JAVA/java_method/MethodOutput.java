
public class MethodOutput {
	public static String A() {
		//
		return "A";
	}
	
	public static int one() {
		//
		return 1; // return : 메소드의 끝 (뒤에 아무리 많은 코드가 있어도 출력x)
		//return 값이 어떤 타입인지 정해주어야함 
	}
					//void : return값이 없음 
	public static void main(String[] args) {
		
		System.out.println(A());
		System.out.println(one());
		
		

	}

}
