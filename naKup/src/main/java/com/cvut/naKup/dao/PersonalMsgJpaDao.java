package com.cvut.naKup.dao;

import org.springframework.stereotype.Repository;

import com.cvut.naKup.domain.PersonalMsg;

/**
 * Dao Implementation of {@link PersonalMsg}.
 * 
 * Extends {@link NaKupJpaBaseDao}.
 * Implements {@link PersonalMsgDao}.
 * 
 * @author Marek Cech
 */
@Repository
public class PersonalMsgJpaDao extends NaKupJpaBaseDao<PersonalMsg> implements PersonalMsgDao {

	/**
	 * Constructor calling superclass.
	 */
	public PersonalMsgJpaDao() {
		super(PersonalMsg.class);		
	}
	
}
