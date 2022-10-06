package day08;
//도메인 객체 (VO-Value Object, DTO-Data Transfer Object)
public class Person {
	
	private String name;
	private int age;
	
	public Person() {
		this("~", 3);
	}
	
	public Person(String n, int a) {
		name = n; age = a;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
