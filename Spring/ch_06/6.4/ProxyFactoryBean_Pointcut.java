//포인트컷까지 적용한 ProxyFactoryBean
@Test
public void pointcutAdvisor() {
    ProxyFactoryBean pfBean = new ProxyFactoryBean();
    pfBean.setTarget(new HelloTarget());

    NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
    pointcut.setMappedName("sayH*"); //이름 비교조건 설정

    pfBean.addAdvisor(new DefaultPointAdvisor(pointcut, new UppercaseAdvice()));
    //포인트컷과 어드바이스 한 번에 묶어서 Advisor로

    Hello proxiedHello = (Hello) pfBean.getObject();

    assertThat(proxiedHello.sayHello("Toby"), is("Hello TOBY));
    assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY));
    assertThat(proxiedHello.sayThankYou("Toby"), is("THANK YOU TOBY));
}
