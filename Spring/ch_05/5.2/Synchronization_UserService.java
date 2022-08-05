//트랜잭션 동기화 방식을 적용한 UserService
private DataSource dataSource;  

public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
}.    //Connection을 생성할 때 사용할 DataSource를 DI 받도록
	
public void upgradeLevels() throws Exception {
	TransactionSynchronizationManager.initSynchronization();  //동기화 작업 초기화
	Connection c = DataSourceUtils.getConnection(dataSource); 
	c.setAutoCommit(false);
		
	try {									   
		List<User> users = userDao.getAll();
		for (User user : users) {
			if (canUpgradeLevel(user)) {
				upgradeLevel(user);
			}
		}
		c.commit();  
	} catch (Exception e) {    
		c.rollback();
		throw e;
	} finally {
		DataSourceUtils.releaseConnection(c, dataSource);	//DB 커넥션 안전하게 종료시키기
		TransactionSynchronizationManager.unbindResource(this.dataSource);  
		TransactionSynchronizationManager.clearSynchronization();  
        //동기화 작업 종료 및 정리
	}
}
