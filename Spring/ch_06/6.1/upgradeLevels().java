//upgradeLevels()
@Test 
public void upgradeLevels() throws Exception {
	UserServiceImpl userServiceImpl = new UserServiceImpl(); 
		
	MockUserDao mockUserDao = new MockUserDao(this.users);  
	userServiceImpl.setUserDao(mockUserDao);

	MockMailSender mockMailSender = new MockMailSender();
	userServiceImpl.setMailSender(mockMailSender);
...
