//Mockito 활용 만든 테스트 코드
@Test
public void mockUpgradeLevels() throws Exception {
	UserServiceImpl userServiceImpl = new UserServiceImpl();

	UserDao mockUserDao = mock(UserDao.class);	    
	when(mockUserDao.getAll()).thenReturn(this.users);
	userServiceImpl.setUserDao(mockUserDao);

	MailSender mockMailSender = mock(MailSender.class);  
	userServiceImpl.setMailSender(mockMailSender);

	userServiceImpl.upgradeLevels();

	verify(mockUserDao, times(2)).update(any(User.class));				  
	verify(mockUserDao, times(2)).update(any(User.class));
	verify(mockUserDao).update(users.get(1));
	assertThat(users.get(1).getLevel(), is(Level.SILVER));
	verify(mockUserDao).update(users.get(3));
	assertThat(users.get(3).getLevel(), is(Level.GOLD));

	ArgumentCaptor<SimpleMailMessage> mailMessageArg = ArgumentCaptor.forClass(SimpleMailMessage.class);  
	verify(mockMailSender, times(2)).send(mailMessageArg.capture());
	List<SimpleMailMessage> mailMessages = mailMessageArg.getAllValues();
	assertThat(mailMessages.get(0).getTo()[0], is(users.get(1).getEmail()));
	assertThat(mailMessages.get(1).getTo()[0], is(users.get(3).getEmail()));
