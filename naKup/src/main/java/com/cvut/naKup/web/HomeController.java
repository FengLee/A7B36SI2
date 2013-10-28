package com.cvut.naKup.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller of homepage.
 * 
 * @author marek cech
 *
 */
@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home() {
		return "home";
	}
}
