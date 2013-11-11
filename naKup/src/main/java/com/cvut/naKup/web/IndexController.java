package com.cvut.naKup.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<Goods> res = goodsService.getAll();
		model.put("listGoods", res);
		int count = (((res.size())%6)==0)?((res.size())/6):((res.size()/6)+1);
		model.addAttribute("numbPages", count);		
		model.addAttribute("next", 2);
		model.addAttribute("prev", 1);
		model.addAttribute("begin", 0);
		model.addAttribute("end", 2);
		model.addAttribute("prevBool", true);
		model.addAttribute("nextBool", false);
		model.addAttribute("currentPage", 1);
		return "index";
	}	
	
	@RequestMapping(value="/{pageId}", method = RequestMethod.GET)
	public String pagination(@PathVariable Long pageId, ModelMap model){
		model.addAttribute("currentPage", pageId);
		Long prev = (pageId-1);
		model.addAttribute("prev", prev);
		Long last =(long)((((goodsService.getAll().size())%6)==0)?((goodsService.getAll().size())/6):((goodsService.getAll().size()/6)+1));
		Long next = (pageId+1);
		model.addAttribute("next", next);		
		model.addAttribute("numbPages", last);
		Long begin = (pageId*3)-3;
		model.addAttribute("begin", begin);
		Long end = (pageId)-1;
		model.addAttribute("end", end);
		boolean nextBool = (pageId == last)?true:false;
		boolean prevBool = (pageId == 1)?true:false;
		model.addAttribute("prevBool", prevBool);
		model.addAttribute("nextBool", nextBool);
		return "index";
	}
	
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
}
