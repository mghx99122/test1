/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.test.logging;

import org.testng.annotations.Test;

import com.schmidt.himalia.logging.Log;
import com.schmidt.himalia.logging.LogFactory;

/**
 * @author danny
 */
public class TestLogger {

	/**
	 * the logger
	 */
	private Log log = LogFactory.getLog(TestLogger.class);
	
	/**
	 * test log
	 */
	@Test public void testLog() {
		log.info("my testing for logger for: {} {}", 1, new Exception("CCC"));
	}
}
