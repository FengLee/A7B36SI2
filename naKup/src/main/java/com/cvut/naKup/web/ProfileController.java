package com.cvut.naKup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cvut.naKup.domain.User;
import com.cvut.naKup.service.UserService;
import com.cvut.naKup.web.form.RegistrationForm;

@Controller
public class ProfileController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/profile/{userId}", method = RequestMethod.GET)
	public String showPage(@PathVariable Long userId, ModelMap model) {
		User user = userService.findById(userId);
		model.addAttribute("user", user);
		return "profile";
	}
	
	@RequestMapping(value="/profile/{userId}/edit", method = RequestMethod.GET)
	public ModelAndView editProfile(@PathVariable Long userId, ModelMap model) {
		ModelAndView mav = new ModelAndView("profileEditation", "command", new RegistrationForm());
		User user = userService.findById(userId);
		mav.addObject("user", user);
		return mav;
	}
	
	@RequestMapping(value="/profile/{userId}/edit", method = RequestMethod.POST)
	public String editProfile(@PathVariable Long userId, @ModelAttribute("SpringWeb") RegistrationForm form) {
		userService.updateUser(form, userId);
		return "redirect:/profile/{userId}";
	}
}
