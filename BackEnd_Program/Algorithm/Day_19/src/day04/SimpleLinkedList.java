package day04;

public class SimpleLinkedList {
	Node header=null;
	static class Node{
		int data;//데이터
		Node next;//뒤쪽 노드의 주소값을 가리킴=> 포인터
		public Node() {
			
		}
		public Node(int data, Node next) {
			this.data=data;
			this.next=next;
		}
	}//inner class//////
	
	public SimpleLinkedList() {
		header=new Node();
	}
	//새로운 데이터를 추가 => 마지막에 새로운 노드를 추가
	public void addLast(int newData) {
		Node end=new Node(newData, null);
		Node curN=header;
		//이미 연결된 노드들 있다면 curN의 다음 주소를 앞 커서노드로 전달하면서
		//하나씩 순회하면서 이동한다. null이 나올 때까지
		while(curN.next!=null) {
			curN=curN.next;//next로 계속 이동
		}
		//curN.next가 null이라면(즉 마지막 노드라면) 새로운 노드를 추가
		curN.next=end;
	}//----------------------
	//특정 위치에 있는 노드를 반환
	public Node get(int index) {
		Node curN=header;
		for(int i=0;i<index;i++) {
			curN=curN.next;
		}
		return curN;
	}//-----------------------
	public void remove(int delData) {
		Node curN=header;
		while(curN.next!=null) {
			//커서를 이동하면서 커서노드의 next의 데이터가 삭제할 데이터와 같다면 ==> 삭제할 데이터의 다음주소를 커서노드의 다음주소에 전달
			if(curN.next.data==delData) {
				curN.next=curN.next.next;
			}else {
				//삭제할 데이터가 아니면 => go go
				curN=curN.next;
			}
		}//while---------
	}//-----------------------------------
	public void print() {
		Node curN=header.next;
		while(curN.next!=null) {
			System.out.print(curN.data+"->");
			curN=curN.next;
		}
		System.out.println(curN.data);
	}//----------------------
}//////////////////////////////











