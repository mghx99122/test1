/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.workflow;

import javax.enterprise.inject.spi.Bean;

/**
 * the manager interface that is used to find state bean from container
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
public interface StateManager {
	
	/**
	 * find state bean from container
	 * 
	 * @param type the state type
	 * @param id the state id
	 * @return the bean or <code>null</code> if does not exist
	 */
	Bean<?> getStateBean(String type, String id);
	
	/**
	 * @param bean the state bean
	 * @return the type of bean
	 */
	String getType(Bean<?> bean);
}
