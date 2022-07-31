//User의 레벨 업그레이드 작업용 메소드
public void upgradeLevel() {
		Level nextLevel = this.level.nextLevel();	
		if (nextLevel == null) { 								
			throw new IllegalStateException(this.level + "은  업그레이드가 불가능합니다");
		}
		else {
			this.level = nextLevel;
		}	
	}
