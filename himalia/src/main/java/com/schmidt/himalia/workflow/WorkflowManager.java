/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.workflow;

import com.schmidt.himalia.restful.Model;

/**
 * the work flow manager. It is used to find all configured work flow
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
public interface WorkflowManager {

	/**
	 * Process work flow with state, step and id
	 * 
	 * @param workflow work flow
	 * @param state the state
	 * @param step the step
	 * @param id the id
	 * @return the result model
	 * @exception WorkflowException if fail to process work flow
	 */
	Model process(
			final String workflow, final String state, final String step, final String id
	) throws WorkflowException;
}
