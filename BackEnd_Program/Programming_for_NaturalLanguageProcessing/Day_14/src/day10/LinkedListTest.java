package day10;

import java.util.*;

//순차적 데이터 저장시 : ArrayList 추천
//중간에 삽입하거나 삭제 : LinkedList 추천

public class LinkedListTest {

	public static void main(String[] args) {
		List<String> list1 = new LinkedList<>(); // FIFO
		
		Queue<String> list2 = new LinkedList<>(); //LIFO
		
		list1.add("hi");
		list1.add("h");
		list1.add("i");

		list2.offer("Hello");
		list2.offer("Hell");
		list2.offer("Hel");
		
		System.out.println(list1.get(0));
		
		Iterator<String> it = list1.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		Iterator<String> it2 = list2.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
		
		list1.add(1, "Hellll");
		System.out.println("------------------------");
		it = list1.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		
		LinkedList<String> lst = (LinkedList<String>)list2;
		lst.addFirst("Java");
		lst.addLast("JS");
		
		it2 = list2.iterator();
		while(it2.hasNext())
			System.out.println(it2.next());
		
		String str = lst.poll(); //첫번째 요소를 삭제하고 삭제한 요소를 반환
		System.out.println(str.toLowerCase());
		
		System.out.println("------------------------");
		lst.remove(2);
		it2 = list2.iterator();
		while(it2.hasNext())
			System.out.println(it2.next());
		//lst.removeFirst(), lst.removeLast()
		//pollFirst(), pollLast()
		
		List<String> arr = Arrays.asList("Bon", "Tom");
		//ArrayList 반환
		
		
	}

}
