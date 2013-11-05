package com.cvut.naKup.service;

import com.cvut.naKup.domain.User;
import com.cvut.naKup.web.form.RegistrationForm;

public interface UserService {

	public Long addUser(RegistrationForm form);
	
	public User findById(Long userId);
	
}
