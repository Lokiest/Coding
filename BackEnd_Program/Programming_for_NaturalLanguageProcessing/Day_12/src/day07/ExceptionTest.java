package day07;

public class ExceptionTest {

	public static void main(String[] args) {
		
		String fruits[] = {"apple","grape","orange"};
		
		try {
			for(int i =0;i<=3;i++) {
				System.out.println(fruits[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("배열 인덱스 초과");
		}
		System.out.println("반드시 실행되어야할 코드가 이 아래에 존재한다고 가정");
	}

}


