package day04;

public class JBApp {
	
	public static void main(String[] args) {
		// 클래스 : 객체 만들어내는 틀
		// 객체 : 클래스를 통해 만들어진 구현물
		
		House h1 = new House();
		House h2 = new House();
		
		h1.ownerName = "홍도빈";
		h1.room = 15;
		h1.addr = "서울특별시 강남구 반포동";
		
		h2.ownerName = "박주호";
		h2.room = 1;
		h2.addr = "경기도 하남시 망월동";
		
		h1.printinfo();
		h2.printinfo();
		
		//rent 호출해서 거래정보 출력
		String info = h1.Price("월세(단위 : 천만) : ", 10000);
		String info2 = h1.Price("전세(단위 : 천만) : ", 1000000);
		String info3 = h1.Price("매매(단위 : 천만) : ", 3000000);
		
		System.out.println(info);
		System.out.println(info2);
		System.out.println(info3);
	}

}
