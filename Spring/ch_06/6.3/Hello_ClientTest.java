//클라이언트 역할의 테스트
@Test
public void simpleProxy {
    Hello hello = new HelloTarget();
    assertThat(hello.sayHello("Toby"), is("Hello Toby"));
    assertThat(hello.sayHi("Toby"), is("Hi Toby"));
    assertThat(hello.sayThankYou("Toby"), is("Thank You Toby"));
}
