package com.ganhuo.app.dao;

import org.springframework.stereotype.Repository;

import com.ganhuo.app.entity.User;

@Repository
public interface IUserDao {
	public User getById(int id);
}
