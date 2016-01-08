package com.ganhuo.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganhuo.app.service.IUserService;
import com.ganhuo.app.dao.IUserDao;
import com.ganhuo.app.entity.User;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Override
	public User getById(int id) {
		return userDao.getById(id);
	}
	
}
