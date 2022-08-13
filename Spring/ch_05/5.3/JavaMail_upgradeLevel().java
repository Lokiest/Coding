//upgradeLevel()에서 메일 발송 메소드 호출
protected void upgradeLevel(User user) {
	user.upgradeLevel();
	userDao.update(user);
	sendUpgradeEMail(user);
}
