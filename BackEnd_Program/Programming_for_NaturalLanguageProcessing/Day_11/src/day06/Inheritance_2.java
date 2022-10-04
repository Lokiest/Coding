package day06;

class God {
	String name;
	String ability;
//	public God() {}; //기본생성자
	
	public God(String name, String ability) { //인자 생성자
		this.name = name;
		this.ability = ability;
	}
	
	public String showInfo() {
		return "name : " + name + "\nability : " + ability + "\n";
	}
}

class Loki extends God {
	int rank;
	
	public Loki(String name, String ability, int rank) {
		//super(), 기본 생성자가 필요하므로 기본 생성자를 생성하고 만들어야, 의도적으로 안만들수도
		//>> 기본생성자 없을경우
		super(name, ability);
		this.rank = rank;
	}
	
	public Loki() {
		//super(), 부모의 기본 생성자 호출
		//>> 기본생성자 없을경우
		super("Loki", "lie");
		rank = 10;
	}
	
	
	public Loki(String name, int rank) {
		this(name, "lie3", rank);
		//super()와 this()는 함께 사용 불가
		//super()도 생성자에만 호출 가능하며, 생성자의 첫번째 라인에 위치해야
	}
	
	//Override
	@Override
	public String showInfo() {
		return super.showInfo() + "rank : " + rank + "\n";
	}
	
	public void showInfo(String title) {
		System.out.println(title);
		System.out.println(this.showInfo());
	}
}

class Thor extends God{
	int avengers;
	
	public Thor(String name, String ability, int avengers) {
		//super(), 기본 생성자가 필요하므로 기본 생성자를 생성하고 만들어야, 의도적으로 안만들수도
		//>> 기본생성자 없을경우
		super(name, ability);
		this.avengers = avengers;
	}
	
	public Thor() {
		//super(), 부모의 기본 생성자 호출
		//>> 기본생성자 없을경우
		super("Thor1", "Thunder");
		avengers = 10;
	}
	
	@Override
	public String showInfo() {
		return super.showInfo() + "avengers : " + avengers + "\n";
	}
}

public class Inheritance_2 {

	public static void main(String[] args) {
		God g1 = new God("Odin", "Super Power");
		System.out.println(g1.showInfo());
		
		Loki l1 = new Loki();
		System.out.println(l1.showInfo());
		
		Loki l2 = new Loki("Loki2", 10);
		System.out.println(l2.showInfo());
		
		Loki l3 = new Loki("Loki3", "lie4", 10);
		System.out.println(l3.showInfo());
		
		Thor t1 = new Thor();
		System.out.println(t1.showInfo());
		
		Thor t2 = new Thor("Thor2", "SuperThunder", 4);
		System.out.println(t1.showInfo());
	}

}
