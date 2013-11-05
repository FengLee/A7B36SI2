package com.cvut.naKup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cvut.naKup.domain.User;
import com.cvut.naKup.service.UserService;

@Controller
@RequestMapping("/profile/{userId}")
public class ProfileController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showPage(@PathVariable Long userId, ModelMap model) {
		User user = userService.findById(userId);
		model.addAttribute("user", user);
		
		return "profile";
	}
	
}
