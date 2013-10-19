/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.workflow;

/**
 * the business logic for state in work flow
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
public interface State {

	/**
	 * @param id the id for processing work flow
	 */
	void before(String id);
	
	/**
	 * @param id the id for processing work flow
	 */
	void after(String id);
}
