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
import com.cvut.naKup.domain.Order;
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
	
	/**
	 * {@link HashMap} of user's basket.
	 */
	private Map<Long, Goods> basket = new HashMap<Long, Goods>();
	
	/**
	 * {@link Goods} service.
	 */
	@Autowired
	private GoodsService goodsService;
	
	/**
	 * {@link Order} service.
	 */
	@Autowired
	private OrderService orderService;
	
	/**
	 * Method for ajax requests. Returns content of basket.
	 * 
	 * @return {@link Collection} of basket content.
	 */
	@RequestMapping(value="/ajax/cart", method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody Collection<Goods> getCartAjax() {
	    return new ArrayList<Goods>(basket.values());
	}
	
	/**
	 * Method for removing item from basket.
	 * 
	 * @param goodsId Id of item to remove.
	 * @return {@link String} containing result of removing.
	 */
	@RequestMapping(value="/ajax/cart/remove/{goodsId}", method = RequestMethod.POST)
	public @ResponseBody String removeItemAjax(@PathVariable Long goodsId) {
		basket.remove(goodsId);
		return "OK";
	}
	
	/**
	 * Method for cleaning cart.
	 * 
	 * @return {@link String} containing result of removing.
	 */
	@RequestMapping(value="/ajax/cart/empty", method = RequestMethod.POST)
	public @ResponseBody String emptyCartAjax() {
		basket.clear();
		return "OK";
	}
	
	/**
	 * Method returning content of cart.
	 * 
	 * @param model {@link ModelMap} for creating jsp.
	 * @return name of jsp to show.
	 */
	@RequestMapping(value="/cart", method=RequestMethod.GET)
	public String getCart(ModelMap model) {
		model.addAttribute("goods", basket.values());
	    return "basket";
	}
	
	/**
	 * Method for adding item to cart.
	 * 
	 * @param goodsId Id of item to add.
	 * @return redirect to index.
	 */
	@RequestMapping(value="/cart/add/{goodsId}", method = RequestMethod.POST)
	public String addItem(@PathVariable Long goodsId) {
		Goods toAdd = goodsService.getById(goodsId);
		if (toAdd != null) {
			basket.put(goodsId, toAdd);
		}
		return "redirect:/";
	}
	
	/**
	 * Method for removing item from cart.
	 * 
	 * @param goodsId Id of item to remove.
	 * @return redirect to cart page.
	 */
	@RequestMapping(value="/cart/remove/{goodsId}", method = RequestMethod.POST)
	public String removeItem(@PathVariable Long goodsId) {
		basket.remove(goodsId);
		return "redirect:/cart";
	}
	
	/**
	 * Method for cleaning cart.
	 * 
	 * @return redirect to index page.
	 */
	@RequestMapping(value="/cart/empty", method = RequestMethod.POST)
	public String empty() {
		basket.clear();
		return "redirect:/";
	}
	
	/**
	 * Method for sending cart to process.
	 * 
	 * @return redirect to index page.
	 */
	@RequestMapping(value="/cart/send", method = RequestMethod.POST)
	public String send() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			Long loggedId = (Long) authentication.getDetails();
			orderService.processBasket(basket.values(), loggedId);
			basket.clear();
			return "redirect:/";
		}
		return "redirect:/";
	}

	/**
	 * Setter of {@link GoodsService}.
	 * 
	 * @param goodsService {@link GoodsService} to set.
	 */
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	/**
	 * Setter of {@link OrderService}.
	 * 
	 * @param orderService {@link OrderService} to set.
	 */
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
}
