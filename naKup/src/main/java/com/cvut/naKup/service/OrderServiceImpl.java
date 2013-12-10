package com.cvut.naKup.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cvut.naKup.dao.OrderDao;
import com.cvut.naKup.domain.Goods;
import com.cvut.naKup.domain.Order;
import com.cvut.naKup.domain.User;

/**
 * Implementation of {@link OrderService}.
 * 
 * @author vavat, Marek Cech
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	
	/**
	 * Dao of {@link Order} entity.
	 */
	@Autowired
	private OrderDao orderDao;
	
	/**
	 * Dao of {@link User} entity.
	 */
	@Autowired
	private UserService userService;

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
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processBasket(Collection<Goods> basket, Long userId) {
		Iterator<Goods> iterator = basket.iterator();
		User buyer = userService.findById(userId);
		if (buyer == null) return;
		Goods goods;
		while (iterator.hasNext()) {
			goods = iterator.next();
			Order order = new Order();
			
			User vendor = userService.findById(goods.getVendor().getEntityId());
			order.setForWho(vendor);
			order.setFrom(buyer);
			order.getGoods().add(goods);
			
			orderDao.persist(order);
			vendor.getOrders().add(order);
			userService.update(vendor);
		}
	}
	
	/**
	 * Setter of {@link OrderDao}.
	 * 
	 * @param orderDao {@link OrderDao} to set.
	 */
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	/**
	 * Setter of {@link UserService}.
	 * 
	 * @param userService {@link UserService} to set.
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
