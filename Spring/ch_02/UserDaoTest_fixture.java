package com.example.demo;

import java.sql.SQLException;
import org.junit.runner.JUnitCore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import springbook.user.domain.User;
import com.example.demo.UserDao;
import org.springframework.dao.*;
import org.junit.Before;

public class UserDaoTest {
	private UserDao dao;
	private User user1;
	private User user2;
	
	@Before
	public void setUp() {
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		this.dao = context.getBean("userDao", UserDao.class);
		
		this.user1 = new User("ironman", "Tony", "Avengers_1");
		this.user2 = new User("Spidy", "Parker", "Avengers_2");
	}
	
	@Test
	public void addAndGet() throws SQLException, ClassNotFoundException {
			
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.add(user1);
		dao.add(user2);
		assertThat(dao.getCount(), is(2));
				
		User userget1 = dao.get(user1.getId());
		assertThat(userget1.getName(), is(user1.getName()));
		assertThat(userget1.getPassword(), is(user1.getPassword()));
		
		User userget2 = dao.get(user2.getId());
		assertThat(userget2.getName(), is(user2.getName()));
		assertThat(userget2.getPassword(), is(user2.getPassword()));
		}
	
	
	@Test(expected=EmptyResultDataAccessException.class)
	public void getUserFailure() throws SQLException, ClassNotFoundException {
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.get("unknown_id");
	}
	
	}
