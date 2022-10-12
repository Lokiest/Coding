package my.app2;

public class Member {
	
	private String name;
	private String pwd;
	private String tel;
	
	public Member() {
		this("아무개","","");
	}
	public Member(String n, String pwd, String tel) {
		this.name=n;
		this.pwd=pwd;
		this.tel=tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String showInfo() {
		return name+"\t"+tel+"\t"+pwd;
	}
}//////////////////////////////////
