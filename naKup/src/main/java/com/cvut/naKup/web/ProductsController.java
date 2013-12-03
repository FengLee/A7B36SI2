package com.cvut.naKup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cvut.naKup.domain.Goods;
import com.cvut.naKup.domain.User;
import com.cvut.naKup.service.GoodsService;
import com.cvut.naKup.service.UserService;
import com.cvut.naKup.web.form.ProductForm;

/**
 * Controller for handling products requests.
 * 
 * @author Marek Cech
 */
@Controller
public class ProductsController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value="/profile/{userId}/products", method = RequestMethod.GET)
	public String showPage(@PathVariable Long userId, ModelMap model) {
		User user = userService.findByIdWithGoods(userId);
		model.addAttribute("user", user);
		return "products";
	}
	
	@RequestMapping(value="/profile/{userId}/products/{productId}", method = RequestMethod.GET)
	public String showDetailPage(@PathVariable Long userId, @PathVariable Long productId, ModelMap model) {
		Goods goods = goodsService.getById(productId);
		model.addAttribute("user", goods.getVendor());
		model.addAttribute("goods", goods);
		return "productDetail";
	}
	
	@RequestMapping(value="/profile/{userId}/products/{productId}/edit", method = RequestMethod.GET)
	public ModelAndView showEditPage(@PathVariable Long userId, @PathVariable Long productId, ModelMap model) {
		ModelAndView mav = new ModelAndView("productEditation", "command", new ProductForm());
		Goods goods = goodsService.getById(productId);
		mav.addObject("goods", goods);
		model.addAttribute("user", goods.getVendor());
		return mav;
	}
	
	@RequestMapping(value="/profile/{userId}/products/{productId}/edit", method = RequestMethod.POST)
	public String editProduct(@PathVariable Long userId, @PathVariable Long productId, @ModelAttribute("SpringWeb") ProductForm form) {
		goodsService.update(form, productId);
		return "redirect:/profile/{userId}/products/{productId}";
	}
	
	@RequestMapping(value="/profile/{userId}/products/{productId}/delete", method = RequestMethod.POST)
	public String deleteProduct(@PathVariable Long userId, @PathVariable Long productId) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			Long loggedId = (Long) authentication.getDetails();
			if (loggedId == userId) {
				goodsService.remove(productId, userId);
			}
		}
		return "redirect:/profile/{userId}/products";
	}
	
	@RequestMapping(value="/profile/{userId}/products/add", method = RequestMethod.GET)
	public ModelAndView showAddPage(@PathVariable Long userId, ModelMap model) {
		User user = userService.findById(userId);
		model.addAttribute("user", user);
		return new ModelAndView("addProduct", "command", new ProductForm());
	}
	
	@RequestMapping(value="/profile/{userId}/products/add", method = RequestMethod.POST)
	public String addProduct(@PathVariable Long userId, @ModelAttribute("SpringWeb") ProductForm form) {
		goodsService.persist(form, userId);
		return "redirect:/profile/{userId}/products";
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

}
