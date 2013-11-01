package com.cvut.naKup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cvut.naKup.domain.Authority;
import com.cvut.naKup.service.UserService;
import com.cvut.naKup.web.form.RegistrationForm;


@Controller
public class RegistrationController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView showPage() {
		return new ModelAndView("registration", "command", new RegistrationForm());
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("SpringWeb") RegistrationForm form) {
		userService.addUser(form);
		return "redirect:/";
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
