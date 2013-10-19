/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.workflow;

/**
 * the work flow
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
public interface Workflow {

	/**
	 * @return the work flow type
	 */
	String getType();
	
	/**
	 * @return the work flow name
	 */
	String getName();
}
