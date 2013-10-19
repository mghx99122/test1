/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.aw01;

import java.util.Set;

import javax.ws.rs.ApplicationPath;

import com.schmidt.himalia.restful.AbstractModule;

/**
 * MODULE AW01: Simple work flow processor
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
@ApplicationPath("/aw01")
public class Module extends AbstractModule {

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.restful.AbstractModule#register(java.util.Set)
	 */
	@Override
	protected void register(Set<Class<?>> resources) {
		resources.add(AW01.class);
	}
}
