package com.cvut.naKup.service;

import java.util.List;

import com.cvut.naKup.domain.Category;
import com.cvut.naKup.domain.Goods;
import com.cvut.naKup.web.form.CategoryForm;

/**
 * 
 * @author vavat
 *
 */
public interface CategoryService {
	
	public Category getById(Long id);
	
	public Category getByName(String s);
	
	public Long save(CategoryForm form);
	
	public void update(String name, CategoryForm form);
	
	public List<Category> getAll();
	
	public List<Goods> getAllGoodsInCategory(String c);
	
	public List<Category> getRootCategories();
	
	public List<Category> getSubCategories(String s);
}
