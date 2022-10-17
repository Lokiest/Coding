package day02;

import java.util.*;

public class Q11_Pallindrome {
	
	public String isPallindrome(String str) {
		String res = "";
		int len = str.length();
		str = str.toLowerCase();
		for (int i=0;i<len/2;i++) {
			char c1 = str.charAt(i);
			char c2 = str.charAt(len - 1 - i);
			if(c1 != c2) {
				res = "NO";
				return res;
			}
		}
		res ="OK";
		return res;
	}
	
	public String isPallindromeApi(String str) {
		//String : 원본 문자열은 불변
		str = str.toUpperCase().replaceAll("[^A-Z]", "");
		StringBuilder builder = new StringBuilder(str);
		String s = builder.reverse().toString();
		System.out.println(s);
		if (str.equalsIgnoreCase(s)) {
			return "OK";
		}
		return "NO";
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 입력 : ");
		String str = sc.next();
		Q11_Pallindrome app = new Q11_Pallindrome();
		System.out.println(app.isPallindromeApi(str));
		
	}

}
