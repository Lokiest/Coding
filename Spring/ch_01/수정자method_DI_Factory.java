@Bean
public UserDao userDao() {
  UserDao userDao = new UserDao();
  userDao.setConnectionMaker(connectionMaker());
  return userDao; 
}
