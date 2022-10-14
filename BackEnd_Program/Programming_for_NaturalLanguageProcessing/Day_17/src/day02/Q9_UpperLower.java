package day02;

import java.util.*;

public class Q9_UpperLower {

	public String change(String str) {
		
	String res="";
	return res;
	}

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		str.toCharArray();
		String a="";
		
		for(int i=0;i<str.length();i++) {
			char alphabet=str.charAt(i);
			if(Character.isUpperCase(alphabet)) {
				String str1=Character.toString(alphabet);
				a+=str1.toLowerCase();
			}else if(Character.isLowerCase(alphabet)) {
				String str2=Character.toString(alphabet);
				a+=str2.toUpperCase();
			}
		}System.out.println(a);
	}

}
