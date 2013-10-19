/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.template.freemarker;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;

/**
 * This template loader is used to load FreeMarker template for application
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
// TODO: should implement class path from jar
// TODO: should implement loading template from database
public class FreeMarkerTemplateLoader extends MultiTemplateLoader {

	/**
	 * Construct FreeMarker template loader
	 */
	public FreeMarkerTemplateLoader() {
		
		super(new TemplateLoader[] {
				new ClassTemplateLoader(
						FreeMarkerTemplateLoader.class, "/com/schmidt"
				)
		});
	}
}
