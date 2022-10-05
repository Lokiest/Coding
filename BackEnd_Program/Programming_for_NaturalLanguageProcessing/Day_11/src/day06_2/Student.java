package day06_2;
import java.util.*;

//캡슐화하고 setter/getter를 구성하세요
public class Student {
	
	private int no;
	private String name;
	private String className;
	
	public void setNo(int no){
		this.no=no;
	}
	public void setName(String name){
		//지역변수와 멤버변수의 이름이 같을 경우에는 지역변수가 우선이다.
		//이것을 구분하기 위해 멤버변수 앞에는 this. 을 붙인다.
		//this.변수 : 자기 객체의 인스턴스변수를 참조할 때 this를 붙인다.
		this.name=name;//지역변수=지역변수 형태
	}
	public void setClassName(String className){
		this.className=className;
	}
	//getter
	public int getNo() {
		return this.no;
	}
	public String getName() {
		return name;
	}
	public String getClassName() {
		return className;
	}
	/** 학생정보를 출력해 보여주는 메서드 */
	public void printInfo() {
		System.out.println("---학생 정보----");
		System.out.println("학  번: "+no);
		System.out.println("이  름: "+name);
		System.out.println("학급명: "+className);
	}
	/**학생정보를 입력받아 멤버변수에 저장하는 메서드 */
	public void inputInfo() {
		Scanner sc=new Scanner(System.in);
		System.out.print("학번 입력: ");
		//this.no=sc.nextInt();
		setNo(sc.nextInt());
		System.out.print("이름 입력: ");
		String nm=sc.next();
		this.name=nm;
		System.out.print("학급명 입력: ");
		this.className=sc.next();
	}
	

}
