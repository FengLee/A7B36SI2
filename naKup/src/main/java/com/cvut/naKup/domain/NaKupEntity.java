package com.cvut.naKup.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Base class of entities with ID.
 * 
 * @author marek cech
 *
 */
@MappedSuperclass
public abstract class NaKupEntity{

	/**
	 * ID of entity.
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
	
	/**
	 * Getter of entity ID.
	 * @return entity ID or <code>null</code> if not persisted in DB
	 */
	@Transient
	public Long getEntityId() {
		return id;
	}
	
	/**
	 * Setter of entity ID.
	 * @param id of entity to set
	 */
	@Transient
	public void setEntityId(Long id) {
		this.id = id;
	}
	
	/**
	 * Equals method implementation.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (getEntityId() == null) {
			return false;
		}
		if (!(obj instanceof NaKupEntity)) {
			return false;
		}
		NaKupEntity other = (NaKupEntity) obj;
		return getEntityId().equals(other.getEntityId());
	}
	
	/**
	 * Hashcode method implementation.
	 */
	@Override
	public int hashCode() {
		if (getEntityId() == null) {
			return super.hashCode();
		}
		return getEntityId().hashCode();
	}
	
	/**
	 * ToString method implementation.
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + "(id = " + getEntityId() + ")";
	}
}
