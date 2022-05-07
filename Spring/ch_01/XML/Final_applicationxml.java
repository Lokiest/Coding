//DataSource를 적용 완료한 최종 applicationContext.xml
<?xml version = "1.0" encoding = "UTF-8"?>
<beans xmln="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2022/XMLSchema-instance:
      xsi:schemaLocation="http://www.springframework.org/shema/beans
        http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

    <bean id = "dataSource"
      class = "org.springframework.jdbc.dataSource.SimpleDriverDataSource" />
      <property name = "driverClass" value = "com.mysql.jdbc.Driver" />
      <property name = "url" value = "jdbc:mysql://localhost/springbook" />
      <property name = "username" value = "~" />
      <property name = "password" value = "~" />
    </bean>

    <bean id = "userDao" class = "springbook.user.dao.Userdao">
        <property name = "dataSource" ref = "dataSource" />
    </bean>
</beans>
