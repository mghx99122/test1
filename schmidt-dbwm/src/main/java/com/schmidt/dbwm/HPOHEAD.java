/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.dbwm;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.schmidt.himalia.data.AbstractHome;

/**
 * 
 *
 * @author Ji Chen
 * @version $Id$
 * @since 1.0
 */
@RequestScoped
public class HPOHEAD extends AbstractHome<POHEAD,String>{
	
	@Inject @DBWM private EntityManager entityManager;

	/**
	 * create by CDI container
	 */
	public HPOHEAD() {
		// do nothing
	}

	/**
	 * create by application
	 * 
	 * @param entityManager
	 */
	public HPOHEAD(EntityManager entityManager) {
		this.entityManager = entityManager;
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
	public Class<POHEAD> getEntityClass() {
		return POHEAD.class;
	}
}
