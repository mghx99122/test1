/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.wm.freemarker;

import java.util.Set;

import javax.ws.rs.ApplicationPath;

import com.schmidt.himalia.restful.AbstractModule;




/**
 * 
 *
 * @author LU HI YU
 * @version $Id$
 * @since 1.0
 */
@ApplicationPath("wm")
public class Module extends AbstractModule {

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.restful.AbstractModule#register(java.util.Set)
	 */
	@Override
	protected void register(Set<Class<?>> resources) {
		resources.add(WM01.class);
		resources.add(WM02.class);
		resources.add(WM03.class);
	}

}
