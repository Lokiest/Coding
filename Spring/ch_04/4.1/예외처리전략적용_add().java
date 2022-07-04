//예외처리 전략을 적용한 add()
public void add() throws DuplicateUserIdException{
    try {
        // JDBC를 이용해 user 정보를 DB에 추가하는 코드 or
        // 그런 기능을 가진 다른 SQLException을 던지는 메소드를 호출하는 코드
    }
    
    catch (SQLException e) {
        if (e.getErrorCode == MysqlErrorNumbers.ER_DUP_ENTRY)
            throw new DuplicateUserIdException(e); //예외 전환
        else
            throws new RuntimeException(e); //예외 포장
    }
}
