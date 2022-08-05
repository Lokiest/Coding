//트랜잭션 매니저를 수동 DI 하도록 수정
...
@Autowired PlatformTransactionManager transactionManager;
...
@Test
	public void upgradeAllOrNothing() {
		UserService testUserService = new TestUserService(users.get(3).getId());  
		testUserService.setUserDao(this.userDao);
		testUserService.setTransactionManager(this.transactionManager);
...
