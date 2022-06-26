//queryForInt() 적용한 getCount()
public int getCount() {
    return this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM USERS");
}
