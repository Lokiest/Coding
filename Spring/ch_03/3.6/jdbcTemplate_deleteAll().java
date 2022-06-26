//JdbcTemplate 적용한 deleteAll()
public void deleteAll() {
    this.jdbcTemplate.update(new PreparedStatementCreator() {
        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
            return con.preparedStatement("DELETE FROM USERS");
            }
        }
    };
}
