package day07;

import java.util.*;

//comparable,comparator
class Player implements Comparable<Player> {
	int height;
	int weight;

	public Player(int h, int w) {
		this.height = h;
		this.weight = w;
	}

	@Override
	public int compareTo(Player p) {
		return p.height - this.height;
	}
}//////////////////


public class Q27_PlayerSelect {
	public static int choice(ArrayList<Player>arr, int n) {
		int cnt=0;//선발 인원수 
		Collections.sort(arr);
		int max=0;
		for(Player one:arr) {
			if(one.weight>max) {
				max=one.weight;
				cnt++;
			}
		}return cnt;
		//arrays.sort(배열), collections.sort(arraylist)
	}

	public static void main(String[] args) {
		Q27_PlayerSelect q=new Q27_PlayerSelect();
		Scanner sc=new Scanner(System.in);
		System.out.println("씨름선수 후보 인원수: ");
		int n=sc.nextInt();
		System.out.println("키와 몸무게 순서로 입력하세요: ");
		//ArrayList 활용해보기 
		ArrayList<Player> arr=new ArrayList<>();
		for(int i=0; i<n; i++) {
			int h=sc.nextInt();
			int w=sc.nextInt();
			arr.add(new Player(h,w));
			//Player객체 생성 
		}
		System.out.print(q.choice(arr, n));
		
	}

}
