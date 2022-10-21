package day07;

import java.util.*;

public class Q22_GradeKor {

	public int[] getKorGrade(int n, int[] kor) {
		int grade[] = new int[n];
		for(int i=0;i<n;i++) {
			int count = 1;
			for(int j=0;j<n;j++) {
				if(i==j) continue;
				if(kor[i] < kor[j]) count++;
			}
			grade[i] = count;
		}
		return grade;
	}

	public static void main(String[] args) {
		Q22_GradeKor app = new Q22_GradeKor();
		// 학생 수 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.println("학생 수 입력 : ");
		int n = sc.nextInt();
		
		// 학생 수만큼 국어 성적 입력받기
		int kor[] = new int[n];
		System.out.println("국어 성적 " + n + "개 입력");
		for (int i = 0; i < n; i++) {
			kor[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(kor));
		System.out.println(Arrays.toString(app.getKorGrade(n, kor)));

		// getKorGrade() 호출하면 각 국어 성적에 대한 등수를 배열에 담아서 return

	}

}
