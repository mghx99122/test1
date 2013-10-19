/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.workflow;

/**
 * the exception will be raised in work flow if there is error
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
public class WorkflowException extends Exception {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -3342924223435223892L;

	/**
	 * @param message the exception message
	 */
	public WorkflowException(final String message) {
		super(message);
	}

	/**
	 * @param message the exception message
	 * @param cause the parent exception
	 */
	public WorkflowException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
