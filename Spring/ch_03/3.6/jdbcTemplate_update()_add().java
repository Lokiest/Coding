//내장 콜백을 사용하는 update()로 변경 (add())
public void add(final User user) throws SQLException {
	this.jdbcTemplate.update("INSERT INTO USERS(id, name, password) VALUES(?,?,?)",
					user.getId(), user.getName(), user.getPassword());
}
