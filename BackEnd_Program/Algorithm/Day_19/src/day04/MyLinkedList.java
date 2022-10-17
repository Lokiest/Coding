package day04;

import java.util.Comparator;

//제너릭 링크드리스트
/*head --->[A:next]--->[B:next]--->[C:next]-->[D:next]-->null
 * [1] 노드가 1개 있는지 판별은?: head --->[A:next]-->null
 * 		  (head.next==null)?
 * [2] 노드가 2개 있는지 판별은?: head --->[A:next]--->[B:next]--->null
 * 		  (head.next.next==null)?
 * [3] 선택한 노드가 꼬리노드인지 판별은?
 *        (선택한노드.next==null)?
 * */
public class MyLinkedList<T> {
	Node<T> head=null;//머리 포인터. 처음에는 비어있는 상태. 머리 노드를 가리킬 예정
	Node<T> currentN=null;//선택 노드를 참조
	
	static class Node<T>{
		T data; //데이터
		Node<T> next;//뒤쪽을 가리킬 포인터
		
		public Node(T data, Node<T> next) {
			this.data=data;
			this.next=next;
		}
		
	}//inner class//////
	//새로운 노드를 마지막에 덧붙이는 메서드
	public void addLast(T newData) {
		if(head==null) {//비어있는 노드라면
			addFirst(newData);		
		}else {
			Node<T> end=new Node<T>(newData, null);//끝에 붙을 새노드
			Node<T> ptr = head;
			while(ptr.next!=null) {//끝이 아니면
				ptr=ptr.next;//계속 탐색
			}//while---				
			ptr.next=currentN=end;
		}
	}//addLast()-------------------------
	//노드를 맨 앞에 삽입하는 메서드
	public void addFirst(T newData) {
		Node<T> ptr=head;//머리노드를 참조하는 포인터. c
		Node<T> newNode=new Node<>(newData, ptr);
		head=currentN=newNode;	
	}//----------------------------------
	//머리 노드 삭제 메서드-----
	public void removeFirst() {
		if(head!=null) {
			head =currentN=head.next;//두번째 노드를 머리노드로 만든다
		}
	}//----------------------------------
	//꼬리 노드 삭제 메서드
	public void removeLast() {
		if(head!=null) {
			if(head.next==null){//노드가 하나만 있다면==> 머리노드를 삭제
				removeFirst();
			}else {
				Node<T> ptr = head;
				while(ptr.next.next!=null) {
					ptr=ptr.next;
				}
				ptr.next=null;
				currentN=ptr;
			}//else----
		}//if------------------
	}//-----------------------------------
	
	//특정 노드를 삭제하는 메서드
	public void remove(Node<T> p) {
		if(head!=null) {
			if(p==head) {//삭제할 노드가 머리 노드라면
				removeFirst();
			}else {
				Node<T> ptr=head;
				while(ptr.next!=p) {//삭제할 노드가 아니라면 계속 탐색
					ptr=ptr.next;
					if(ptr==null) return;
					//끝까지 같는데 찾지 못했다면 리턴
				}//while------
				ptr.next=p.next;
				//삭제할 노드 p와 같은 노드를 찾았다면 그 다음 주소값을 포인터노드의 다음 주소로 전달한다
				currentN=ptr;
			}
		}//if------		
	}//---------------------------
	
	//선택 노드를 삭제하는 메서드
	public void removeCurrentNode() {
		remove(currentN);
	}//---------------------------------
	
	//전체 노드를 삭제하는 메서드
	public void clear() {
		while(head!=null) {
			removeFirst();
		}
		currentN=null;
	}//----------------------------------
	
	//선택 노드를 하나 뒤쪽으로 진행시키는 메서드
	public boolean next() {
		if(currentN==null||currentN.next==null) {
			return false;
		}
		currentN=currentN.next;
		return true;
	}//-----------------------------
	
	//전체 노드를 출력하는 메서드
	public void print() {
		System.out.println("******************");
		Node<T> ptr=head;//처음에는 머리노드에서 시작
		while(ptr!=null &&ptr.next!=null) {
			System.out.print(ptr.data+"->");//참조하는 데이터를 출력
			ptr=ptr.next;//한칸식 이동
		}//while----------
		if(ptr!=null)
			System.out.println(ptr.data);
	}//------------------------------------
	
	public void printCurrentNode() {
		System.out.println("-----------------");
		if(currentN==null) {
			System.out.println("선택한 노드가 없습니다");
		}else {
			System.out.println("선택한 노드=>"+currentN.data);
		}
	}//-------------------------------
	
	//특정 노드를 검색하는 메서드
	public T search(T obj, Comparator<? super T> cobj) {
		Node<T> ptr=head;
		while(ptr!=null) {
			if(cobj.compare(obj, ptr.data)==0) {//검색에 성공했다면
				currentN=ptr;
				return ptr.data;
			}//if---
			ptr=ptr.next;
		}//while-----
		return null;
	}//-----------------------------------
}///////////////////////////////






