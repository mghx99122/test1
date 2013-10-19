/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.template;

import java.io.IOException;

/**
 * The template engine is used to compile template source code into compiled template object
 * 
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
public interface TemplateEngine {

	/**
	 * @return the name of engine
	 */
	String getName();
	
	/**
	 * @return the remark of engine
	 */
	String getRemark();
	
	/**
	 * compile template resource to compiled template
	 * 
	 * @param source the source code
	 * @return the compiled template
	 * @throws IOException if fail to compile FreeMarker template
	 */
	Template compile(String source) throws IOException;
}
