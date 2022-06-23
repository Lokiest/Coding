//JdbcContext로 옮긴 executeSql()을 사용하는 deleteAll()
public void deleteAll() throws SQLException {
	this.jdbcConetext.executeSql("DELETE FROM USERS");
}
