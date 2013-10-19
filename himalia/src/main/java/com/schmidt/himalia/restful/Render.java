/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.restful;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * the annotation defines template and engine to process data model that returns from method
 * 
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Render {

	/**
	 * the id
	 */
	String id();
	
	/**
	 * the template to be processed 
	 */
	String template();
	
	/**
	 * whether redirect to another page 
	 */
	String redirect() default "";
}
