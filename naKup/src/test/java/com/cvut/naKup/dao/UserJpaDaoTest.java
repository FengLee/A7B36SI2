package com.cvut.naKup.dao;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cvut.naKup.NaKupTest;
import com.cvut.naKup.domain.Authority;
import com.cvut.naKup.domain.User;

/**
 * This class contains tests of {@link UserDao}.
 * 
 * @author Marek Cech
 */
public class UserJpaDaoTest extends NaKupTest {
	
	/**
	 * {@link UserDao} to test.
	 */
	@Autowired
	UserDao userDao;
	
	/**
	 * Field containing id of persisted {@link User}.
	 */
	private Long id1;
	
	/**
	 * Preparation method.
	 */
	@Before
	public void setUp() {
		User user1 = new User();
		user1.setFirstName("Jan");
		user1.setLastName("Novak");
		user1.setLogin("a@b.cz");
		user1.setPassword("1234");
		user1.setStreet("Dlouha 23");
		user1.setCity("Lhota");
		user1.setZip("12345");
		user1.setAuthority(Authority.Buyer);
		id1 = userDao.persist(user1);
		
		User user2 = new User();
		user2.setFirstName("Pepa");
		user2.setLastName("Vyskoc");
		user2.setLogin("c@d.cz");
		user2.setPassword("9876");
		user2.setStreet("Kratka 32");
		user2.setCity("Velkomesto");
		user2.setZip("54321");
		user2.setAuthority(Authority.Seller);
		userDao.persist(user2);
	}
	
	/**
	 * Test of findById method.
	 */
	@Test
	public void testFindById() {
		User found = userDao.findById(id1);
		assertEquals("a@b.cz", found.getLogin());
	}
	
	/**
	 * Test of loadAll method.
	 */
	@Test
	public void testLoadAll() {
		List<User> users = userDao.loadAll();
		assertEquals(2, users.size());
	}
	
	/**
	 * Test of getCount method.
	 */
	@Test
	public void testGetCount() {
		Long count = userDao.getCount();
		Long expected = new Long(2);
		assertEquals(expected, count);
	}
	
	/**
	 * Test of find method.
	 */
	@Test
	public void testFind() {
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("login", "a@b.cz");
		List<User> users = userDao.find(User.FIND_BY_LOGIN, attributes);
		
		assertEquals(1, users.size());
		assertEquals("Dlouha 23", users.get(0).getStreet());
	}

}
