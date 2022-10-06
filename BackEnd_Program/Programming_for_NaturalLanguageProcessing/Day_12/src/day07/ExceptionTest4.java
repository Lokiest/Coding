package day07;

//try 블럭 하나에 여러 catch블럭 사용 가능 
//주의사항 : 자식 예외를 먼저 catch하고 부모 예외를 나중에 catch해야

public class ExceptionTest4 {

	public static void main(String[] args) {
		try {
			String n = args[0]; //명령줄 인수
			String n2 = args[1];
			System.out.println(n);
			System.out.println(n2);
			
			int num = Integer.parseInt(n);
			int num2 = Integer.parseInt(n2);
			System.out.println(num/num2);
			String str = null;
			System.out.println(str.toUpperCase());
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("명령줄 인수를 2개 줘야함");
			System.out.println("java day08.ExceptionTest4");
		} catch (NumberFormatException e) {
			System.out.println("수 입력");
		} catch (ArithmeticException e) {
			System.out.println("0을 입력 x");
			return;
		} catch (Exception e) {
			System.out.println("예상치 못한 오류 " + e);
		} finally { //finally절은 반드시 한번은 수행하는 블럭
					//return문이 있더라도 반드시 수행하고 제어권을 넘김
			System.out.println("실행되어야만 하는 코드");
		}
		
	}

}
