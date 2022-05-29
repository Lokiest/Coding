//user 정보를 AddStatement에 전달해주는 add() 메소드
public void add(User user) throws SQLException {
    StatementStrategy st = new AddStatement(user);
    jdbcContextWithStatementStrategy(st);
}
