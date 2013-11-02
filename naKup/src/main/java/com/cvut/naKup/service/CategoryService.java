package com.cvut.naKup.service;

import java.util.List;

import com.cvut.naKup.domain.Category;
import com.cvut.naKup.domain.Goods;

/**
 * 
 * @author vavat
 *
 */
public interface CategoryService {
	
	public Category getById(Long id);
	
	public Long save(Category c);
	
	public void update(Category c);
	
	public List<Category> getAll();
	
	public List<Goods> getAllGoodsInCategory(Category c);
}
