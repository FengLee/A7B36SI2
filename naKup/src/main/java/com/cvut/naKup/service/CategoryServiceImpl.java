package com.cvut.naKup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cvut.naKup.dao.CategoryDao;
import com.cvut.naKup.domain.Category;
import com.cvut.naKup.domain.Goods;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public Long save(Category c) {		
		return categoryDao.persist(c);
	}

	@Override
	public void update(Category c) {
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

}
