public interface FactoryBean<T> {
    T getObject() throws Exception; //빈 오브젝트를 생성해서 돌려주는
    Class<? extends T> getObjectType(); //오브젝트 타입을 알려주는
    boolean isSingleton(); //항상 같은 싱글톤 오브젝트인지 알려주는
}
