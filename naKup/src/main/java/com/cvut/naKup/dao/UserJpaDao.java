package com.cvut.naKup.dao;

import org.springframework.stereotype.Repository;

import com.cvut.naKup.domain.User;

/**
 * Implementation of {@link UserDao}.
 * 
 * Extends {@link NaKupJpaBaseDao}.
 * 
 * @author Marek Cech
 */
@Repository
public class UserJpaDao extends NaKupJpaBaseDao<User> implements UserDao {

	/**
	 * Constructor calling superclass.
	 */
	public UserJpaDao() {
		super(User.class);
	}

}
