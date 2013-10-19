/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.platform.context;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Path;

import com.schmidt.himalia.restful.Render;
import com.schmidt.himalia.restful.Renders;

/**
 * 
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0, 2013��10��8��
 */
@Path("/")
@RequestScoped
public class TestContextManager {

	/**
	 * @return the result of ContextManager
	 */
	@Path("/ContextManager")
	@Renders(value = { 
			@Render(id = "A", template = "platform/context/TestContextManager"),
	})
	public String find() {
		return "A";
	}
	
}
