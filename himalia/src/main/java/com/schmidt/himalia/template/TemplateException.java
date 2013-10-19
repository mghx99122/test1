/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.template;

/**
 * the exception that will raise if fail to process FreeMarker template
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
public class TemplateException extends Exception {

	/**
	 * the serial version UID
	 */
	private static final long serialVersionUID = -7018283864614645270L;

	/**
	 * @param message the error message
	 * @param cause the parent exception
	 */
	public TemplateException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
