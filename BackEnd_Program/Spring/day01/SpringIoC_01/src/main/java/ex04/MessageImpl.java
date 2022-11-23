package ex04;

import java.util.Date;
import java.util.Random;

public class MessageImpl implements Message {
	
	private String name;
	private String greeting;
	
	private Date today;
	private Random ran;

	@Override
	public void sayHello() {
		System.out.println(greeting + " " + name);
		System.out.println("--------------------------------------------");
		System.out.println(today);
		System.out.println("--------------------------------------------");

	}

	@Override
	public void sayHi(String... names) {
		System.out.println(greeting + " ");
		if(name!=null) {
			for(String n:names) {
				System.out.print(n + ", ");
			}
		}
		System.out.println();
		System.out.println("--------------------------------------------");
		System.out.println("행운의 숫자 ? " + (ran.nextInt(100) + 1));
	}
	
	//setter, getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	public Random getRan() {
		return ran;
	}

	public void setRan(Random ran) {
		this.ran = ran;
	}
	
	
}
