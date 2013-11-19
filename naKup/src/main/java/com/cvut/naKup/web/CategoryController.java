package com.cvut.naKup.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cvut.naKup.domain.Category;
import com.cvut.naKup.service.CategoryService;

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
	
	
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
}
