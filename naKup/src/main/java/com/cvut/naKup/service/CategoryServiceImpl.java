package com.cvut.naKup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cvut.naKup.dao.CategoryDao;
import com.cvut.naKup.domain.Category;
import com.cvut.naKup.domain.Goods;
import com.cvut.naKup.web.form.CategoryForm;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public Long save(CategoryForm form) {
		Category c = new Category();
		c.setName(form.getName());
		return categoryDao.persist(c);
	}

	@Override
	public void update(String name, CategoryForm form) {
		Category c = categoryDao.getByName(name);
		c.setName(form.getName());
		categoryDao.update(c);		
	}

	@Override
	public List<Category> getAll() {
		return categoryDao.loadAll();
	}

	@Override
	public List<Goods> getAllGoodsInCategory(String c) {
		return categoryDao.goodsInCategory(c);
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public Category getById(Long id) {		
		return categoryDao.findById(id);
	}

	@Override
	public Category getByName(String s) {
		return categoryDao.getByName(s);
	}

	@Override
	public List<Category> getRootCategories() {
		return categoryDao.getRootCategories();
	}

	@Override
	public List<Category> getSubCategories(String s) {		
		return categoryDao.getSubCategories(s);
	}

}
