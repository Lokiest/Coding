package day03;
//Comparator 인터페이스를 상속받는 클래스를 inner class로 만들기
import java.util.*;

public class Emp {
	
	private String name;
	private int height;
	
	public Emp() {
		
	}
	
	public Emp(String n, int h) {
		name = n;
		height = h;
	}
	
	public String toString() {
		return name + " " + height + "cm";
	}
	
	public static final Comparator<Emp> HEIGHT_ORDER = new HeightOrderComparator();
	
	//키 오름차순 정렬을 위한 Comparator 클래스 만들고 해당 객체 생성
	static class HeightOrderComparator implements Comparator<Emp> {
		@Override
		public int compare(Emp e1, Emp e2) {
//			if(e1.height==e2.height) return 0;
//			else if(e1.height>e2.height) return 1;
//			else return -1;
			return e1.height - e2.height; //오름차순
//			return e1.height-e1.height; //내림차순
		}
	}
}
