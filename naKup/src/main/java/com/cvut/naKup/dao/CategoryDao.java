package com.cvut.naKup.dao;

import java.util.List;

import com.cvut.naKup.domain.Category;
import com.cvut.naKup.domain.Goods;

/**
 * 
 * @author vavat
 *
 */
public interface CategoryDao extends NaKupBaseDao<Category>{
	public List<Goods> goodsInCategory(String c);
}
