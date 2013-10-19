/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.platform.freemarker;

import java.util.Set;

import javax.ws.rs.ApplicationPath;

import com.schmidt.himalia.restful.AbstractModule;

/**
 * 
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
@ApplicationPath("/test")
public class Module extends AbstractModule {

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.restful.AbstractModule#register(java.util.Set)
	 */
	@Override
	protected void register(Set<Class<?>> resources) {
		resources.add(Test.class);
	}

}
