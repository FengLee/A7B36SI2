package com.cvut.naKup.dao;

import java.util.List;

import com.cvut.naKup.domain.Order;
/**
 * 
 * @author vavat
 *
 */
public interface OrderDao extends NaKupBaseDao<Order>{
	public List<Order> getByUserId(Long id);
}
