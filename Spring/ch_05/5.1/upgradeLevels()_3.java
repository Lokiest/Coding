//기본 작업 흐름만 남겨둔
public void upgradeLevels() {
    List<User> users = userDao.getAll();
    for(User user : users) {
        if (canUpgradeLevel(user)) {
            upgradeLevel(user);
        }
    }
}
