//USerDao를 직접 DI 받도록 만든 테스트

...
public class USerDaoTest {
    @Autowired
    UserDao dao; //UserDao 타입 빈을 직접 DI 받음
...
}
