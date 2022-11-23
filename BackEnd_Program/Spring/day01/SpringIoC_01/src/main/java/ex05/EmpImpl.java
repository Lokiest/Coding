package ex05;

import java.util.Random;

public class EmpImpl implements Emp {
	//property
	private String dept;
	private String name;
	private int sal;
	private Random ran;
	
	public EmpImpl() {
		
	}

	public EmpImpl(String name) {
		super();
		this.name = name;
	}
	
	public EmpImpl(String dept, String name) {
		super();
		this.dept = dept;
		this.name = name;
	}

	public EmpImpl(String dept, String name, int sal) {
		super();
		this.dept = dept;
		this.name = name;
		this.sal = sal;
	}
	
	public EmpImpl(Random ran) {
		super();
		this.ran = ran;
	}

	@Override
	public void info1() {
		System.out.println("name : " + name);

	}

	@Override
	public void info2() {
		this.info1();
		System.out.println("Dept : " + dept);

	}

	@Override
	public void info3() {
		this.info2();
		System.out.println("Sal : " + sal);
		
	}

	@Override
	public void info4() {
		this.info3();
		System.out.println("Number : " + ran.nextInt(100));

	}
	
}
