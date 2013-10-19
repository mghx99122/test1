/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.restful;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

/**
 * the default JAX-RS module for platform, all modules should extend from it
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
public abstract class AbstractModule extends Application {

	/**
	 * {@inheritDoc}
	 * @see javax.ws.rs.core.Application#getClasses()
	 */
	@Override
	public Set<Class<?>> getClasses() {
		
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(StringTemplateWriter.class);
		classes.add(ModelTemplateWriter.class);
		this.register(classes);
		return classes;
	}
	
	/**
	 * @param resources the set to register resource class
	 */
	protected abstract void register(Set<Class<?>> resources);
}
