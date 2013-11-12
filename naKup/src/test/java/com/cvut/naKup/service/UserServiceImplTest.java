package com.cvut.naKup.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
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
	
	private RegistrationForm form;
	
	/**
	 * Preparation method.
	 */
	@Before
	public void setUp() {
		form = new RegistrationForm();
		form.setFirstName("Jan");
		form.setLastName("Novak");
		form.setLogin("a@b.cz");
		form.setPassword("1234");
		form.setStreet("Dlouha 23");
		form.setCity("Lhota");
		form.setPsc("12345");
		form.setCustomer(true);
		form.setPopis("popis");
		
	}
	
	/**
	 * This method tests new user adding.
	 */
	@Test
	public void testAddUser() {
		Long id = userService.addUser(form);
		assertNotNull(id);
		
		User user = userService.findById(id);
		assertEquals(form.getFirstName(), user.getFirstName());
		assertEquals(form.getLastName(), user.getLastName());
		assertEquals(form.getLogin(), user.getLogin());
		assertEquals(form.getStreet(), user.getStreet());
		assertEquals(form.getCity(), user.getCity());
		assertEquals(form.getPsc(), user.getZip());
		assertEquals(form.getPopis(), user.getDescription());
		assertEquals(Authority.Buyer, user.getAuthority());
	}
	
	/**
	 * This method tests updating user.
	 */
	@Test
	public void testUpdateUser() {
		Long id = userService.addUser(form);
		assertNotNull(id);
		
		form.setFirstName("Honzik");
		form.setLastName("Novaku");
		form.setStreet("Nejdelsi 23");
		form.setCity("Dlouha lhota");
		form.setPsc("12340");
		form.setPopis("dlouhy popis");
		
		userService.updateUser(form, id);
		User updated = userService.findById(id);
		
		assertEquals(form.getFirstName(), updated.getFirstName());
		assertEquals(form.getLastName(), updated.getLastName());
		assertEquals(form.getStreet(), updated.getStreet());
		assertEquals(form.getCity(), updated.getCity());
		assertEquals(form.getPsc(), updated.getZip());
		assertEquals(form.getPopis(), updated.getDescription());
	}
	
}
