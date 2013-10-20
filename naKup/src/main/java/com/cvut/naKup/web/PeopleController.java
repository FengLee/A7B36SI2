package com.cvut.naKup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cvut.naKup.domain.Person;
import com.cvut.naKup.service.PersonService;

@Controller
public class PeopleController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/people")
	public String people(ModelMap model) {
		Person p = new Person();
		p.setFirstName("Jan");
		p.setLastName("Novak");
		Long id = personService.persist(p);
		model.put("personId", id);
		return "people";
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

}
