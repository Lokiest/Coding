package day04;

public class MyLinkedListTest {

	public static void main(String[] args) {
		MyLinkedList<String> list=new MyLinkedList<>();
		list.addLast("A");
		list.addLast("B");
		list.printCurrentNode();
		list.print();
		list.addLast("C");
		list.printCurrentNode();
		list.print();
		
		list.addFirst("D");
		list.printCurrentNode();
		list.print();
		
		list.removeFirst();
		list.printCurrentNode();
		list.print();
		
		list.removeLast();
		list.printCurrentNode();
		list.print();
		
		MyLinkedList.Node<String> delNode=new MyLinkedList.Node<>("B", null);		
		list.remove(delNode);//주소값이 다르므로 삭제되지 않음		
		list.print();
		
		list.printCurrentNode();
		list.removeCurrentNode();//선택한 노드를 삭제
		list.print();
		
		list.clear();
		list.printCurrentNode();
		list.print();
		
	}

}
