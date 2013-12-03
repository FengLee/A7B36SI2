package com.cvut.naKup.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cvut.naKup.domain.Category;
import com.cvut.naKup.service.CategoryService;
import com.cvut.naKup.web.form.CategoryForm;

/**
 * 
 * @author vavat
 *
 */
@Controller
public class CategoryController {
		
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value="/categories", method=RequestMethod.GET)	
	public String category(ModelMap model){
		List<Category> res = categoryService.getAll();
		model.put("listCategory", res);
		return "categories";
	}
	
	@RequestMapping(value="/{catName}/edit", method=RequestMethod.GET)
	public ModelAndView editCategory(@PathVariable String catName){
		ModelAndView mav = new ModelAndView("categoryEdit", "command", new CategoryForm());
		Category cat = categoryService.getByName(catName);
		mav.addObject("category", cat);
		return mav;
	}
	
	@RequestMapping(value="/{catName}/edit", method=RequestMethod.POST)
	public String editCategory(@PathVariable String catName, @ModelAttribute("SpringWeb") CategoryForm form){
		Category c = categoryService.getByName(catName);
		c.setName(form.getName());
		categoryService.update(c);
		return "redirect:/categories";
	}
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
}
