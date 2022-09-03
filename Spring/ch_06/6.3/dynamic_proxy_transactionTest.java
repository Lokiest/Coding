//다이나믹 프록시를 이용한 트랜잭션 테스트
@Test
public void upgradeAllOrNothing() throws Exception {
    ...
    TransactionHandler txHandler = new TransactionHandler();
    txHandler.setTarget(testUserService);
    txHandler.setTransactionManager(transactionManager);
    txHandler.setPattern("upgradeLevels");  //필요한 정보와 오브젝트를 DI
    UserService txUserService = (UserService)Proxy.newProxyInstance(
        getClass().getClassLoader(), new Class[] { UserService class }, txHandler);
    // UserService 인터페이스 타입의 다이나믹 프록시 생성
    ...
}
