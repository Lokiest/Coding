//메일 발송 대상을 확인하는 테스트
@Test @DirtiesContext
public void upgradeLevels() {
	userDao.deleteAll();
	for(User user : users) userDao.add(user);
		
	MockMailSender mockMailSender = new MockMailSender();  
	userService.setMailSender(mockMailSender);  
		
	userService.upgradeLevels();
		
	checkLevelUpgraded(users.get(0), false);
	checkLevelUpgraded(users.get(1), true);
	checkLevelUpgraded(users.get(2), false);
	checkLevelUpgraded(users.get(3), true);
	checkLevelUpgraded(users.get(4), false);
		
	List<String> request = mockMailSender.getRequests();  
	assertThat(request.size(), is(2));  
	assertThat(request.get(0), is(users.get(1).getEmail()));  
	assertThat(request.get(1), is(users.get(3).getEmail()));  
}
