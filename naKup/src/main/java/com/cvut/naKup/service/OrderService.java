package com.cvut.naKup.service;

import java.util.List;

import com.cvut.naKup.domain.Goods;
import com.cvut.naKup.domain.Order;

/**
 * 
 * @author vavat
 *
 */
public interface OrderService {
	
	/**
	 * Method for obtaining order by id
	 * 
	 * @param id id of order to find
	 * @return {@link Order} found in database
	 */
	public Order getById(Long id);
	/**
	 * Method for adding new order
	 * 
	 * @param o {@link Order} with data of new order
	 * @return Id of new order
	 */
	public Long save(Order o);
	/**
	 * Method for updating order
	 * 
	 * @param o {@link Order} with new data
	 */
	public void update(Order o);
	/**
	 * Method for obtaining orders by user id
	 * 
	 * @param id Id of user
	 * @return List of orders
	 */
	public List<Order> getByUserId(Long id);
	/**
	 * Method for obtaining goods in order by orderId
	 * 
	 * @param id Id of order
	 * @return List of goods
	 */
	public List<Goods> goodsInOrder(Long id);
}
