//스프링 테스트 컨텍스트를 적용한 UserDaoTest

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(location = "/applicationContext.xml)
public class UserDaoTest {
    @Autowired
    private ApplicationContext context;
    ....

    @Before
    public void Setup() {
        this.dao = this.context.getBean("userDao", UserDao.class);
        ...
    }
...
}
