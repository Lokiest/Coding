package my.app;
//1. Exception을 상속받는다
//2. 생성자를 만들고 super("예외메시지");를 호출한다
public class NotSupportedNameException extends Exception
{
	public NotSupportedNameException() {
		super("NotSupportedNameException");
	}
	public NotSupportedNameException(String msg) {
		super(msg);
	}

}/////////////////////////////////////////////
