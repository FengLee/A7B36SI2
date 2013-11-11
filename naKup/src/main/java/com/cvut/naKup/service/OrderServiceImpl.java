package com.cvut.naKup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cvut.naKup.dao.OrderDao;
import com.cvut.naKup.domain.Goods;
import com.cvut.naKup.domain.Order;

/**
 * 
 * @author vavat
 *
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order getById(Long id) {		
		return orderDao.findById(id);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long save(Order o) {
		return orderDao.persist(o);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Order o) {
		orderDao.update(o);		
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Order> getByUserId(Long id) {
		List<Order> res = orderDao.getByUserId(id);
		return res;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Goods> goodsInOrder(Long id) {
		Order o = orderDao.findById(id);
		List<Goods> res = o.getGoods();
		return res;
	}
	
}
