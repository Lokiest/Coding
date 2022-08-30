//HelloUppercase 프록시 테스트
Hello proxiedHello = new HelloUppercase(new HelloTarget());
assertThat(proxiedHello.sayHello("Toby"), is("HELLO TOBY"));
assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY"));
assertThat(proxiedHello.sayThankYou("Toby"), is("THANK YOU TOBY"));
