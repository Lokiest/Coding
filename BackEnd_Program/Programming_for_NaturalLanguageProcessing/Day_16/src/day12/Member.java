package day12;

//객체를 파일에 쓰거나, 네트워크로 전달하고자 하면 해당 객체는 직렬화가 구현되어 있어야 함
//java.io.Serializable 인터페이스를 상속받아 구현 >> 추상 메소드 없음 >> 단순히 표시하는 기능


public class Member implements java.io.Serializable {
	
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
