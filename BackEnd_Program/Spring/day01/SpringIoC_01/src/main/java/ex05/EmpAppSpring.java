package ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpAppSpring {

	public static void main(String[] args) {
		String resource = "ex05/employee.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
									//classpath를 기준으로 설정파일 찾는 스프링 컨테이너
		//Emp e = ctx.getBean("e1", Emp.class);
		//Emp e = ctx.getBean("e2", Emp.class);
		Emp e = ctx.getBean("e3", Emp.class);

		e.info1();
		e.info2();


	}

}
