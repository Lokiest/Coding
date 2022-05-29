//User 정보를 생성자로부터 제공받도록 만든 AddStatement
package springbook.user.dao;
...
public class AddStatement implements StatementStrategy {
    User user;

    public AddStatement(User user) {
        this.user = user;
    }

    public PreparedStatement makePreparedStatement(Connection con) throws SQLException {
        preparedStatement ps = con.preparedStatement("INSERT INTO USERS(id, name, password) VALUE (?,?,?)");
        ps.setString(1, user.getID());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        return ps;
    }
}
