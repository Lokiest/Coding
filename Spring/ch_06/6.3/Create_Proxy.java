//프록시 생성

Hello proxiedHello = (Hello)Proxy.newProxyInstance(
    getClass().getClassLoader(), //다이나믹 프록시 클래스의 로딩에 사용할 클래스 로더
    new Class[] { Hello.class}, //구현할 인터페이스
    new UppercaseHandler(new HelloTarget())); //부가기능 + 위임코드 담은 InvocationHandler
