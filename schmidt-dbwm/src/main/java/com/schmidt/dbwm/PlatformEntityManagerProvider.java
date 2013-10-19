/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.dbwm;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;

import com.schmidt.himalia.data.EntityManagerProducer;

/**
 * 
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
@ApplicationScoped
public class PlatformEntityManagerProvider extends EntityManagerProducer {

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.EntityManagerProducer#getPersistenceUnitName()
	 */
	@Override
	public String getPersistenceUnitName() {
		return "dbwm";
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.data.EntityManagerProducer#createEntityManager()
	 */
	@Override
	@Produces @RequestScoped public EntityManager createEntityManager() {
		return super.createEntityManager();
	}
}
