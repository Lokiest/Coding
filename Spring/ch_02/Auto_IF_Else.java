if (!user.getName().equals(user2.getName()) {
  System.out.println("테스트 실패 (name)");
}
    
else if (!user.getPassword().equals(user2.getPassword()) {
  System.out.println("테스트 실패 (Password)");
}
         
else {
  System.out.println("조회 테스트 성공");
  }
