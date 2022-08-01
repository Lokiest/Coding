//예외시 작업 취소 여부 테스트
@Test
	public void upgradeAllOrNothing() throws Exception {
		UserService testUserService = new TestUserService(users.get(3).getId());  
        //예외 발생시킬 네 번째 사용자의 id 넣기
		testUserService.setUserDao(this.userDao); //수동 DI
		
		userDao.deleteAll();			  
		for(User user : users) userDao.add(user);
		
		try {
			testUserService.upgradeLevels();   
			fail("TestUserServiceException expected"); 
		}
		catch(TestUserServiceException e) { 
		}
		
		checkLevelUpgraded(users.get(1), false); //예외 전후로 변경이 되었나 확인
	}
