package com.cvut.naKup.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.cvut.naKup.domain.NaKupEntity;

/**
 * NaKup base for dao interfaces.
 * 
 * @author marek cech
 *
 */
public interface NaKupBaseDao<T extends NaKupEntity> {
	
	/**
	 * Returns {@link EntityManager} used by dao.
	 * 
	 * @return {@link EntityManager}
	 */
	public EntityManager getEntityManager();
	
	/**
	 * Finds entity by given id.
	 * 
	 * @param id ID of entity to find.
	 * @return entity with given id, or <code>null</code> if not exists.
	 */
	public T findById(Long id);
	
	/**
	 * Returns all persistent instances of the given entity class.
	 * 
	 * @return {@link List} containing persistent instances, empty if no instance persisted, never <code>null</code>
	 */
	public List<T> loadAll();
	
	/**
	 * Persists entity and returns it's database ID.
	 * 
	 * @param entity to persist
	 * @return id of entity persisted
	 */
	public Long persist(T entity);

	/**
	 * Updates database entity.
	 * 
	 * @param entity to update
	 */
	public void update(T entity);

	/**
	 * Removes given entity from database.
	 * 
	 * @param entity to remove
	 */
	public void remove(T entity);

}
