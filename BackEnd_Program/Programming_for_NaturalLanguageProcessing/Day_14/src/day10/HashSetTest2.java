package day10;

import java.util.*;

public class HashSetTest2 {

	public static void main(String[] args) {
		
		Person ps1 = new Person("홍길동",11);
		Person ps2 = new Person("김철수",12);
		Person ps3 = new Person("박민수",13);
		
		HashSet<Person> hs = new HashSet<>();	
		
		hs.add(ps1);
		hs.add(ps2);
		hs.add(ps3);
		
		for(Person p:hs) {
			System.out.println(p.getName()+" : "+p.getAge());
		}
		
		System.out.println("-----------------------");
		Person ps4 = new Person("박민수",13);
		hs.add(ps4); //중복 불가하다고 했는데? 중복의 기준
		System.out.println(hs.size());
		
		Person ps5 = ps1;
		hs.add(ps5);
		System.out.println(hs.size());
		
		for(Person p:hs) {
			System.out.println(p.getName()+" : "+p.getAge());
		}
	}
}
