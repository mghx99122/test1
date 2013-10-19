/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.workflow;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * the annotation is used to provide predefined state, and state will be used to assemble to a work flow.
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Provider {

	/**
	 * the state type
	 */
	String type();
	
	/**
	 * the state id
	 */
	String id();
}
