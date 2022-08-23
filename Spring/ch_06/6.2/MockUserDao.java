//MockUserDao
static class MockUserDao implements UserDao {
    private List<User> users; //레벨업 후보 User 오브젝트 목록
    private List<User> updated = new ArrayList(); //레벨업 대상 오브젝트를 저장해둘 목록

    private MockUserDao(List<User> users) {
        this.users = users;
    }

    private List<User> getUpdated() {
        return this.updated;
    }

    private List<User> getAll() {
        return this.users;
    }

    public void update(User user) {
        updated.add(user);
    }

    public void add(User user) { throw new UnsupportedOperationException(); }
    public void deleteAll() { throw new UnsupportedOperationException(); }
    public User get(String id) { throw new UnsupportedOperationException(); }
    public int getCount() { throw new UnsupportedOperationException(); }
}
