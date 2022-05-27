//전략 패턴을 따라 DeleteAllStatement가 적용된 deleteAll()
public void deleteAll() throws SQLException {
...
    try {
        con = dateSource.getConnection();

        StatementStrategy = new DeleteAllStatement();
        ps = strategy.makePreparedStatement(con);

        ps.executeUpdate();
        } catch (SQLException e) {
        ...
}
