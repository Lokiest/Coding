//사용자 정보 수정 메소드 테스트
@Test
	public void update() {
		dao.deleteAll();
		
		dao.add(user1);
		
		user1.setName("오민규");
		user1.setPassword("springno6");
		user1.setLevel(Level.GOLD);
		user1.setLogin(1000);
		user1.setRecommend(999);
		
		dao.update(user1);
		
		User user1update = dao.get(user1.getId());
		checkSameUser(user1, user1update);

	}
