package ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
//IoC : 제어권을 스프링 컨테이너가 갖는 것

public class HelloAppSpring {

	public static void main(String[] args) {
		String config = "src/main/java/ex03/applicationContext.xml";
		
		//스프링 컨테이너
		ApplicationContext ctx = new FileSystemXmlApplicationContext(config);
		
		//DL : 메모리에 올라가있는 객체를 이름으로 찾는 것
		//MessageBean mb = (MessageBean)ctx.getBean("mbKo");
		MessageBean mb = (MessageBean)ctx.getBean("mbEn");
		mb.sayHello("Spring");
	}

}
