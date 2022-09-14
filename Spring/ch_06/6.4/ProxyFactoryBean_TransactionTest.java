//ProxyFactoryBean을 이용한 트랜잭션 테스트
@Test 
@DirtiesContext
public void upgradeAllOrNothing() {
	TestUserService testUserService = new TestUserService(users.get(3).getId());
	testUserService.setUserDao(userDao);
	testUserService.setMailSender(mailSender);
		
	ProxyFactoryBean txProxyFactoryBean = 
		context.getBean("&userService", ProxyFactoryBean.class);
	txProxyFactoryBean.setTarget(testUserService);
	UserService txUserService = (UserService) txProxyFactoryBean.getObject();
				 
	userDao.deleteAll();			  
	for(User user : users) userDao.add(user);
		
	try {
		txUserService.upgradeLevels();   
		fail("TestUserServiceException expected"); 
	}
	catch(TestUserServiceException e) { 
	}
		
	checkLevelUpgraded(users.get(1), false);
}
