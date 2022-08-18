//비지니스 로직과 트랜잭션 경계설정의 분리
public void upgradeLevels() {
	TransactionStatus status = 
		this.transactionManager.getTransaction(new DefaultTransactionDefinition());
	try { 
        upgradeLevelsInternal();
		this.transactionManager.commit(status);
	} catch (RuntimeException e) {
		this.transactionManager.rollback(status);
		throw e;
	}
}

private void upgradeLevelsInternal() {
    List<User> users = userDao.getAll();
		for (User user : users) {
			if (canUpgradeLevel(user)) {
				upgradeLevel(user);
			}
		}
}
