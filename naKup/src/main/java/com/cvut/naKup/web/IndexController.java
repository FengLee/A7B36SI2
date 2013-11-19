package com.cvut.naKup.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cvut.naKup.domain.Goods;
import com.cvut.naKup.service.CategoryService;
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
	@Autowired
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<Goods> res = goodsService.getAll();
		model.put("listGoods", res);
		int count = ((((res.size())%6)==0)?((res.size())/6):((res.size()/6)+1));
		model.addAttribute("numbPages", count);		
		model.addAttribute("next", 2);
		model.addAttribute("prev", 1);
		model.addAttribute("begin", 0);
		model.addAttribute("end", 2);
		model.addAttribute("prevBool", true);
		model.addAttribute("nextBool", false);
		model.addAttribute("catBool", false);
		model.addAttribute("currentPage", 1);
		return "index";
	}	
	
	@RequestMapping(value="/{pageId}", method = RequestMethod.GET)
	public String pagination(@PathVariable Long pageId, ModelMap model){
		int page = pageId.intValue();
		model.addAttribute("currentPage", page);
		model.addAttribute("catBool", false);
		Long prev = (long)(pageId-1);
		model.addAttribute("prev", prev);
		Long last =(long)((((goodsService.getAll().size())%6)==0)?((goodsService.getAll().size())/6):((goodsService.getAll().size()/6)+1));
		Long next = (long)(pageId+1);
		model.addAttribute("next", next);		
		model.addAttribute("numbPages", last.intValue());
		Long begin = (long)(pageId*3)-3;
		model.addAttribute("begin", begin.intValue());
		Long end = (long)(pageId*3)-1;
		model.addAttribute("end", end.intValue());
		boolean nextBool = (pageId == last)?true:false;
		boolean prevBool = (pageId == 1)?true:false;
		model.addAttribute("prevBool", prevBool);
		model.addAttribute("nextBool", nextBool);
		List<Goods> res = goodsService.getAll();
		model.put("listGoods", res);
		return "index";
	}
	
	@RequestMapping(value="/category/{catName}/{pageId}", method = RequestMethod.GET)
	public String paginationCategory(@PathVariable String catName, @PathVariable Long pageId, ModelMap model){
		int page = pageId.intValue();
		model.addAttribute("catBool", true);
		model.addAttribute("currentPage", page);
		model.addAttribute("category", catName);
		String prev = "/category/"+catName+"/"+(pageId-1);
		model.addAttribute("prev", prev);
		List<Goods> res = categoryService.getAllGoodsInCategory(catName);
		model.put("listGoods", res);
		Long last =(long)((((res.size())%6)==0)?((res.size())/6):((res.size()/6)+1));
		String next = "/category/"+catName+"/"+(pageId+1);
		model.addAttribute("next", next);		
		model.addAttribute("numbPages", last.intValue());
		Long begin = (long)(pageId*3)-3;
		model.addAttribute("begin", begin.intValue());
		Long end = (long)(pageId*3)-1;
		model.addAttribute("end", end.intValue());
		boolean nextBool = (pageId == last)?true:false;
		boolean prevBool = (pageId == 1)?true:false;
		model.addAttribute("prevBool", prevBool);
		model.addAttribute("nextBool", nextBool);
		
		return "index";
	}
	
	@RequestMapping(value="/category/{catName}", method = RequestMethod.GET)
	public String category(@PathVariable String catName, ModelMap model){		
		List<Goods> res = categoryService.getAllGoodsInCategory(catName);		
		model.addAttribute("category", catName);
		model.addAttribute("catBool", true);
		model.put("listGoods", res);
		int count = ((((res.size())%6)==0)?((res.size())/6):((res.size()/6)+1));
		model.addAttribute("numbPages", count);		
		model.addAttribute("next", ("/category/"+catName+"/2"));
		model.addAttribute("prev", ("/category/"+catName+"/1"));
		model.addAttribute("begin", 0);
		model.addAttribute("end", 2);
		model.addAttribute("prevBool", true);
		boolean nextBool = !(count > 3);
		model.addAttribute("nextBool", nextBool);
		model.addAttribute("currentPage", 1);
		
		return "index";
	}
	
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
}
