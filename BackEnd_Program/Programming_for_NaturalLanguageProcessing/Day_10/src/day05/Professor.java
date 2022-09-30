package day05;

import java.util.Scanner;

public class Professor {
	private int number;
	private String name;
	private String subject;
	
	public void setNumber(int no) {
		number = no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public String getSubject() {
		return subject;
	}
	
	public void printInfo() {
		System.out.println("-------교 수 정 보 -------");
		System.out.println("교수 교번 : " + number);
		System.out.println("교수 이름 : " + name);
		System.out.println("교수 전공 : " + subject);
	}
	
	public void inputInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("교 번 입 력 : ");
		setNumber(sc.nextInt());
		System.out.println("이 름 입 력 : ");
		String nm = sc.next();
//		this.name = nm;
		setName(nm);
		System.out.println("전 공 입 력 : ");
		String sj = sc.next();
//		this.subject = sj;
		setSubject(sj);
		
	}
}
