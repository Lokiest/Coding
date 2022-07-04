//예외처리 회피 1
public void add() throws SQLException {
    // JDBC API
}

//예외처리 회피 2
public void add() throws SQLException {
    try {
        // JDBC API
    }
    
    catch (SQLException e) {
        //로그 출력
        throws e;
    }
}
