/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.platform.freemarker;

import java.util.Set;

import javax.ws.rs.ApplicationPath;

import com.schmidt.himalia.restful.AbstractModule;

/**
 * @author $Author$
 * @version $Id$
 * @since 1.0, 2013��9��17��
 */
@ApplicationPath("test")
public class FreeMarkerModule extends AbstractModule {

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.restful.AbstractModule#register(java.util.Set)
	 */
	@Override
	protected void register(final Set<Class<?>> resources) {
		resources.add(FreeMarkerTemplate.class);
		resources.add(Test.class);
	}
}
