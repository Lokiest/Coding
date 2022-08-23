//MockUserDao를 사용해서 만든 고립된 테스트
@Test 
public void upgradeLevels() throws Exception {
	UserServiceImpl userServiceImpl = new UserServiceImpl(); 
		
	MockUserDao mockUserDao = new MockUserDao(this.users);  
	userServiceImpl.setUserDao(mockUserDao);

	MockMailSender mockMailSender = new MockMailSender();
	userServiceImpl.setMailSender(mockMailSender);
		
	userServiceImpl.upgradeLevels();

	List<User> updated = mockUserDao.getUpdated();  
	assertThat(updated.size(), is(2));  
	checkUserAndLevel(updated.get(0), "joytouch", Level.SILVER); 
	checkUserAndLevel(updated.get(1), "madnite1", Level.GOLD);
		
	List<String> request = mockMailSender.getRequests();
	assertThat(request.size(), is(2));
	assertThat(request.get(0), is(users.get(1).getEmail()));
	assertThat(request.get(1), is(users.get(3).getEmail()));
}

private void checkUserAndLevel(User updated, String expectedId, Level expectedLevel) {
	assertThat(updated.getId(), is(expectedId));
	assertThat(updated.getLevel(), is(expectedLevel));
}
