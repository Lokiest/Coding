package day06;

public class Polymorphism {

	public static void main(String[] args) {
		Thor t1 = new Thor("Thor3", "Th", 3);
		System.out.println(t1.showInfo());
		
		Loki l1 = new Loki("Loki3", "lie33", 3);
		System.out.println(l1.showInfo());
		l1.showInfo("---------Loki Info---------");
		
		God g1 = new God("Din", "Super");
		System.out.println(g1.showInfo());
		
		//부모 자식 상속관계에서, 부모타입의 변수를 선언하고 자식객체로 생성 가능
		//거꾸로는 불가능
		//위와 같은 경우, 참조변수로 참조할 수 있는 범위 제한이 존재
		//[1] 부모로부터 상속받은 변수, 메소드는 가능
		//[2] 자식이 갖는 고유한 변수, 메소드는 불가능
		//[3] 자식이 오버라이드한 메소드가 있는 경우, 오버라이드한 메소드를 우선 호출
		
		God gs= new Loki("Loki5", "lie55", 5);
		System.out.println(gs.name);
		System.out.println(gs.ability);
//		System.out.println(gs.rank);
		System.out.println(gs.showInfo());
//		gs.showInfo("Info");
		System.out.println(((Loki)gs).rank);
		((Loki)gs).showInfo("Info");
		
		Loki ll = (Loki)gs;
		
		God gt= new Thor("thor5", "thor55", 44);
		System.out.println(gt.name);
		System.out.println(gt.ability);
		System.out.println(((Thor)gt).avengers);
		System.out.println(gt.showInfo());
		
		//t1 l1 g1 gs ll gt 배열로 저장
		// 반복문 이용해서 각 객체 정보 출력
		// 로키 객체는 타이틀 붙여서 출력 >> instanceof
		God[] arr = {t1, l1, g1, gs, ll, gt};
		for(God p:arr) {
			if (p instanceof Loki) {
				((Loki)p).showInfo("Info--------------------");
			} else {
				System.out.println("------------------------------------");
				System.out.println(p.showInfo());
			}
		}
	}

}
