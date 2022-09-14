//ProxyFactoryBean을 이용한 다이나믹 프록시 테스트
package springbook.learningtest.jdk.proxy;
...
public class DynamicProxyTest {
    @Test
    public void simpleProxy() {
        Hello proxiedHello = (Hello)Proxy.newProxyInstance(
            getClass().getClassLoader(),
            new Class [] { Hello.class },
            new UppercaseHandler(new HelloTarget())); //JDK 다이나믹 프록시 생성
            ...
        }

    @Test
    public void proxyFactoryBean() {
        ProxyFactoryBean pfBean = new ProxyFactoryBean();
        pfBean.setTarget(new HelloTarget()); //타겟 설정
        pfBean.addAdvice(new UppercaseAdvice()); //부가기능 담은 어드바이스 추가
        Hello proxiedHello = (Hello) pfBean.getObject(); //생성된 프록시 가져오기

        assertThat(proxiedHello.sayHello("Toby"), is("Hello TOBY));
        assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY));
        assertThat(proxiedHello.sayThankYou("Toby"), is("THANK YOU TOBY));
    }

    static class UppercaseAdvice implements MethodInterceptor {
        public Object invoke(MethodInvocation invocation) throws Throwable {
            String ret = (String)invocation.proceed(); //타겟 오브젝트 전달할 필요x
            return ret.toUpperCase(); //부가기능 적용
        }
    }

...
}
