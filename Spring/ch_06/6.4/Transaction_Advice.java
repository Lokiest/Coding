//트랜잭션 어드바이스
package springbook.user.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TransactionAdvice implements MethodInterceptor {
	PlatformTransactionManager transactionManager;

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		//타겟을 호출하는 기능을 가진 콜백 오브젝트를 프록시로부터 받기
        this.transactionManager = transactionManager;
	}

	public Object invoke(MethodInvocation invocation) throws Throwable {
		TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			Object ret = invocation.proceed(); //콜백 호출해서 타겟의 메소드를 실행
			this.transactionManager.commit(status);
			return ret;
		} catch (RuntimeException e) { //예외가 포장되지 않고 타겟에서 보낸 그대로 전달
			this.transactionManager.rollback(status);
			throw e;
		}
	}
}
