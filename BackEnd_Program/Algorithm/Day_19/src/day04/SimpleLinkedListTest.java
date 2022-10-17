package day04;

public class SimpleLinkedListTest {

	public static void main(String[] args) {
		SimpleLinkedList list=new SimpleLinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.print();
		list.addLast(40);
		list.print();
		SimpleLinkedList.Node node=list.get(3);
		System.out.println(node.data);
		
		list.remove(20);
		list.print();

	}

}
