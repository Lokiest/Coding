package ex02;
//Aspect : Advice + PointCut

//핵심 로직은 아니지만 코드를 온전하게 만들기 위해 필요한 공통관심사항 (Advice) + 어느 지점에 적용? (pointcut)

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class CommonAspect {
	// before
	public void trace1(JoinPoint jp) {
		Signature sign = jp.getSignature();
		System.out.println("before ======================= [" + sign.toShortString() + "]");
	}

	// after
	public void trace2(JoinPoint jp) {
		Signature sign = jp.getSignature();
		System.out.println("after ======================== [" + sign.toShortString() + "]");
	}

	// after-returning
	public void trace3(JoinPoint jp, Integer result) {
		Signature sign = jp.getSignature();
		System.out.println("after returning ============= [" + sign.toShortString() + "] result : " + result);
	}

	// after-throwing
	public void trace4(JoinPoint jp, Exception ex) {
		Signature sign = jp.getSignature();
		System.out.println("after throwing ============= [" + sign.toShortString() + "]==");
		if (ex != null)
			System.out.println(ex);
	}

	// around
	public Integer trace5(ProceedingJoinPoint jp) {
		Signature sign = jp.getSignature();
		System.out.println("around ============= [" + sign.toShortString() + "] start");
		try {
			Integer n = (Integer)jp.proceed();
			return n;
		} catch (Throwable e) {
			e.printStackTrace();
			return -1;
		} finally {
			System.out.println("around ============= [" + sign.toShortString() + "] end");
		}
		
	}

}
