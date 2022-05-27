//deleteAll() 메소드 기능을 구현한 StatementStrategy 전략 클래스
package springbook.user.dao;
...

public class DeleteAllStatement implements StatementStrategy {
    public PreparedStatement makePreparedStatement(Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement('DELETE * FROM USERS');
        return ps;
    }
}
