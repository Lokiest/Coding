package day05;

import java.util.Scanner;

/*n개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요
 * 
 * 3
Quick
Study
JobKorea

kciuQ
ydutS
aeroKboJ

 * */
public class Quiz {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇개의 단어를 뒤집을까요?");
		int n = sc.nextInt();
		String[] str = new String[n];
		System.out.println("단어를 입력하세요: ");
		for (int i = 0; i < n; i++) {
			str[i] = sc.next();
		}

//		reverseString(str);
		reverseString2(str);
	}// --------------------------

	private static void reverseString(String[] str) {
		for (String s : str) {
			char[] ch = s.toCharArray();
			int left = 0;
			int right = ch.length - 1;

			while (left < right) {
				char tmp = ch[left];
				ch[left] = ch[right];
				ch[right] = tmp;
				left++;
				right--;
			}
			String mystr = String.valueOf(ch);
			System.out.println(mystr);
		} // for-----
	}// -------------------------------

	public static void reverseString2(String[] str) {
		String[] rs = new String[str.length];
		for (int i = 0; i < str.length; i++) {
			rs[i] = "";
			for (int j = str[i].length() - 1; j >= 0; j--) {
				rs[i] += str[i].charAt(j);
			}
		}
		for (String s : rs) {
			System.out.println(s);
		}
	}// -------------------------------

}
