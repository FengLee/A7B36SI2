package com.cvut.naKup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cvut.naKup.dao.PersonalMsgDao;
import com.cvut.naKup.domain.PersonalMsg;

/**
 * Service implementation for {@link PersonalMsg}.
 * 
 * Implements {@link PersonalMsgService}.
 * 
 * @author Marek Cech
 */
@Service
@Transactional
public class PersonalMsgServiceImpl implements PersonalMsgService {
	
	/**
	 * {@link PersonalMsgDao} for database access.
	 */
	@Autowired
	private PersonalMsgDao personalMsgDao;

	/**
	 * {@inheritDoc}}
	 */
	@Override
	public Long persist(PersonalMsg msg) {
		return personalMsgDao.persist(msg);
	}

	/**
	 * Setter of {@link PersonalMsgDao}.
	 */
	public void setPersonalMsgDao(PersonalMsgDao personalMsgDao) {
		this.personalMsgDao = personalMsgDao;
	}

}
