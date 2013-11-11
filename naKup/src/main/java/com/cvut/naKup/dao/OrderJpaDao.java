package com.cvut.naKup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cvut.naKup.domain.Order;
/**
 * 
 * @author vavat
 *
 */
@Repository
public class OrderJpaDao extends NaKupJpaBaseDao<Order> implements OrderDao{

	public OrderJpaDao() {
		super(Order.class);		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Order> getByUserId(Long id) {
		return getEntityManager().createQuery("SELECT o FROM Order o WHERE o.forWho = "+id).getResultList();
	}
}
