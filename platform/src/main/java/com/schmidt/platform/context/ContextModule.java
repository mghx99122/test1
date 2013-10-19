/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.platform.context;

import java.util.Set;

import javax.ws.rs.ApplicationPath;

import com.schmidt.himalia.restful.AbstractModule;

/**
 * 
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0, 2013��10��7��
 */
@ApplicationPath("context")
public class ContextModule extends AbstractModule {

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.restful.AbstractModule#register(java.util.Set)
	 */
	@Override
	protected void register(final Set<Class<?>> resources) {
		resources.add(TestContextManager.class);
	}
}
