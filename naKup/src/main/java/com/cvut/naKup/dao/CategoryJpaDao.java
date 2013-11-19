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
	public List<Goods> goodsInCategory(String c){
		Category b = (Category) getEntityManager().createQuery("SELECT e FROM Category e WHERE e.name = ?").setParameter(1, c).getSingleResult();
		return getEntityManager().createQuery("SELECT e FROM Goods e WHERE e.category = "+ b.getEntityId()).getResultList();
	}
}
