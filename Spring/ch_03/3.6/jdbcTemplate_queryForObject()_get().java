//qeuryForObject()ě RowMapper ě ěŠí get()
public User get(String id) {
		return this.jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE id = ?",
				new Object[] {id}, 
				new RowMapper<User>() {
					public User mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						User user = new User();
						user.setId(rs.getString("id"));
						user.setName(rs.getString("name"));
						user.setPassword(rs.getString("password"));
						return user;
					}
				});
	} 
