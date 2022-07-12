//레벨 업그레이드 테스트
@Test
public void upgradeLevels() {
	userDao.deleteAll();
	for(User user : users) userDao.add(user);
		
	userService.upgradeLevels();
		
	checkLevelUpgraded(users.get(0), Level.BASIC);
	checkLevelUpgraded(users.get(1), Level.SILVER);
	checkLevelUpgraded(users.get(2), Level.SILVER);
	checkLevelUpgraded(users.get(3), Level.GOLD);
	checkLevelUpgraded(users.get(4), Level.GOLD);
}

private void checkLevel(User user, Level expectedLevel) {
    User userUpdate = userDao.get(user.getId());
    assertThat(userUpdate.getLevel(), is(expectedLevel));
} //DB에서 사용자 정보를 가져와 레벨을 확인하는 코드가 중복되므로 헬퍼 메소드로 분리
