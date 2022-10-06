package day08;

import java.util.*;

public class VectorTest2 {

	public static void main(String[] args) {
		// [1] Person객체 3개 생성하세요
		// [2] Person을 저장할 Vector를 생성하고 3개 객체 저장하기
		// [3] for루프 이용해서 벡터에 저장된 Person의 이름과 나이를 출력하세요
		
		Person p1 = new Person("~~~", 22);
		Person p2 = new Person("###", 23);
		Person p3 = new Person("@@@", 32);
		
		Vector<Person> v = new Vector<>(10, 5);
		v.add(p1);
		v.add(p2);
		v.add(p3);
		v.add(p3);
		
		for (Person p:v) {
			System.out.println(p.getName() + " " + p.getAge());
		}
		
		/*Enumeration<E> elements()
		 * : 벡터에 저장된 객체들을 한꺼번에 꺼내오고자 할 때 사용.
		 * Enumeration과 Iterator인터페이스는 객체들을 집합체로
		 * 관리하도록 해주는 인터페이스이다.
		 * 이들 인터페이스에서는 각각의 객체들을 한 순간에 하나씩
		 * 처리할 수 있는 메소드를 제공한다.
		 * # Enumeration의 경우**********************************
		 * 	- boolean hasMoreElements() : 논리적 커서(첫번째 요소 직전에
		 * 				위치) 이후에 요소들이 있는지 물어서 있으면true
		 * 				없으면 false를 반환
		 *  - E nextElement(): 논리적 커서를 다음 요소로 이동하고
		 *  			현재 가리키고 있는 요소를 반환한다.
		 * # Iterator의 경우**************************************
		 * 	- boolean hasNext()
		 *  - E next() 
		 * */
		System.out.println("------------------------");
		Enumeration<Person> en = v.elements();
		
		while (en.hasMoreElements()) {
			Person p = en.nextElement();
			System.out.println(p.getName());
		}
		
		System.out.println("------------------------");
		
//		while (en.hasMoreElements()) {
//			Person p = en.nextElement();
//			System.out.println(p.getName());
//		}
		Iterator<Person> it = v.iterator();
		for(int i=1;it.hasNext();i++) {
			Person p = it.next();
			System.out.println(p.getName() + " " + i);
		}
		System.out.println("------------------------");
		
		//벡터에 저장된 요소들을 배열로 카피
		//void copyInto(Object[] anArray)
		//void removeAllElements()
		//void clear
		Person[] arr = new Person[v.size()];
		v.copyInto(arr);
		for (Person a:arr) {
			System.out.println(a.getAge());
		}
		System.out.println("------------------------");
		v.clear();
		for (Person p:v) {
			System.out.println(p.getName());
		}
		
		
	}

}
