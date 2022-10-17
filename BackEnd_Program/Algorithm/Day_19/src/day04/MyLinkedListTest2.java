package day04;

public class MyLinkedListTest2 {

	public static void main(String[] args) {
		MyLinkedList<Emp> arr=new MyLinkedList<>();
		
		//Emp객체 3개 생성해서 MyLinkedList에 저장하기
		Emp e1=new Emp("김사원",158);
		Emp e2=new Emp("이사원",167);
		Emp e3=new Emp("최사원",188);
		
		arr.addLast(e1);
		arr.addLast(e2);
		//출력해보기
		arr.print();
		
		arr.addFirst(e3);
		arr.printCurrentNode();
		arr.print();
		
		//removeFirst()/removeCurrentNode()...
//		arr.removeLast();
//		arr.print();
		
//		arr.removeFirst();
//		arr.print();
		System.out.println("---사원 검색---------------------");
		//[1] 키로 검색해보기  arr.search()메서드 호출해서
		Emp findEmp=arr.search(new Emp("",188), Emp.HEIGHT_ORDER);
		System.out.println((findEmp==null)?"해당 키를 가진 사원은 없어요": findEmp);
		
		//[2] 이름으로 검색해보기
		findEmp=arr.search(new Emp("홍길동",0), Emp.NAME_ORDER);
		System.out.println((findEmp==null)?"해당 이름의 사원은 없어요": findEmp);
		
		arr.printCurrentNode();
		arr.print();
		if(arr.next()) {
			arr.printCurrentNode();
		}
		arr.next();
		arr.printCurrentNode();
		
		arr.next();
		arr.printCurrentNode();
	}

}/////////////////////////////////////////



