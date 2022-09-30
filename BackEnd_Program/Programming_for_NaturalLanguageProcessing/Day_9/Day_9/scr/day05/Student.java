package day05;

import java.util.*;

public class Student {
	private int number;
	private String name;
	private String major;
	
	//지역변수와 멤버변수의 이름이 같을 경우에는 지역변수가 우선
	//이것을 구분하기 위해 멤버변수 앞에 this.
	//this.변수 : 자기 객체의 인스턴스 변수를 참조할 때 this 붙이기
	public void setNumber(int no) {
		number = no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMajor(String major) {
		this.major = major;
	}

	public int getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public String getMajor() {
		return major;
	}
	
	public void printInfo() {
		System.out.println("-------학 생 정 보 -------");
		System.out.println("학생 학번 : " + number);
		System.out.println("학생 이름 : " + name);
		System.out.println("학생 전공 : " + major);
	}
	
	public void inputInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("학 번 입 력 : ");
		setNumber(sc.nextInt());
		System.out.println("이 름 입 력 : ");
		String nm = sc.next();
		this.name = nm;
		System.out.println("전 공 입 력 : ");
		String mj = sc.next();
		this.major = mj;
		
	}
}
