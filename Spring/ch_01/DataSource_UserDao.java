//DataSource를 사용하는 UserDao
import javax.sql.DataSource;

public class UserDao {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void add(User user) throws SQLException {
        Connection con = dataSource.getConnection();
        ...
    }
    ...
}
