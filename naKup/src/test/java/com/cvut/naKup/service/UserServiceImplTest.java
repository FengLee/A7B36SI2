package com.cvut.naKup.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cvut.naKup.NaKupTest;
import com.cvut.naKup.domain.Authority;
import com.cvut.naKup.domain.User;
import com.cvut.naKup.web.form.RegistrationForm;

/**
 * This class contains tests of {@link UserService}.
 * 
 * @author Marek Cech
 */
public class UserServiceImplTest extends NaKupTest {

	/**
	 * {@link UserService} to test.
	 */
	@Autowired
	UserService userService;
	
	/**
	 * This method tests new user adding.
	 */
	@Test
	public void testAddUser() {
		RegistrationForm form = new RegistrationForm();
		form.setFirstName("Jan");
		form.setLastName("Novak");
		form.setLogin("a@b.cz");
		form.setPassword("1234");
		form.setStreet("Dlouha 23");
		form.setCity("Lhota");
		form.setPsc("12345");
		form.setCustomer(true);
		
		Long id = userService.addUser(form);
		assertTrue(id != null);
		
		User user = userService.findById(id);
		assertEquals(form.getFirstName(), user.getFirstName());
		assertEquals(Authority.Buyer, user.getAuthority());
	}
	
}
