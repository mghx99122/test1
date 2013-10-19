/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.platform.data;

import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.ProviderUtil;


/**
 * 
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
public class TestProvider implements PersistenceProvider {

	/**
	 * {@inheritDoc}
	 * @see javax.persistence.spi.PersistenceProvider#createContainerEntityManagerFactory(javax.persistence.spi.PersistenceUnitInfo, java.util.Map)
	 */
	@Override
	public EntityManagerFactory createContainerEntityManagerFactory(PersistenceUnitInfo arg0, Map arg1) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see javax.persistence.spi.PersistenceProvider#createEntityManagerFactory(java.lang.String, java.util.Map)
	 */
	@Override
	public EntityManagerFactory createEntityManagerFactory(String arg0, Map arg1) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see javax.persistence.spi.PersistenceProvider#generateSchema(javax.persistence.spi.PersistenceUnitInfo, java.util.Map)
	 */
	@Override
	public void generateSchema(PersistenceUnitInfo arg0, Map arg1) {
	}

	/**
	 * {@inheritDoc}
	 * @see javax.persistence.spi.PersistenceProvider#generateSchema(java.lang.String, java.util.Map)
	 */
	@Override
	public boolean generateSchema(String arg0, Map arg1) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @see javax.persistence.spi.PersistenceProvider#getProviderUtil()
	 */
	@Override
	public ProviderUtil getProviderUtil() {
		return null;
	}

}
