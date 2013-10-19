/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.platform.data;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.schmidt.himalia.data.AbstractHome;

/**
 * 
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0, 2013��10��8��
 */
//@RequestScoped
public class HMITMAS extends AbstractHome<MITMAS, String> {

	private EntityManager entityManager;
	
	/**
	 * 
	 */
	public HMITMAS() {
		
	}
	
	/**
	 * @param entityManager the entity manager
	 */
	public HMITMAS(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * @param entityManager the entity manager
	 * @return the data access object
	 */
	public static HMITMAS instance(final EntityManager entityManager) {
		return new HMITMAS(entityManager);
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.AbstractHome#getEntityManager()
	 */
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.AbstractHome#getEntityClass()
	 */
	@Override
	public Class<MITMAS> getEntityClass() {
		return null;
	}
}
