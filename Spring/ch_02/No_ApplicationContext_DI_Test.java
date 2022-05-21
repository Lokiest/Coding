//애플리케이션 컨텍스트 없는 DI 테스트

public class UserDaoTest {
    UserDao dao //@Autowird 없음
    ...

    @Before
    public void setUp() {
        ...
        dao = new UserDao();
        DataSource dataSource = new SingleConnectionDataSource("jdbc", "~", "~", true);
        dao.setDataSource(dataSource); //오브젝트 생성, 관계설정 등 모두 직접등록해야
}
