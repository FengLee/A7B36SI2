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
	
	/**
	 * Service of {@link User}.
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * Service of {@link Goods}.
	 */
	@Autowired
	private GoodsService goodsService;
	
	/**
	 * Method for showing products of user with given id.
	 * 
	 * @param userId EntityId of {@link User} whose products to show.
	 * @param model {@link ModelMap} for creating jsp.
	 * @return name of jsp to show.
	 */
	@RequestMapping(value="/profile/{userId}/products", method = RequestMethod.GET)
	public String showPage(@PathVariable Long userId, ModelMap model) {
		User user = userService.findByIdWithGoods(userId);
		model.addAttribute("user", user);
		return "products";
	}
	
	/**
	 * Method for showing product detail.
	 * 
	 * @param userId EntityId of {@link User} whose products to show.
	 * @param productId EntityId of {@link Goods} to show.
	 * @param model {@link ModelMap} for creating jsp.
	 * @return name of jsp to show.
	 */
	@RequestMapping(value="/profile/{userId}/products/{productId}", method = RequestMethod.GET)
	public String showDetailPage(@PathVariable Long userId, @PathVariable Long productId, ModelMap model) {
		Goods goods = goodsService.getById(productId);
		model.addAttribute("user", goods.getVendor());
		model.addAttribute("goods", goods);
		return "productDetail";
	}
	
	/**
	 * Method for product editation.
	 * 
	 * @param userId EntityId of {@link User} whose products to edit.
	 * @param productId EntityId of {@link Goods} to show.
	 * @param model {@link ModelMap} for creating jsp.
	 * @return name of jsp to show.
	 */
	@RequestMapping(value="/profile/{userId}/products/{productId}/edit", method = RequestMethod.GET)
	public ModelAndView showEditPage(@PathVariable Long userId, @PathVariable Long productId, ModelMap model) {
		ModelAndView mav = new ModelAndView("productEditation", "command", new ProductForm());
		Goods goods = goodsService.getById(productId);
		mav.addObject("goods", goods);
		model.addAttribute("user", goods.getVendor());
		return mav;
	}
	
	/**
	 * Method for updating {@link Goods} after editation.
	 * 
	 * @param userId EntityId of {@link User} whose products to update.
	 * @param productId EntityId of {@link Goods} to show.
	 * @param form {@link ProductForm} with updated data.
	 * @return redirect to product detail.
	 */
	@RequestMapping(value="/profile/{userId}/products/{productId}/edit", method = RequestMethod.POST)
	public String editProduct(@PathVariable Long userId, @PathVariable Long productId, @ModelAttribute("SpringWeb") ProductForm form) {
		goodsService.update(form, productId);
		return "redirect:/profile/{userId}/products/{productId}";
	}
	
	/**
	 * Method for deleting product.
	 * 
	 * @param userId EntityId of {@link User} whose products to delete.
	 * @param productId EntityId of {@link Goods} to delete.
	 * @return redirect to list of products.
	 */
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
	
	/**
	 * Method for showing page of new product form.
	 * 
	 * @param userId EntityId of {@link User} whose products to add.
	 * @param model {@link ModelMap} for creating jsp.
	 * @return {@link ModelAndView} with {@link ProductForm}.
	 */
	@RequestMapping(value="/profile/{userId}/products/add", method = RequestMethod.GET)
	public ModelAndView showAddPage(@PathVariable Long userId, ModelMap model) {
		User user = userService.findById(userId);
		model.addAttribute("user", user);
		return new ModelAndView("addProduct", "command", new ProductForm());
	}
	
	/**
	 * Method for adding new product
	 * 
	 * @param userId EntityId of {@link User} whose products to add.
	 * @param form {@link ProductForm} with data about new product.
	 * @return redirect to list of products.
	 */
	@RequestMapping(value="/profile/{userId}/products/add", method = RequestMethod.POST)
	public String addProduct(@PathVariable Long userId, @ModelAttribute("SpringWeb") ProductForm form) {
		goodsService.persist(form, userId);
		return "redirect:/profile/{userId}/products";
	}

	/**
	 * Setter of {@link UserService}.
	 * 
	 * @param userService {@link UserService} to set.
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Setter of {@link GoodsService}.
	 * 
	 * @param goodsService {@link GoodsService} to set.
	 */
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

}
