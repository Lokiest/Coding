package day07;

import java.util.*;

public class DFS_Stack {
	
	static boolean visited[] = new boolean[9];
	static int [][] G = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
	
	static Stack<Integer> sk = new Stack<>();

	public static void main(String[] args) {

		sk.push(1); //시작노드 저장
		visited[1] = true; //방문 처리

		while(!sk.isEmpty()) {
			//스택에서 노드 하나 꺼내기
			int i =sk.pop();
			System.out.print(i + " >> ");
			//꺼낸 노드와 인접한 노드 찾아서 인접 요소들이 방문하지 않은 노드라면 스택에 push
			for(int node:G[i]) {
				if(!visited[node]) { //방문하지 않은 노드라면
					sk.push(node); //스택에 저장하고
					visited[node] = true; //방문처리
				}
			}
		}
	}

}
