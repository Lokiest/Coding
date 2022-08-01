//트랜잭션 경계설정 구조
public void upgradeLevels() throws Exception {
    // 1) DB Connection 생성
    // 2) 트랜잭션 시작
    try {
        3) DAO 메소드 호출
        4) 트랜잭션 커밋
    }

    catch(Exception e) {
        5) 트랜잭션 롤백
    }

    finally {
        6) DB Connection 종료
    }
}
