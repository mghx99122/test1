/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.gr01;

import java.util.Set;

import javax.ws.rs.ApplicationPath;

import com.schmidt.himalia.restful.AbstractModule;

/**
 * MODULE gr01: Purchase Order 管理
 *
 * @author Ji Chen
 * @version $Id$
 * @since 1.0
 */
@ApplicationPath("/gr01")
public class Module extends AbstractModule {

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.restful.AbstractModule#register(java.util.Set)
	 */
	@Override
	protected void register(Set<Class<?>> resources) {
		resources.add(GR01.class);
	}
}
