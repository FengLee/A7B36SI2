package com.cvut.naKup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cvut.naKup.dao.UserDao;
import com.cvut.naKup.domain.Authority;
import com.cvut.naKup.domain.User;
import com.cvut.naKup.web.form.RegistrationForm;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

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
		user.setPsc(form.getPsc());
		user.setPopis(form.getPopis());
		
		return userDao.persist(user);
	}

	@Override
	public void updateUser(RegistrationForm form, Long userId) {
		User user = userDao.findById(userId);
		user.setFirstName(form.getFirstName());
		user.setLastName(form.getLastName());
		user.setStreet(form.getStreet());
		user.setCity(form.getCity());
		user.setPsc(form.getPsc());
		user.setPopis(form.getPopis());
		userDao.update(user);
	}

	@Override
	public User findById(Long userId) {
		return userDao.findById(userId);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
