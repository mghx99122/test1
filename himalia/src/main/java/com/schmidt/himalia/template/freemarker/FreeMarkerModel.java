/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.template.freemarker;

import java.util.Map;

import javax.enterprise.inject.spi.CDI;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.schmidt.himalia.context.ContextManager;

import freemarker.ext.beans.BeanModel;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/**
 * the FreeMarker data model is used to process template to response output stream
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
class FreeMarkerModel extends BeanModel {

	/**
	 * the variables
	 */
	private Map<String, Object> variables;
	
	/**
	 * the component manager
	 */
	private ContextManager componentManager;
	
	/**
	 * the current SERVLET request object 
	 */
	private HttpServletRequest request;
	
	/**
	 * the current SERVLET session
	 */
	private HttpSession session;
	
	/**
	 * @param value the root value
	 * @param variables the variables
	 */
	public FreeMarkerModel(final Object value, final Map<String, Object> variables) {
		super(value, new BeansWrapper());
		this.variables = variables;
	}

	/**
	 * {@inheritDoc}
	 * @see freemarker.ext.beans.BeanModel#get(java.lang.String)
	 */
	public TemplateModel get(final String name) throws TemplateModelException {
		
		// if root object isn't null, will try to get variable by property name
		if (this.getWrappedObject() != null) {
			TemplateModel model = super.get(name);
			if (model != null) {
				return model;
			}
		}
		
		// try to test where name exists in variable map, will use it
		if (this.variables.containsKey(name)) {
			return this.wrap(this.variables.get(name));
		}
		
		// try to test it is SERVLET predefine name, if it is, will use it
		if ("request".equals(name)) {
			return this.wrap(this.getRequest());
		} else if ("session".equals(name)) {
			return this.wrap(this.getSession());
		} 
		
		return this.wrap(this.getComponentManager().get(name));
	}
	
	/**
	 * @return the component manager
	 */
	private ContextManager getComponentManager() {
		
		if (this.componentManager == null) {
			this.componentManager = CDI.current().select(ContextManager.class).get();
		}
		return this.componentManager;
	}
	
	/**
	 * @return the current SERVLET request object
	 */
	private ServletRequest getRequest() {
		
		if (this.request == null) {
			this.request = this.getComponentManager().get(HttpServletRequest.class);
		}
		return this.request;
	}
	
	/**
	 * @return the current SERVLET session object
	 */
	private HttpSession getSession() {
		
		if (this.session == null) {
			this.session = this.getComponentManager().get(HttpSession.class);
		}
		return this.session;
	}
}
