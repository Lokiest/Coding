//upgradeAllOrNothing()
@Test
public void upgradeAllOrNothing() {
	TestUserService testUserService = new TestUserService(users.get(3).getId());
	testUserService.setUserDao(userDao);
	testUserService.setMailSender(mailSender);
		
	UserServiceTx txUserService = new UserServiceTx();
	txUserService.setTransactionManager(transactionManager);
	txUserService.setUserService(testUserService);
		 
	userDao.deleteAll();			  
	for(User user : users) userDao.add(user);
		
	try {
		txUserService.upgradeLevels();   //트랜잭션 기능을 분리한 오브젝트를 통해 예외 발생용 TestUserService가 호출되게 해야
		fail("TestUserServiceException expected"); 
	}
	catch(TestUserServiceException e) { 
	}
		
	checkLevelUpgraded(users.get(1), false);
}
