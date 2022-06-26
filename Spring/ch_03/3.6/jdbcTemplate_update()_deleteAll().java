//내장 콜백을 사용하는 update()로 변경 (deleteAll())
public void deleteAll() throws SQLException {
	this.jdbcTemplate.update("DELETE FROM USERS");
}
