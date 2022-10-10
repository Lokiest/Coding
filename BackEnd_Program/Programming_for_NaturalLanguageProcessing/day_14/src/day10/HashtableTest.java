package day10;

import java.util.*;
import java.awt.*;

/*Map계열
 * Hashtable
 * - Object유형을 저장할 수 있다
 * - key와 value값을 매핑하여 저장한다.
 * - key값의 중복을 허용하지 않는다.
 * - 무순서
 * - 데이터가 75%차면 자동으로 저장 역역을 확대한다.
 * - 데이터 저장: Object put(Object key, Object value)
 * - 데이터 꺼내기: Object get(Object key)
 * */

public class HashtableTest {

	public static void main(String[] args) {
		Hashtable h = new Hashtable(20, .8f); //초기용량 : 20, 적재율 : 0.8
		h.put("하나", 1); //K : string, V : Integer
		h.put("둘", "two");		
		h.put("파랑", "blue");		
		h.put("빨강", java.awt.Color.red);		
		
		Object obj = h.get("하나");
		Integer i1 = (Integer)obj;
		System.out.println(i1);

		Color cr = (Color)h.get("빨강");
		System.out.println(cr);
		
		//Generic
		Hashtable<String, Integer> h2 = new Hashtable<>();
		h2.put("~~", 1);
		h2.put("@@", 2);
		h2.put("##", Integer.valueOf(30000));
		h2.put("@@", 22);
		//key값의 중복을 허용하지 않음
		//나중에 저장한 값으로 덮어쓰기
		
		Integer age = h2.get("@@");
		System.out.println(age);
		System.out.println(h2.size());
		
		Enumeration<String> en = h2.keys();
		while (en.hasMoreElements()) {
			String key = en.nextElement();
			System.out.println(key);
		}
		
		Enumeration<Integer> en2 = h2.elements();
		for(;en2.hasMoreElements();) {
			System.out.println(en2.nextElement());
		}
		
		Set<String> set = h2.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		
		for(String str:set)
			System.out.println(str);
		
		Collection<Integer> col = h2.values();
		for(Integer i :col)
			System.out.println(i);
		
		System.out.println(h2.containsKey("@@"));
		System.out.println(h2.containsValue(Integer.valueOf(30000)));
		
		h2.clear();
		System.out.println(h2.size());
		
	}

}
