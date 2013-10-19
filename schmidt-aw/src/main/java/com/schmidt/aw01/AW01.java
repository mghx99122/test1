/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.aw01;

import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.schmidt.dbwm.DBWM;
import com.schmidt.dbwm.HPOHEAD;
import com.schmidt.dbwm.HPOLINE;
import com.schmidt.dbwm.POHEAD;
import com.schmidt.dbwm.POLINE;
import com.schmidt.himalia.restful.Model;
import com.schmidt.himalia.restful.Render;
import com.schmidt.himalia.workflow.WorkflowException;
import com.schmidt.himalia.workflow.WorkflowManager;

/**
 * This class processes work flow with request URL. The URL pattern is: {workflow}/{state}/{step}/{id}.
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
@Path("/")
@RequestScoped
public class AW01 {

	/**
	 * the work flow manager
	 */
	@Inject private WorkflowManager workflowManager;
	
	@Inject private HPOHEAD poHeadDao;
	
	@Inject private HPOLINE poLineDao;
	
	@Inject private EntityManager entityManager;
	
	/**
	 * Process by defined work flow with state, step and id
	 * 
	 * @param workflow the defined work flow
	 * @param state the state
	 * @param step the step
	 * @param id the id
	 * @return the model that work flow processed
	 */
	@Path("{workflow}/{state}/{step}/{id}")
	public Model process(
			final @PathParam("workflow") String workflow, final @PathParam("state") String state, 
			final @PathParam("step") String step, final @PathParam("id") String id) {

		try {
			return this.workflowManager.process(workflow, state, step, id);
		} catch (WorkflowException e) { 
			throw new WebApplicationException(
					"Fail to execute work flow: [" + workflow + "]", e, Response.Status.INTERNAL_SERVER_ERROR
			);
		}
	}
	
	
}
