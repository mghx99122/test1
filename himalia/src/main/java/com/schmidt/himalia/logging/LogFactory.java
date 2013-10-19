/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.logging;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * The log factory is used to create logger by class or name in application.
 * 
 * @author Danny Chen
 * @version $Id$
 * @since 1.0, 2013/7/19
 */
public final class LogFactory {

	/**
	 * the utility class
	 */
	protected LogFactory() {
		// do nothing
	}
	
	/**
	 * create logger by a class. It is used in a class to log message for this class. For example:
	 * <pre>
	 * public class Test {
	 * 	private final Log log = LogFactory.getLog(Test.class);
	 * 	...
	 * }
	 * </pre>
	 * 
	 * @param clazz the class for the new logger
	 * @return the new log
	 */
	public static Log getLog(final Class<?> clazz) {
		return getLog(LoggerFactory.getLogger(clazz.getName()));
	}

	/**
	 * create logger by a logger name. For example:
	 * <pre>
	 * public class Test {
	 * 	private final Log log = LogFactory.getLog(Test.class);
	 * 	...
	 * }
	 * </pre>
	 * 
	 * @param name the log name
	 * @return the new log
	 */
	public static Log getLog(final String name) {
		return getLog(LoggerFactory.getLogger(name));
	}

	/**
	 * @param logger the logger of the delegated logger
	 * @return the log
	 */
	private static Log getLog(final Logger logger) {
		return new Log(logger);
	}
}
