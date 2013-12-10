package com.cvut.naKup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cvut.naKup.dao.UserDao;
import com.cvut.naKup.domain.Authority;
import com.cvut.naKup.domain.User;
import com.cvut.naKup.web.form.RegistrationForm;

/**
 * Implementation of {@link UserService}.
 * 
 * @author Marek Cech
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	/**
	 * {@link UserDao} for obtaining data about users.
	 */
	@Autowired
	private UserDao userDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long addUser(RegistrationForm form) {
		User user = new User();
		if (form.isCustomer()) {
			user.setAuthority(Authority.Buyer);
		} else {
			user.setAuthority(Authority.Seller);
		}
		user.setFirstName(form.getFirstName());
		user.setLastName(form.getLastName());
		user.setLogin(form.getLogin());
		user.setPassword(form.getPassword());
		user.setStreet(form.getStreet());
		user.setCity(form.getCity());
		user.setZip(form.getPsc());
		user.setDescription(form.getPopis());
		
		return userDao.persist(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateUser(RegistrationForm form, Long userId) {
		User user = userDao.findById(userId);
		if (user == null) {
			return;
		}
		user.setFirstName(form.getFirstName());
		user.setLastName(form.getLastName());
		user.setStreet(form.getStreet());
		user.setCity(form.getCity());
		user.setZip(form.getPsc());
		user.setDescription(form.getPopis());
		userDao.update(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findById(Long userId) {
		return userDao.findById(userId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findByIdWithGoods(Long userId) {
		User user = userDao.findById(userId);
		if (user != null) {
			user.getGoods().size();
			return user;
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(User user) {
		userDao.update(user);
	}

	/**
	 * Setter of {@link UserDao}.
	 * 
	 * @param userDao {@link UserDao} to set.
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
