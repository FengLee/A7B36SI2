package com.cvut.naKup.service;

import java.util.List;

import com.cvut.naKup.domain.Goods;

/**
 * 
 * @author vavat
 *
 */
public interface GoodsService {
	
	public Goods getById(Long id);
	
	public Long save(Goods g);
	
	public Long update(Goods g);
	
	public List<Goods> getAll();
}
