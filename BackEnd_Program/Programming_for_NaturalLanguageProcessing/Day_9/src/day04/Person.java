package day04;

public class Person {
	String name;
	int age;
	String skill;
	String profile;
	boolean state; // default: false
	//true 구직중, false 구직중이 아님
	
	public String memberInfo() {
		String str = name+"님의 정보----\n";
		str+= "나이 : "+age+"\n";
		str+= "기술 : "+skill+"\n";
		str+= "이력서 : "+profile+"\n";
		
		return str;
	}
	
	public void changeState() {
		state = !state;
	}
	
	public void openProfile() {
		if(state) {
			System.out.println(memberInfo());
		}else {
			System.out.println(name+"님의 정보는 공개되지 않았습니다");
		}
	}
}
