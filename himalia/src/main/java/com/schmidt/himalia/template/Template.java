/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.template;

import java.io.OutputStream;
import java.util.Map;

/**
 * the compiled template object in order to evaluate with data and parameters
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
public interface Template {

	/**
	 * @return the template id
	 */
	String getId();
	
	/**
	 * Process compiled template to output stream by data and parameters.
	 * 
	 * @param value the value
	 * @param params the parameters
	 * @param out the output stream
	 * @exception TemplateException if fail to process FreeMarker template
	 */
	void process(Object value, Map<String, Object> params, OutputStream out) throws TemplateException;
}
