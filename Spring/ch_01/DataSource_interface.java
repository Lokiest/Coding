//DataSource 인터페이스
package javax.sql

public interface DataSource extends CommonDataSource, Wrapper {
    Connection getConnection() throws SQLException;
    ...
}
