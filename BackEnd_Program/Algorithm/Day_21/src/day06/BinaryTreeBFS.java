package day06;

import java.util.*;

//
//DFS(재귀, 스택)

public class BinaryTreeBFS {

	Node root;

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	public Node makeTree() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		return root;
	}
	
	public void BFS(Node root) {
		Queue<Node> que = new LinkedList<>();
		//삽입 메소드 : add = offer
		//삭제 메소드 : remove, poll
		//검사 메소드 : peek
		que.add(root);
		int level = 0;
		
		while(!que.isEmpty()) {
			System.out.print("L" + level + " : ");
			for(int i=que.size();i>0;i--) {
				//큐에서 노드를 꺼내 출력
				Node item = que.poll();
				System.out.print(item.data + " >> ");
				
				if (item.left !=null) que.add(item.left); //왼쪽 자식 노드 큐에 추가
				if (item.right !=null) que.add(item.right); //오른쪽 자식 노드 큐에 추가
				//큐에 데이터 증가
			}
			level++;
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		BinaryTreeBFS app = new BinaryTreeBFS();
		Node root = app.makeTree();
		app.BFS(root);
		
	}

}
