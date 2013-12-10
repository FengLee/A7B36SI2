package com.cvut.naKup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cvut.naKup.dao.GoodsDao;
import com.cvut.naKup.domain.Goods;
import com.cvut.naKup.domain.User;
import com.cvut.naKup.web.form.ProductForm;

/**
 * Implementation of {@link Goods} service.
 * 
 * Implements {@link GoodsService}.
 * 
 * @author Vlastimil Fengl, Marek Cech
 */
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
	
	/**
	 * DAO of {@link Goods} entity.
	 */
	@Autowired
	private GoodsDao goodsdao;
	
	/**
	 * DAO of {@link User} entity.
	 */
	@Autowired
	private UserService userService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long update(Goods g) {
		goodsdao.update(g);		
		return g.getEntityId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(ProductForm form, Long id) {
		Goods goods = goodsdao.findById(id);
		if (goods == null) {
			return;
		}
		goods.setName(form.getName());
		goods.setCost(form.getCost());
		goods.setText(form.getText());
		goodsdao.update(goods);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void persist(ProductForm form, Long userId) {
		User user = userService.findById(userId);
		Goods goods = new Goods();
		goods.setName(form.getName());
		goods.setCost(form.getCost());
		goods.setText(form.getText());
		goods.setVendor(user);
		goodsdao.persist(goods);
		
		user.getGoods().add(goods);
		userService.update(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void remove(Long goodsId, Long userId) {
		User user = userService.findById(userId);
		List<Goods> goods = user.getGoods();
		for (int i=0; i<goods.size(); i++) {
			if (goods.get(i).getEntityId() == goodsId) {
				goods.remove(i);
				break;
			}
		}
		userService.update(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Goods> getAll() {
		List<Goods> res = goodsdao.loadAll();
		return res;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Goods getById(Long id) {		
		return goodsdao.findById(id);
	}

	/**
	 * Setter of {@link UserService}.
	 * @param userService {@link UserService} to set.
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
