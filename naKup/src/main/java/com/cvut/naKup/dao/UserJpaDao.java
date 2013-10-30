package com.cvut.naKup.dao;

import org.springframework.stereotype.Repository;

import com.cvut.naKup.domain.User;

@Repository
public class UserJpaDao extends NaKupJpaBaseDao<User> implements UserDao {

	public UserJpaDao() {
		super(User.class);
	}

}
