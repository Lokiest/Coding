//리스트로 만든 테스트 픽스처
public class UserServiceTest {
	@Autowired 	UserService userService;	
	@Autowired UserDao userDao;
	
	List<User> users;	// test fixture
	
	@Before
	public void setUp() {
		users = Arrays.asList( //배열을 리스트로 만들어주는 메소드
				new User("bumjin", "박범진", "p1", Level.BASIC, 49, 0),
				new User("joytouch", "강명성", "p2", Level.BASIC, 50, 0),
				new User("erwins", "신승한", "p3", Level.SILVER, 60, 29),
				new User("madnite1", "이상호", "p4", Level.SILVER, 60, 30),
				new User("green", "오민규", "p5", Level.GOLD, 100, 100)
				);
	}
