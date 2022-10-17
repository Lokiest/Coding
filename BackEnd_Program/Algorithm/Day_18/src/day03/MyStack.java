package day03;

import common.*;

public class MyStack<T> {
	
	private Node<T> top = null;
	
	//inner class
	class Node<T> {
		private T data;
		private Node<T> next = null;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	public void push(T item) {
		Node<T> newNode = new Node<>(item);
		newNode.next = top; //처음에는 newNode.next에는 null이 담김
		top = newNode; //top에 방금 push한 item노드를 전달
	}
	
	public T peek() {
		if(top == null) {
			throw new EmptyException();
		}
		return top.data;
	}
	
	public T pop() {
		if (top == null) {
			throw new EmptyException();
		}
		T delData = top.data;
		top = top.next; //top.next는 이전에 push한 Node객체의 주소값을 가지고 있음 > top의 위치를 한칸 내리기
		return delData;
	}
	
	public boolean isEmpty() {
		return (top==null);
	}
	
}
