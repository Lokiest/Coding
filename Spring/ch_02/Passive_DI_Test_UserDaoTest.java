//테스트를 위한 수동 DI를 적용한 UserDaoTest

...
@DirtiesContext
public class UserDaoTest {
    @Autowired
    UserDao dao;

    @Before
    public void setUp() {
        ...
        DataSource dataSource = new SingleConnectionDataSource("jdbc", "~", "~", true);
        dao.setDataSource(dataSource);
    }
}
