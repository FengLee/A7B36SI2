package com.cvut.naKup.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller of login page.
 * 
 * @author Marek Cech
 */
@Controller
public class LoginController {
	
	/**
	 * Method for showing login page.
	 * 
	 * @return name of jsp to show.
	 */
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
 
	/**
	 * Method for handling login errors.
	 * 
	 * @param model {@link ModelMap} to put attributes to.
	 * @return name of jsp to show.
	 */
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "login";
 
	}
 
	/**
	 * Method for logout handling.
	 * 
	 * @param model {@link ModelMap} to put attributes to.
	 * @return name of jsp to show.
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "login";
	}

}
