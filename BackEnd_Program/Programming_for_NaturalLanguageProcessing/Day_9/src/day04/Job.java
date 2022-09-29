package day04;

public class Job {
	String name;
	float score;
	String University;
	String OPic;
	
	public void Employer() {
		System.out.println("-------------구직자 Info-------------");
		System.out.println("이 름 : " + name);
		System.out.println("학 점 : " + score);
		System.out.println("대학교 : " + University);
		System.out.println("OPic : " + OPic);
	}

	public String Salary(String type, int price) {
		String str = "-----" + name + " 의 정보 ------\n";
			str += "원하는 계열 : "+ type + "\n";
			str += "원하는 연봉 : " + price + "\n";
			return str;
	}
}
