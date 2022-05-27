//StatementStrategy Interface
package springbook.user.dao;
...

public interface StatementStrategy {
    PrepareStatement makePreparedStatement(Connecion con) throws SQLException;
}
