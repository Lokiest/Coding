package day06;

import java.util.*;

public class BinaryTreeBFS2 {

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
		return root;
	}
	
	public int BFS(int level, Node root) {
		Queue<Node> que = new LinkedList<>();
		que.add(root);
		
		while(!que.isEmpty()) {
			int size = que.size();
			
			for (int i=0;i<size;i++) {
				Node cnode = que.poll();
				System.out.print(cnode.data + " >>> ");
				if(cnode.left==null && cnode.right==null) {
					return level; //말단 노드라면 레벨값 반환
				}
				if(cnode.left!=null) que.add(cnode.left);
				if(cnode.right!=null) que.add(cnode.right);
			}
			level++;
		}
		return 0;
	}

	public static void main(String[] args) {

		BinaryTreeBFS2 app = new BinaryTreeBFS2();
		Node root = app.makeTree();
		System.out.println(app.BFS(0, root) + "<<<");

	}

}
