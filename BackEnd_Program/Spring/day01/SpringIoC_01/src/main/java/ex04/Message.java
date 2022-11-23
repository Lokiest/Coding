package ex04;

public interface Message {
	
	void sayHello();
	void sayHi(String ... names);
	// ... >> 매개변수 자유자재로 넣기 가능(개수)
	//names 변수는 String[] 배열 타입
	
}
