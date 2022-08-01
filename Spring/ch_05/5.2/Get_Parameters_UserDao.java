//Connection 오브젝트를 파라미터로 전달받는 UserDao
public interface UserDao {
    public void add(Connection c, User user);
    public void get(Connection c, String id);
    ...
    public void update(Connection c, User user1);
}
