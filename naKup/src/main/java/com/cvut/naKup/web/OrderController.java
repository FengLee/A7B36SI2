package com.cvut.naKup.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cvut.naKup.domain.Order;
import com.cvut.naKup.domain.User;
import com.cvut.naKup.service.OrderService;
import com.cvut.naKup.service.UserService;

/**
 * 
 * @author vavat
 *
 */
@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	@RequestMapping(value="/profile/{userId}/orders", method=RequestMethod.GET)
	public String order(@PathVariable Long userId,ModelMap map){
		List<Order> res = orderService.getByUserId(userId);
		User user = userService.findById(userId);
		map.addAttribute("user", user);
		map.put("listOrders", res);
		return "orders";
	}
}
