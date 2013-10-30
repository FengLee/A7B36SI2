package com.cvut.naKup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cvut.naKup.dao.UserDao;
import com.cvut.naKup.domain.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public boolean addUser(User user) {
		userDao.persist(user);
		//TODO check if user can be created (unique login)
		return true;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
