package com.cvut.naKup.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cvut.naKup.NaKupTest;
import com.cvut.naKup.domain.Authority;
import com.cvut.naKup.domain.Goods;
import com.cvut.naKup.domain.Order;
import com.cvut.naKup.domain.User;

public class OrderJpaDaoTest extends NaKupTest{
	/**
	 * {@link UserDao}
	 */
	@Autowired
	UserDao userDao;
	/**
	 * {@link OrderDao} to test
	 */
	@Autowired
	OrderDao orderDao;
	/**
	 * {@link GoodsDao}
	 */
	@Autowired
	GoodsDao goodsDao;
	
	private Long uid1, uid2, oid, gid;
	
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
		uid1 = userDao.persist(user1);
		
		User user2 = new User();
		user2.setFirstName("Pepa");
		user2.setLastName("Vyskoc");
		user2.setLogin("c@d.cz");
		user2.setPassword("9876");
		user2.setStreet("Kratka 32");
		user2.setCity("Velkomesto");
		user2.setZip("54321");
		user2.setAuthority(Authority.Seller);
		uid2 = userDao.persist(user2);
		
		Goods g = new Goods();
		g.setName("Jablko");
		g.setCost(2.75);
		List<Goods> goods = new ArrayList<Goods>();
		goods.add(g);
		gid = goodsDao.persist(g);
		
		Order o = new Order();
		o.setWeight(1.0);
		o.setFrom(user2);
		o.setForWho(user1);
		o.setGoods(goods);
		oid = orderDao.persist(o);
	}
	/**
	 * Test findById method
	 */
	@Test
	public void testFindById(){
		Order o = orderDao.findById(oid);		
		assertEquals("Pepa", o.getFrom().getFirstName());				
	}
	/**
	 * Test getByUserId method
	 */
	@Test
	public void testGetByUserId(){
		List<Order> res = orderDao.getByUserId(uid1);
		assertEquals(1, res.size());
		assertEquals("Jan", res.get(0).getForWho().getFirstName());
	}
}
