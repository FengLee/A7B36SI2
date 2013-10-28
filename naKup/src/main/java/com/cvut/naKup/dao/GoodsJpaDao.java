package com.cvut.naKup.dao;

import org.springframework.stereotype.Repository;

import com.cvut.naKup.domain.Goods;

@Repository
public class GoodsJpaDao extends NaKupJpaBaseDao<Goods> implements GoodsDao{

	public GoodsJpaDao() {
		super(Goods.class);		
	}

}
