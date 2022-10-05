package day06;

public class ShapeTest {

	public static void main(String[] args) {
		System.out.println("각 도형의 면적");
		System.out.printf("가로 : %d, 세로 : %d인 도형 면적 -----%n", 8, 10);
		
		Rectangle r = new Rectangle();
		r.area(8, 10);
		
		Triangle t = new Triangle();
		t.area(8, 10);
		
		//추상클래스는 타입선언은 할 수 있으나, 인스턴스화는 불가
		Circle cc = new SubCircle();
		((SubCircle)cc).area(8);
		
		SubCircle c = new SubCircle();
		c.area(8);
		
		Shape sr = new Rectangle();
		sr.area(5, 6);
		
		Shape[] arr = {r, t, cc, c, sr};
		for(Shape i:arr) {
			System.out.println("----------------------");
			if(i instanceof SubCircle) {
				((SubCircle)i).area(12);
			} else {
				i.area(12, 25);
			}
		}
	}
	
	
}
