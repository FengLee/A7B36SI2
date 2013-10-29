package com.cvut.naKup.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.cvut.naKup.domain.Category;
import com.cvut.naKup.domain.Goods;

@Repository
public class CategoryJpaDao extends NaKupJpaBaseDao<Category> implements CategoryDao{

	public CategoryJpaDao() {
		super(Category.class);		
	}
	
	public List<Goods> goodsInCategory(Category c){
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Goods> cq = cb.createQuery(Goods.class);
		Root<Goods> root = cq.from(Goods.class);
		cq.select(root).where(cb.equal(root.get("category_id"), c.getEntityId()));
		return getEntityManager().createQuery(cq).getResultList();
	}
}
