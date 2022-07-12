//레벨 업그레이드 메소드
public void upgradeLevels() {
    List<User> users = userDao.getAll();
    
    for(User user : users) {
        Boolean changed = null; //레벨 변화가 있는지 확인하는 플래그
        if (user.getLevel() == Level.BASIC && user.getLogin() >= 50 {
            user.setLevel(Level.SILVER);
            changed = true; //플래그 변경
        }
        else if (user.getLevel() == Level.SILVER && user.getRecommand() >= 30 {
            user.setLevel(Level.GOLD);
            changed = true;
        }
        else if (user.getLevel() == Level.GOLD) {changed = false;}
        else {changed = false;}
        
        if (changed) {userDao.update(user);}
    }
}
