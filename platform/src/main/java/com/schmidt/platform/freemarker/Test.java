/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.platform.freemarker;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.schmidt.himalia.restful.Render;
import com.schmidt.himalia.restful.Renders;

/**
 * 
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */

@RequestScoped
@Path("/")
public class Test {

	public String getTitle() {
		return "XXXX";
	}
	
	@Path("/tx")
	@Renders(value = { 
			@Render(id = "a", template = "platform/freemarker/testa.ftl"),
	})
	public String test() {
		return "a";
	}
}
