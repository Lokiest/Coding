package day04;

public class JobSite {
	public static void main(String[] args) {
		
		Job j1 = new Job();
		j1.name = "김철수";
		j1.University = "서울대학교";
		j1.score = 4.1f;
		j1.OPic = "IH";
		
		j1.Employer();
		
		String info = j1.Salary("프론트 엔드(단위 : 천만) : ", 10000);
		String info2 = j1.Salary("백엔드(단위 : 천만) : ", 10000);
		String info3 = j1.Salary("전산(단위 : 천만) : ", 10000);
		
		System.out.println(info);
		System.out.println(info2);
		System.out.println(info3);
		
		Job j2 = new Job();
		j1.name = "김하수";
		j1.University = "연세대학교";
		j1.score = 3.7f;
		j1.OPic = "AL";
		
		j1.Employer();
		
		String info4 = j1.Salary("프론트 엔드(단위 : 천만) : ", 20000);
		String info5 = j1.Salary("백엔드(단위 : 천만) : ", 30000);
		String info6 = j1.Salary("전산(단위 : 천만) : ", 40000);
		
		System.out.println(info4);
		System.out.println(info5);
		System.out.println(info6);
	}
}
