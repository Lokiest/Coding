package day06_2;

import java.util.Scanner;

public class Teacher {

	private int no;
	private String name;
	private String subject;

	public void setNo(int no) {
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setSubject(String subject) {
		this.subject=subject;
	}

	// getter
	public int getNo() {
		return no;
	}

	public String getName() {
		return name;
	}
	public String getSubject() {
		return subject;
	}

	public void printInfo() {
		System.out.println("---교사 정보----");
		System.out.println("교  번: "+no);
		System.out.println("이  름: "+name);
		System.out.println("과  목: "+subject);
	}
	
	public void inputInfo() {
		Scanner sc=new Scanner(System.in);
		System.out.print("교번 입력: ");
		setNo(sc.nextInt());
		System.out.print("이름 입력: ");
		String nm=sc.next();
		setName(nm);
		System.out.print("과목명 입력: ");
		setSubject(sc.next());
	}
	
}
