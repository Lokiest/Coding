//변하지 않는 부분을 분리시킨 deleteAll()
public void deleteAll() throws SQLException {
	execute("DELETE FROM USERS"); //변하는 부분
}

private void executeSql(final String query) throws SQLException {
    this.jdbcContext.workWithStatementStrategy(
        new StatementStrategy() {
				public PreparedStatement makePreparedStatement(Connection c)
						throws SQLException {
					return c.prepareStatement(query);
				}
			}
		);
	}
