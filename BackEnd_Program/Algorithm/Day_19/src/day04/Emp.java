package day04;
//Comparator인터페이스를 상속받는 클래스를 inner class로 만들자
import java.util.*;
public class Emp {
	private String name;//이름
	private int height;//키
	public Emp() {
		
	}
	public Emp(String n, int h) {
		name=n;
		height=h;
	}
	public String toString() {
		return "["+name+" : "+height+"cm] ";
	}
	
	public static final Comparator<Emp> HEIGHT_ORDER=new HeightOrderComparator();
	//키 오름츰차순 정렬을 위한 Comparator클래스를 만들고 해당 객체를 생성하자
	static class HeightOrderComparator implements Comparator<Emp>{
		@Override
		public int compare(Emp e1, Emp e2) {
			/*if(e1.height==e2.height) return 0;
			else if(e1.height>e2.height) return 1;
			else return -1;*/
			return e1.height-e2.height;//오름차순
			//return e2.height-e1.height;//내림차순
		}		
	}////////////////////
	
	//이름 오람차순 정렬을 위한 Comarator
	public static final Comparator<Emp> NAME_ORDER=new NameOrderComparator();
	
	static class NameOrderComparator implements Comparator<Emp>{
		public int compare(Emp e1, Emp e2) {
			return e1.name.compareTo(e2.name);
		}
	}
	

}//////////////////////




