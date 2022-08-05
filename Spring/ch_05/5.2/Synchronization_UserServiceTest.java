//동기화가 적용된 UserService에 따라 수정된 테스트
@Autowired DataSource dataSource;
...

@Test
	public void upgradeAllOrNothing() throws Exception {
		UserService testUserService = new TestUserService(users.get(3).getId());  
		testUserService.setUserDao(this.userDao); 
		testUserService.setDataSource(this.dataSource);
...
  
