package com.cvut.naKup.service;

import com.cvut.naKup.domain.PersonalMsg;

/**
 * Service interface for {@link PersonalMsg}.
 * 
 * @author Marek Cech
 */
public interface PersonalMsgService {
	
	/**
	 * Persists given {@link PersonalMsg} to database.
	 * 
	 * @param msg {@link PersonalMsg} to persist.
	 */
	public Long persist(PersonalMsg msg);

}
