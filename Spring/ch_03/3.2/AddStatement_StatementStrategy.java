//add()의 PreparedStatement 생성 로직을 분리한 클래스
public class AddStatement implements StatementStrategy {
    public PreparedStatement makePreparedStatement(Connection con) throws SQLException {
        preparedStatement ps = con.preparedStatement("INSERT INTO USERS(id, name, password) VALUE (?,?,?)");
        ps.setString(1, user.getID());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        return ps;
    }
}
