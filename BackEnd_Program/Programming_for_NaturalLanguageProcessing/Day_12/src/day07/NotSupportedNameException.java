package day07;
//사용자 설정 예외
// [1] Exception을 상속
// [2] 생성자를 만들고 super("예외 메세지"); 를 호출

public class NotSupportedNameException extends Exception {
	
	public NotSupportedNameException() {
		super("NotSupportedNameException");
	}
	
	public NotSupportedNameException(String msg) {
		super(msg);
	}
	
}
