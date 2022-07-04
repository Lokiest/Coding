//예외 전환 기능을 가진 DAO 메소드
public void add() throws DuplicateUserIdException, SQLException {
    try {
        // JDBC를 이용해 user 정보를 DB에 추가하는 코드 or
        // 그런 기능을 가진 다른 SQLException을 던지는 메소드를 호출하는 코드
    }
    
    catch (SQLException e) {
        //ErrorCode가 MySql의 Duplicate Entry이면 예외 전환
        if (e.getErrorCode == MysqlErrorNumbers.ER_DUP_ENTRY)
            throws DuplicateUserIdException();
        else
            throws e; //그 외의 경우
    }
}
