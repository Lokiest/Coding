package day08;

import java.util.*;
/*ArrayList
 *  - java.util.List계열
 *  - Vector와 기능은 동일
 *  - Vector는 메서드들이 동기화가 구현되어 있는 반면,
 *    ArrayList는 동기화되어 있지 않음 => 가볍다 =>웹에서 주로 사용
 * 
 * */

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<String> arrList = new ArrayList<>();
		arrList.add("Java");
		arrList.add("HTML");
		arrList.add("CSS");
		System.out.println(arrList.size());
		
		//iterator() 메소드 이용해서 출력
		Iterator it = arrList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("------------------------");
		
		Object[] arr = arrList.toArray();
		for(Object obj:arr)
			System.out.println(obj);
		
		System.out.println("------------------------");
		
		String str = arrList.get(2);
		System.out.println(str);

		System.out.println("------------------------");
		
		Collections.sort(arrList);
		it = arrList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("------------------------");
		
		// List<T> Arrays.asList(...);
		// 매개변수로 전달된 객체들을 ArrayList에 담아서 반환해주는 메소드
		List<Person> list = Arrays.asList(new Person("***", 22), 
				new Person("(((", 32), new Person("^^^", 55));
		System.out.println(list.size());
		
		for(Person p:list) {
			System.out.println(p.getName() + " " + p.getAge());
		}
		
		Iterator<Person>ir = list.iterator();
		
		//beforeFirst()
		while (ir.hasNext()) {
			Person p = ir.next();
			System.out.println(p.getName());
		}
		
	}

}
