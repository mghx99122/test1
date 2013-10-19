/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.data;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * this class is a base producer in order to produce entity manager. 
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
public abstract class EntityManagerProducer {

	/**
	 * the entity manager factory
	 */
	private EntityManagerFactory entityManagerFactory;

	/**
	 * @return the persistence unit name
	 */
	public abstract String getPersistenceUnitName();
	
	/**
	 * load properties and create entity manager factory
	 */
	@PostConstruct void init() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory(this.getPersistenceUnitName());
	}
	
	/**
	 * @return the new entity manager factory
	 */
	public EntityManager createEntityManager() {
		return this.entityManagerFactory.createEntityManager();
	}
}
