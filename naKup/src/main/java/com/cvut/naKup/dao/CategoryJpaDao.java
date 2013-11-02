package com.cvut.naKup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.cvut.naKup.domain.Category;
import com.cvut.naKup.domain.Goods;

@Repository
public class CategoryJpaDao extends NaKupJpaBaseDao<Category> implements CategoryDao{

	public CategoryJpaDao() {
		super(Category.class);		
	}
	
	@SuppressWarnings("unchecked")
	public List<Goods> goodsInCategory(Category c){
		return getEntityManager().createQuery("SELECT e FROM Goods e WHERE e.category = "+ c).getResultList();
	}
}
