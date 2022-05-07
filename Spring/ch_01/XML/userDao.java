//완성된 XML 설정정보, userDao 빈 설정
<beans>
    <bean id = "userDao" class = "springbook.user.dao.Userdao">
        <property name = "coonectionMaker" ref = "connectionMaker" />
    </bean>
</beans>
