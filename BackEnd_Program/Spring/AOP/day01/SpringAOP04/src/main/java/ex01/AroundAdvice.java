package ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvice implements MethodInterceptor {
	
	@Override
	public Object invoke(MethodInvocation invo) throws Throwable {
		Object obj = null;
		System.out.println("I am AroundAcvice1 : " + invo.getMethod() + " before call =======");
		obj = invo.proceed(); //메서드가 수행
		System.out.println("I am AroundAcvice2 : " + invo.getMethod() + " after call =======");
		return obj;
	}
	
}
