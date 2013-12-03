package com.cvut.naKup.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cvut.naKup.domain.Goods;
import com.cvut.naKup.service.GoodsService;
import com.cvut.naKup.service.OrderService;

/**
 * Controller for handling ajax and non-ajax cart requests.
 * 
 * @author Marek Cech
 */
@Controller
@Scope("session")
public class CartController {
	
	private Map<Long, Goods> basket = new HashMap<Long, Goods>();
	
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/ajax/cart", method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody Collection<Goods> getCartAjax() {
	    return new ArrayList<Goods>(basket.values());
	}
	
	@RequestMapping(value="/ajax/cart/remove/{goodsId}", method = RequestMethod.POST)
	public @ResponseBody String removeItemAjax(@PathVariable Long goodsId) {
		basket.remove(goodsId);
		return "OK";
	}
	
	@RequestMapping(value="/ajax/cart/empty", method = RequestMethod.POST)
	public @ResponseBody String emptyCartAjax() {
		basket.clear();
		return "OK";
	}
	
	
	@RequestMapping(value="/cart", method=RequestMethod.GET)
	public String getCart(ModelMap model) {
		model.addAttribute("goods", basket.values());
	    return "basket";
	}
	
	@RequestMapping(value="/cart/add/{goodsId}", method = RequestMethod.POST)
	public String addItem(@PathVariable Long goodsId) {
		Goods toAdd = goodsService.getById(goodsId);
		if (toAdd != null) {
			basket.put(goodsId, toAdd);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/cart/remove/{goodsId}", method = RequestMethod.POST)
	public String removeItem(@PathVariable Long goodsId) {
		basket.remove(goodsId);
		return "redirect:/cart";
	}
	
	@RequestMapping(value="/cart/empty", method = RequestMethod.POST)
	public String empty() {
		basket.clear();
		return "redirect:/";
	}
	
	@RequestMapping(value="/cart/send", method = RequestMethod.POST)
	public String send() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			Long loggedId = (Long) authentication.getDetails();
			orderService.processBasket(basket.values(), loggedId);
			basket.clear();
			return "redirect:/";
		}
		return "redirect:/cart";
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
}
