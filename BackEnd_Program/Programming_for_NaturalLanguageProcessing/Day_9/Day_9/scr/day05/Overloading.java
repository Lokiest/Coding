package day05;

class Ironman {
	String name;
	int height;
	int power;
	
	//생성자 오버로딩
	public Ironman() { //디폴트생성자
//		name = "IronHeart";
//		height = 160;
//		power = 100;
		//this()는 생성자 안에서만 호출 가능하며
		//첫번째 줄에서 호출해야함, super()와는 함께 사용 불가
		this("ewr",111,111);
	}
	
	public Ironman(String name) {
//		this.name = name;
//		height = 170;
//		power = 300;
		this(name,222,222);
	}
	
	public Ironman(String name, int height) {
//		this.name = name;
//		this.height = height;
//		power = 200;
		this(name, height, 333);
	}
	
	//target
	public Ironman(String name, int height, int power) {
		this.name = name;
		this.height = height;
		this.power = power;
	}
	
	public String showInfo() {
		String str  = "-------------IronMan Info -------------\n";
		str += "이름 : " + name + "\n 키 : " + height + "\n 능력 : " + power;
		return str;
	}

}

class Spiderman {
	String name;
	int height;
	double speed;
	
	public Spiderman() {
		
	}
	
	public Spiderman(String name) {
		this.name = name;
		height = 175;
		speed = 200;
	}
	
	public Spiderman(String name, int speed) {
		this.name = name;
		height = 190;
		this.speed = speed;
	}
	
	//target
	public Spiderman(String name, int height, int speed) {
		this.name = name;
		this.height = height;
		this.speed = speed;
	}
	
	public String showInfo() {
		String str  = "-------------SpiderMan Info -------------\n";
		str += "이름 : " + name + "\n 키 : " + height + "\n 속도 : " + speed;
		return str;
	}
}

public class Overloading {

	public static void main(String[] args) {
		Ironman im = new Ironman();
//		im.name = "Tony";
//		im.height = 175;
//		im.power = 400;
		
		String info = im.showInfo();
		System.out.println(info);
		
		Ironman im2 = new Ironman("IronHeart");
		System.out.println(im2.showInfo());
		
		Ironman im3 = new Ironman("IronHe",190);
		System.out.println(im3.showInfo());
		
		Spiderman sm = new Spiderman("Sam");
		sm.name = "Tom";
		sm.height = 180;
		sm.speed = 300;
		
		Spiderman sm2 = new Spiderman("Toby", 300);
		
		System.out.println(sm.showInfo());
		System.out.println(sm2.showInfo());
		
		//아이언맨 저장할 배열 생성하고 반복문으로 호출
//		Ironman[] arr = {im, im2, im3};
//		for (int i =0; i<arr.length;i++) {
//			System.out.println(arr[i].showInfo());
//		}
		//instanceof 연산자
		//참조변수 instanceof 클래스명
		// : 참조변수가 클래스의 객체이면 true, 아니면 false 반환
		System.out.println("-------------------------------");
		Object[] arr = {im, im2, im3, sm, sm2};
		for(Object obj:arr) {
			if (obj instanceof Ironman) {
				Ironman imn = (Ironman)obj;
				System.out.println(imn.showInfo());
			} else if (obj instanceof Spiderman) {
				Spiderman spm = (Spiderman)obj;
				System.out.println(spm.showInfo());
			}
		}
	}

}
