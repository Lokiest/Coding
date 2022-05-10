package com.example.demo;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import springbook.user.domain.User;

public class UserDaoTest {
	
	@Test
	public void addAndGet() throws SQLException, ClassNotFoundException {
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);
			
		User user = new User();
		user.setId("Doctor");
		user.setName("Scarlet");
		user.setPassword("MultiVerse");
			
		dao.add(user);
			
		System.out.println(user.getId() + "등록 성공");
			
		User user2 = dao.get(user.getId());
			
		assertThat(user2.getName(), is(user.getName()));
		assertThat(user2.getPassword(), is(user.getPassword()));
				
		}
	}
