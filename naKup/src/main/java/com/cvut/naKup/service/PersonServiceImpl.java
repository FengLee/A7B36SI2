package com.cvut.naKup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cvut.naKup.dao.PersonDao;
import com.cvut.naKup.domain.Person;

/**
 * Test service.
 * 
 * @author marek
 *
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDao personDao;

	public Long persist(Person p) {
		return personDao.persist(p);
	}
	
	public Long getCount() {
		return personDao.getCount();
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	
}
