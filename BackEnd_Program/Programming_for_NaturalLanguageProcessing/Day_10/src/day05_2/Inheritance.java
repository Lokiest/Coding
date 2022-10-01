package day05_2;
//부모클래스 : Super class, Base class
//상속 받을 때는 extends 사용
//자바는 단일 상속, extends로 상속받는 클래스는 1개만 가능

class God {
	String name;
	String ability;
	
	public String showInfo() {
		return "name : " + name + "\nability : " + ability + "\n";
	}
}

//자식 클래스 : Sub class, Derived clss
//Loki is a God >> 형태가 성립이 되어야 가능
//상속관계에 있을 때, 메서드 오버라이딩이 가능 >> 부모가 가진 메서드를 변형해서 사용하기
//오버라이딩 조건 : 메소드 이름이 부모와 동일해야, 메소드 매개변수 개수+데이터 타입+순서도 같아야,
//메소드의 반환타입도 같아야, 메소드의 접근 지정자는 부모클래스와 동일하거나 접근범위가 더 넓어야
//예외의 경우 부모 클래스의 메소드와 동일하거나 더 구체적인 예외를 발생시켜야
class Loki extends God {
	
	int rank;
	public Loki(String name, String ability, int rank) {
		this.name = name;
		this.ability = ability;
		this.rank = rank;
	}
	
	//오버라이드
	@Override //오버라이드 조건 적용
	public String showInfo() {
//		return "name : " + name + "\nability : " + ability + "\nrank : " + rank + "\n";
		return super.showInfo() + "rank : " + rank + "\n";
	}
	
	//오버로드
	public void showInfo(String title) {
		System.out.println(title);
		//나머지 추가하려면
		System.out.println(this.showInfo());
	}
	
	public void showInfo(String title, int rank) {
		this.showInfo(title);
		this.rank += rank;
		System.out.println("rankUp");
		System.out.println("rank : " + rank);
	}
}

class Thor extends God{
	int avengers;
	public Thor(String name, String ability, int avengers) {
		this.name = name;
		this.ability = ability;
		this.avengers = avengers;
	}
	
	//오버라이드
	@Override
	public String showInfo() {
//			return "name : " + name + "\nability : " + ability + "\navengers : " + avengers + "\n";
		return super.showInfo() + "avengers : " + avengers + "\n";
	}
}

public class Inheritance {

	public static void main(String[] args) {
		//God 객체 생성하고, 메서드로 정보 출력
		God g = new God();
		g.name = "Odin";
		g.ability = "everything";
		System.out.println(g.showInfo());
		
		//Loki
		Loki l = new Loki("로키", "Lie", 10);
		System.out.println(l.showInfo());
		
		//Thor
		Thor t = new Thor("토르", "Thunder", 3);
		System.out.println(t.showInfo());
		
		Loki l2 = new Loki("Lokie", "SuperLie", 10);
		System.out.println(l2.showInfo());
		l2.showInfo(">>>Loki Information<<<");
		l2.showInfo("###Loki Information###", 9);
		
		God[] arr = {g, l, t, l2};
		for(int i =0;i<arr.length;i++) {
			System.out.println(arr[i].showInfo());
		}
	}

}
