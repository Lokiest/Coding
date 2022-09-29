package day04;

public class Odemo {
	
	/* [1] 반환타입x 매개변수x
	 * [2] 반환타입x 매개변수o
	 * [3] 반환타입o 매개변수x
	 * [4] 반환타입o 매개변수o
	 */
	
	//[1] static
	public static void showStar() {
		System.out.println("★");
	}
	//[2]
	public void showChar(char ch) {
		System.out.println(ch);
	}
	//[3]
	public long giveMe() {
		System.out.println("giveMe---------------------");
		return 1000000000L; //반환타입이 지정된 메서드는 메서드 블럭 끝에 return문 이용해서 값 반환
	}
	//[4]
	public static long giveUs(int money) {
		System.out.println("giveUs---------------------");
		return 2*money;
	}
	
	public static void main(String[] args) {
		Odemo.showStar();
		Odemo od = new Odemo(); //생성자를 구성하지 않으면 컴파일러가 디폴트 생성자 제공
		od.showChar('C');
	

		Odemo odemo = new Odemo();
		long m = odemo.giveMe();
		System.out.println(m);
		
		long m2 = Odemo.giveUs(3000);
		System.out.println(m2);
	}

}
