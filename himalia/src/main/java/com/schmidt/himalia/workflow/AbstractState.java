/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.workflow;

/**
 * the helper for state in work flow
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
public class AbstractState implements State {

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.workflow.State#before(java.lang.String)
	 */
	@Override
	public void before(final String id) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.workflow.State#after(java.lang.String)
	 */
	@Override
	public void after(final String id) {
		// do nothing
	}
}
