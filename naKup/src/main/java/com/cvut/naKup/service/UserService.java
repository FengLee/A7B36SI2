package com.cvut.naKup.service;

import com.cvut.naKup.domain.Goods;
import com.cvut.naKup.domain.User;
import com.cvut.naKup.web.form.RegistrationForm;

/**
 * Service for handling data about users.
 * 
 * @author Marek Cech
 */
public interface UserService {

	/**
	 * Method for adding new user.
	 * 
	 * @param form {@link RegistrationForm} with data about new user.
	 * @return Id of new user.
	 */
	public Long addUser(RegistrationForm form);
	
	/**
	 * Method for updating user.
	 * 
	 * @param form {@link RegistrationForm} with data about new user.
	 * @param userId Id of user to update.
	 */
	public void updateUser(RegistrationForm form, Long userId);
	
	/**
	 * Method for obtaining {@link User} by id.
	 * 
	 * @param userId Id of user to find.
	 * @return {@link User} found in database.
	 */
	public User findById(Long userId);
	
	/**
	 * Method for updating {@link User}.
	 * 
	 * @param user {@link User} to update.
	 */
	public void update(User user);
	
	/**
	 * Method for obtaining {@link User} with his {@link Goods}.
	 * 
	 * @param userId Id of {@link User} to find.
	 * @return {@link User} with fetched {@link Goods}.
	 */
	public User findByIdWithGoods(Long userId);
	
}
