//dataSource 타입의 빈을 DI 받는 userDao() 빈 정의 메소드
@Bean
public UserDao userDao() {
    UserDao userDao = new UserDao();
    userDao.setDataSource(dataSource());
    return userDao;
}
