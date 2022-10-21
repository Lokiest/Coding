package day07;

public class DFS_Recursive {
	
	static boolean visited[] = new boolean[9];
	static int [][] G = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
	
	public static void DFS(int index) {
		visited[index] = true;
		System.out.print(index + " >> ");
		//방문한 노드와 인접한 노드를 찾아서 인접노드가 방문하지 않은 노드라면 다시 탐색
		for(int node: G[index]) {
			if(!visited[node]) {
				DFS(node);
			}
		}
	}

	public static void main(String[] args) {

		DFS(1);

	}

}
