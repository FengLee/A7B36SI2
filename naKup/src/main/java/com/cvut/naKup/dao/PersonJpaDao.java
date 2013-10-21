package com.cvut.naKup.dao;

import org.springframework.stereotype.Repository;

import com.cvut.naKup.domain.Person;

/**
 * Test dao.
 * 
 * @author marek
 *
 */
@Repository
public class PersonJpaDao extends NaKupJpaBaseDao<Person> implements PersonDao {
	
	public PersonJpaDao() {
		super(Person.class);
	}
	
}
