package ex01;

import org.springframework.aop.framework.ProxyFactory;

public class AOPTest {

	public static void main(String[] args) {
		//1. 핵심 로직을 갖는 객체 >> Target
		ServiceImpl target = new ServiceImpl();
		
		//2. 공통 관심사항 >> Advice
		AroundAdvice advice = new AroundAdvice();
		
		//3. 위 두가지를 엮는 >> Proxy 객체 >> Target을 전체적으로 감싸고 있는 객체
		//					Proxy는 내부적으로 타겟 호출하지만, 중간에 필요한 관심사항들을 거쳐서 타겟을 호출하도록 작성됨
		//					Proxy는 스프링 aop프레임워크에서 자동으로 생성되는 auto-proxy방식 사용
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvice(advice);
		
		ServiceImpl proxy = (ServiceImpl)pf.getProxy();
		proxy.sayHello("Park", "Kim", "Jang", "Choi");
	}

}
