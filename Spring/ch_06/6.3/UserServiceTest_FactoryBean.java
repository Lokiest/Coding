//트랜잭션 프록시 팩토리 빈을 적용한 테스트
public class UserServiceTest {
	@Autowired UserService userService;	
	@Autowired UserDao userDao;
	@Autowired UserServiceImpl userServiceImpl;
	@Autowired MailSender mailSender;
	@Autowired PlatformTransactionManager transactionManager;
	@Autowired ApplicationContext context; //팩토리 빈 가져오려면 필요
    ...

    @Test
    @DirtiesContext //컨텍스트 무효화 애노테이션
	public void upgradeAllOrNothing() throws Exception {
		TestUserService testUserService = new TestUserService(users.get(3).getId());
		testUserService.setUserDao(userDao);
		testUserService.setMailSender(mailSender);
		
		TxProxyFactoryBean txProxyFactoryBean = 
			context.getBean("&userService", TxProxyFactoryBean.class);
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
    ...
