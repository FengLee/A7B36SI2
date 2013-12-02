package com.cvut.naKup.service;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import com.cvut.naKup.domain.Goods;
import com.cvut.naKup.domain.User;
import com.cvut.naKup.web.form.ProductForm;

/**
 * Goods service interface.
 * 
 * @author Vlastimil Fengl, Marek Cech
 */
public interface GoodsService {
	
	/**
	 * Returns {@link Goods} by given id.
	 * 
	 * @param id Id of persited entity.
	 * @return {@link Goods} found by given id.
	 */
	public Goods getById(Long id);
	
	/**
	 * Updates given {@link Goods} entity.
	 * 
	 * @param g {@link Goods} to update.
	 * @return Id of updated entity.
	 */
	public Long update(Goods g);
	
	/**
	 * Updates {@link Goods} entity by given id.
	 * 
	 * @param form {@link ProductForm} with updated data.
	 * @param id Id of entity to update.
	 */
	public void update(ProductForm form, Long id);
	
	/**
	 * Persists new user's {@link Goods}.
	 * 
	 * @param form {@link ProductForm} with data to persist.
	 * @param userId Id of {@link User}.
	 */
	public void persist(ProductForm form, Long userId);
	
	/**
	 * Removes {@link Goods} entity by given goodsId.
	 * 
	 * @param goodsId Id of {@link Goods} to remove.
	 * @param userId Id of {@link User} - owner of {@link Goods}.
	 */
	public void remove(Long goodsId, Long userId);
	
	/**
	 * Returns all persited {@link Goods}.
	 * 
	 * @return {@link List} of persited {@link Goods}.
	 */
	public List<Goods> getAll();
	
}
