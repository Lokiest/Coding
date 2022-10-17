package day04;

public class MyArrayListTest {

	public static void main(String[] args) {
		//MyArrayList를 생성해서
		//정수형 객체를 몇개 저장한 후에 반복문 이용해서 한꺼번에 출력하기
		
		MyArrayList<Integer> arr=new MyArrayList<>();//초기 용량 :5
		arr.add(10);
		arr.add(20);
		arr.add(30);
		arr.add(40);
		System.out.println("arr.size(): "+arr.size());
		arr.add(50);
		arr.add(60);
		System.out.println("arr.size(): "+arr.size());
		
		for(int i=0;i<arr.size();i++) {
			Integer ival=arr.get(i);
			System.out.println(ival);
		}
//		arr.remove(-6);
		arr.remove(1);
		System.out.println("---삭제 후------------");
		for(int i=0;i<arr.size();i++) {
			Integer ival=arr.get(i);
			System.out.println(ival);
		}
		
		MyArrayList<String> arr2=new MyArrayList<>();
		
		arr2.add("Hello");
		arr2.add("Hi");
		
		String str=arr2.get(1);
		System.out.println(str);
	}

}
