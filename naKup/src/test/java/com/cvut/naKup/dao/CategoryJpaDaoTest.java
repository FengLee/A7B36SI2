package com.cvut.naKup.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cvut.naKup.NaKupTest;
import com.cvut.naKup.domain.Category;
import com.cvut.naKup.domain.Goods;
/**
 * This class contains tests of {@link CategoryDao}
 * 
 * @author Vlastimil Fengl
 *
 */
public class CategoryJpaDaoTest extends NaKupTest{
	/**
	 * {@link CategoryDao} to test
	 */
	@Autowired
	CategoryDao categoryDao;
	/**
	 * {@link GoodsDao} 
	 */
	@Autowired
	GoodsDao goodsDao;
	
	private Long cId;
	/**
	 * Preparation method
	 */
	@Before
	public void setUp(){
		Category c = new Category();
		c.setName("Ovoce");
		Goods g = new Goods();
		g.setName("Banan");
		g.setCost(2.75);
		g.setCategory(c);
		g.setText("bla bla bla");
		cId = categoryDao.persist(c);
		goodsDao.persist(g);
	}
	/**
	 * Test findById method
	 */
	@Test
	public void testFindById(){
		Category res = categoryDao.findById(cId);
		assertEquals("Ovoce",res.getName());
	}
	/**
	 * Test getByName method
	 */
	@Test
	public void testGetByName(){
		Category res = categoryDao.getByName("Ovoce");
		assertEquals(cId, res.getEntityId());
	}
	/**
	 * Test loadAll method
	 */
	@Test
	public void testLoadAll(){
		List<Category> res = categoryDao.loadAll();
		assertEquals(1, res.size());
		assertEquals("Ovoce", res.get(0).getName());
	}
	/**
	 * Test getCount method
	 */
	@Test
	public void testGetCount(){
		Long count = categoryDao.getCount();
		Long res = new Long(1);
		assertEquals(res, count);
	}
	/**
	 * Test goodsInCategory method
	 */
	@Test
	public void testGoodsInCategory(){
		List<Goods> res = categoryDao.goodsInCategory("Ovoce");
		assertEquals(1, res.size());
		assertEquals("Banan", res.get(0).getName());
	}
}
