/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.platform.freemarker;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.schmidt.himalia.restful.Model;
import com.schmidt.himalia.restful.Render;
import com.schmidt.himalia.restful.Renders;

/**
 * this resource class is used to test FreeMarker template
 * 
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
@Path("/")
@RequestScoped
public class FreeMarkerTemplate {

	//@Inject HUSRMAS hursmst;
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return "Just a title";
	}
	
	/**
	 * @return the result
	 */
	@GET @Path("/ta")
	@Renders(value = { 
			@Render(id = "A", template = "platform/freemarker/testa.ftl"),
	})
	public String ta() {
		int a = 0;
		//EntityManager em = this.hursmst.getEntityManager();
		a = a + 1;
		return "A";
	}

	/**
	 * @return the result
	 */
	@GET @Path("/tb")
	@Renders(value = { 
			@Render(id = "A", template = "platform/freemarker/testb.ftl"),
	})
	public Model tb() {
		return new Model("A", this);
	}
}
