package day05;

import java.util.Scanner;

public class Staff {
	private int number;
	private String name;
	private String dept;
	
	//setter, getter 자동완성
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
		System.out.println("-------사 원 정 보 -------");
		System.out.println("사원 사번 : " + number);
		System.out.println("사원 이름 : " + name);
		System.out.println("사원 부서 : " + dept);
	}
	
	public void inputInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("사 번 입 력 : ");
		setNumber(sc.nextInt());
		System.out.println("이 름 입 력 : ");
		String nm = sc.next();
		setName(nm);
		System.out.println("부 서 입 력 : ");
		String mj = sc.next();
		setDept(dept);
		
	}
	
}
