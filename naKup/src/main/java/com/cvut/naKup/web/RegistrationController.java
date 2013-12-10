package com.cvut.naKup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cvut.naKup.service.UserService;
import com.cvut.naKup.web.form.RegistrationForm;

/**
 * Controller of registration.
 * 
 * @author Marek Cech
 */
@Controller
public class RegistrationController {
	
	/**
	 * {@link UserService} for obtaining data about users.
	 */
	@Autowired
	private UserService userService;

	/**
	 * Method for showing registration page.
	 * 
	 * @return {@link ModelAndView} with {@link RegistrationForm}.
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView showPage() {
		return new ModelAndView("registration", "command", new RegistrationForm());
	}
	
	/**
	 * Method for handling sent form.
	 * 
	 * @param form {@link RegistrationForm} with data about new user.
	 * @return redirect to index page.
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("SpringWeb") RegistrationForm form) {
		userService.addUser(form);
		return "redirect:/";
	}

	/**
	 * Setter of {@link UserService}.
	 * 
	 * @param userService {@link UserService} to set.
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
