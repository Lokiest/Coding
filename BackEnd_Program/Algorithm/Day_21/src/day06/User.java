package day06;

import java.util.Scanner;

public class User {
	
	private int no;
	private String name;
	private String tel;
	Scanner sc = new Scanner(System.in);
	
	public User() {	
	}
	
	public User(int no, String name, String tel) {
		super();
		this.no = no;
		this.name = name;
		this.tel = tel;
	}

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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public void input() {
		System.out.println("회원번호 : ");
		this.no = sc.nextInt();
		System.out.println("회원이름 : ");
		this.name = sc.next();
		System.out.println("회원연락처 : ");
		this.tel = sc.next();
	}
	
	@Override 
	public String toString() {
		return no + " : " + name + "\t" + tel + "\n";
	}
}
