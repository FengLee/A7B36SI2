package com.cvut.naKup.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cvut.naKup.domain.Goods;
import com.cvut.naKup.service.GoodsService;

/**
 * Controller of homepage.
 * 
 * @author vavat
 */
@Controller
public class IndexController {
	
	/**
	 * {@link GoodsService} for obtaining data about goods.
	 */
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/")
	public String index(ModelMap model) {
		List<Goods> res = goodsService.getAll();
		model.put("listGoods", res);
		return "index";
	}	
	
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
}
