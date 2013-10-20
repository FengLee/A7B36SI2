package com.cvut.naKup.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cvut.naKup.domain.Person;

@Repository
public class PersonJpaDao implements PersonDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public Long persist(Person p) {
		em.persist(p);
		return p.getId();
	}

}
