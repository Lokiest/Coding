package day05;

public class VendingMachine {
	private int coffee, sugar, cream;
	
	//메소드 오버로딩(다중정의)
	//[1] : 메서드 이름은 같게 구성
	//[2] : 매개변수는 자료형이 다르거나 개수가 다르거나, 순서가 달라야함
	//[3] : 반환타입은 같아도, 달라도 무방
	public void make(int coffee, int sugar, int cream) {
		
		this.coffee = coffee;
		this.sugar = sugar;
		this.cream = cream;
		int sum = coffee + sugar + cream;
		System.out.println("밀 크 커 피 " + (sum));
	}
	public void make(int coffee, int sugar) {
		this.coffee = coffee;
		this.sugar = sugar;
		int sum = coffee + sugar;
		System.out.println("설 탕 커 피 " + (sum));
	}
	public String make(int coffee) {
		this.coffee = coffee;
		return "블 랙 커 피 " + coffee;
	}
	
	public void make(int coffee, short cream) {
		this.coffee = coffee;
		this.cream = cream;
		int sum = coffee + cream;
		System.out.println("크 림 커 피 " + (sum));
	}
	
	//yuja
	public void make(Yuja a) {
		System.out.println("유 자 차 " + (a.getYuja() + a.getSugar()));
		
	}
}
