//관계설정 책임 분리 전의 생성자
public UserDao() {
    connectionMaker = new DConnectionMaker();
}



//의존관계 주입을 위한 코드
public UserDao() {
    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }
    ...
}



//DaoFactory를 이용하는 생성자
public UserDao() {
    DaoFactory daoFactory = new DaoFactory();
    this.connectionMaker = daoFactory.connectionMaker();
}



//의존관계 검색을 이용하는 UserDao 생성자
public UserDao() {
    AnnotationConfigApplicationContext context = 
        new AnnotationConfigApplicationContext(DaoFactory.class);
    this.connectionMaker = context.getBean("connectionMaker", ConnectionMaker.class);
}
