package com.ganhuo.app.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-root.xml")
public class UserServiceTest {
	
	@Autowired
	private IUserService userService;
	
	@Test
	public void testGet() throws Exception {
		System.out.println(userService.getById(1));
	}
}
