//업그레이드 가능 확인 메소드
private boolean canUpgradeLevel(User user) {
		Level currentLevel = user.getLevel(); 
		switch(currentLevel) {                                   
		    case BASIC: return (user.getLogin() >= 50); 
		    case SILVER: return (user.getRecommend() >= 30);
		    case GOLD: return false;
		    default: throw new IllegalArgumentException("Unknown Level: " + currentLevel); 
		}
}
