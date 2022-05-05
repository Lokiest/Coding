//같은 인터페이스 타입의 빈을 여러개 정의한 경우
<beans>
    <bean id = "localDBCM" class = "...localDBCM" />
    <bean id = "testDBCM" class = "...testDBCM" />
    <bean id = "productionDBCM" class = "...productionDBCM" />

    <bean id = "userDao" class = "springbook.dao.Userdao">
        <property name = "coonectionMaker" ref = "localDBCM" />
    </bean>
</beans>
