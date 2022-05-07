//빈의 이름과 참조 ref 변경
<beans>
    <bean id = "myConnectionMaker" class = "springbook.user.dao.DConnectionMaker"/>
    
    <bean id = "userDao" class = "springbook.user.dao.Userdao">
        <property name = "connectionMaker" ref = "myConnectionMaker" />
    </bean>
</beans>
