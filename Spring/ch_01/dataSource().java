//DataSource 타입의 dataSource 빈 정의 메소드
@Bean
public DataSource dataSource() {
    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

    dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
    dataSource.setUrl("jdbc:mysql://localhost/springbook");
    dataSource.setUsername("~");
    dataSource.setPassword("~");

    return dataSource;
}
