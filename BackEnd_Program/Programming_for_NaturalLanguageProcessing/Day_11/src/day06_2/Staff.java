package day06_2;

import java.util.Scanner;

public class Staff {
	
	private int no;
	private String name;
	private String dept;
	
	//setter, getter-------
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public void printInfo() {
		System.out.println("---사원 정보----");
		System.out.println("사  번: "+no);
		System.out.println("이  름: "+name);
		System.out.println("부  서: "+dept);
	}
	
	public void inputInfo() {
		Scanner sc=new Scanner(System.in);
		System.out.print("사번 입력: ");
		setNo(sc.nextInt());
		System.out.print("이름 입력: ");
		String nm=sc.next();
		this.name=nm;
		System.out.print("부서명 입력: ");
		this.dept=sc.next();
	}

}
