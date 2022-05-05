//XML 정보를 담은 applicationContext.xml (스프링 스키마까지 적용)
<?xml version = "1.0" encoding = "UTF-8"?>
<beans xmln="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2022/XMLSchema-instance:
      xsi:schemaLocation="http://www.springframework.org/shema/beans
        http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">
    <bean id = "connectionMaker" class = "springbook.user.dao.DConnectionMaker" />

    <bean id = "userDao" class = "springbook.user.dao.Userdao">
        <property name = "connectionMaker" ref = "ConnectionMaker" />
    </bean>
</beans>
