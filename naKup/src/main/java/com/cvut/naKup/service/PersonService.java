package com.cvut.naKup.service;

import com.cvut.naKup.domain.Person;

/**
 * Test service.
 * 
 * @author marek
 *
 */
public interface PersonService {
	
	public Long persist(Person p);
	
	public Long getCount();

}
