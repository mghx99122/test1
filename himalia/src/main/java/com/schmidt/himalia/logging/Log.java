/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.logging;

import org.slf4j.Logger;

/**
 * The log logs runtime diagnosis message, parameters and thrown exception to console or files 
 *  
 * @author Danny Chen
 * @version $Id$
 * @since 1.0, 2013/7/19
 */
public class Log {

	/**
	 * the delegated logger
	 */
	private Logger logger;

	/**
	 * create logger with the delegated logger. This constructor is called in {@link LogFactory} currently.
	 *  
	 * @param logger the delegated logger
	 * @see LogFactory
	 */
	protected Log(final Logger logger) {
		this.logger = logger;
	}

	/**
	 * @return whether DEBUG level logging is enabled
	 */
	public boolean isDebugEnabled() {
		return this.logger.isDebugEnabled();
	}

	/**
	 * <p>log DEBUG level message with pattern and values of arguments, last parameter can be exception. For example: 
	 * <pre>{@code
	 * private static final Log log = LogFactory.getLog("name");
	 * ...
	 * log.debug("Application starts at :{}", new Date(), e);
	 * }
	 * </pre>
	 * </p>
	 *  
	 * @param pattern the pattern that is used to formatted to message with arguments.
	 * @param args the values of arguments for parameter pattern.
	 */
	public void debug(final String pattern, final Object... args) {
		this.logger.debug(pattern, args);
	}

	/**
	 * @return whether INFO level logging is enabled
	 */
	public boolean isInfoEnabled() {
		return this.logger.isInfoEnabled();
	}

	/**
	 * <p>log INFO level message with pattern and values of arguments, last parameter can be exception. For example: 
	 * <pre>{@code
	 * private static final Log log = LogFactory.getLog("name");
	 * ...
	 * log.debug("Application starts at :{}", new Date(), e);
	 * }
	 * </pre>
	 * </p>
	 * 
	 * @param pattern the pattern that is used to formatted to message with arguments 
	 * @param args the values of arguments for parameter pattern.
	 */
	public void info(final String pattern, final Object... args) {
		this.logger.info(pattern, args);
	}

	/**
	 * @return whether WARN level logging is enabled
	 */
	public boolean isWarnEnabled() {
		return this.logger.isWarnEnabled();
	}

	/**
	 * <p>log WARN level message with pattern and values of arguments, last parameter can be exception. For example: 
	 * <pre>{@code
	 * private static final Log log = LogFactory.getLog("name");
	 * ...
	 * log.debug("Application starts at :{}", new Date(), e);
	 * }
	 * </pre>
	 * </p>
	 * 
	 * @param pattern the pattern that is used to formatted to message with arguments 
	 * @param args the values of arguments for parameter pattern.
	 */
	public void warn(final String pattern, final Object... args) {
		this.logger.warn(pattern, args);
	}

	/**
	 * @return whether ERROR level logging is enabled
	 */
	public boolean isErrorEnabled() {
		return this.logger.isErrorEnabled();
	}

	/**
	 * <p>log ERROR level message with pattern and values of arguments, last parameter can be exception. For example: 
	 * <pre>{@code
	 * private static final Log log = LogFactory.getLog("name");
	 * ...
	 * log.debug("Application starts at :{}", new Date(), e);
	 * }
	 * </pre>
	 * </p>
	 * 
	 * @param pattern the pattern that is used to formatted to message with arguments 
	 * @param args the values of arguments for parameter pattern.
	 */
	public void error(final String pattern, final Object... args) {
		this.logger.error(pattern, args);
	}
}
