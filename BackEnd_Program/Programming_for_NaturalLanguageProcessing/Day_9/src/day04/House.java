package day04;
//객체 = 속성 + 행동양식(method)
public class House {
	//1. 속성 - 멤버변수 (has a가 성립되도록)
	int room;
	String ownerName;
	String addr;
	
	//2. 기능 - method
	public void printinfo() {
		System.out.println("House Info-------------");
		System.out.println("소유주 : " + ownerName);
		System.out.println("방 수 : " + room);
		System.out.println("주소 : " + addr);
	}
	
	public String Price(String type, int price) {
		String str = "-----" + ownerName + " 의 집 ------\n";
			str += "거래 유형 : "+ type + "\n";
			str += "가    격 : " + price + "\n";
			return str;
	}
	
}
