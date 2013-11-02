package com.cvut.naKup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cvut.naKup.dao.GoodsDao;
import com.cvut.naKup.domain.Goods;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsDao goodsdao;
	
	@Override
	public Long save(Goods g) {		
		return goodsdao.persist(g);
	}

	@Override
	public Long update(Goods g) {
		goodsdao.update(g);		
		return g.getEntityId();
	}

	@Override
	public List<Goods> getAll() {
		List<Goods> res = goodsdao.loadAll();
		return res;
	}

	@Override
	public Goods getById(Long id) {		
		return goodsdao.findById(id);
	}

}
