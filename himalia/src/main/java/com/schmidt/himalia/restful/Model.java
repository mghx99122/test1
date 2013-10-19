/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.restful;

import java.util.HashMap;
import java.util.Map;

/**
 * the model result that is generated from business method, and will be processed by template to output stream
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
public class Model {

	/**
	 * the id
	 */
	private String id;

	/**
	 * the value
	 */
	private Object value;
	
	/**
	 * the template
	 */
	private String template;
	
	/**
	 * the variables
	 */
	private Map<String, Object> variables = new HashMap<String, Object>();
	
	/**
	 * empty constructor
	 */
	public Model() {
		this(null);
	}
	
	/**
	 * @param id the id
	 */
	public Model(final String id) {
		this(id, null);
	}

	/**
	 * @param id the id
	 * @param value the value
	 */
	public Model(final String id, final Object value) {
		this.id = id;
		this.value = value;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id
	 */
	public void setId(final String id) {
		this.id = id;
	}
	
	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}
	
	/**
	 * @param value the value
	 */
	public void setValue(final Object value) {
		this.value = value;
	}
	
	/**
	 * @return the template
	 */
	public String getTemplate() {
		return template;
	}
	
	/**
	 * @param template the template to set
	 */
	public void setTemplate(final String template) {
		this.template = template;
	}

	/**
	 * @param varKey the key of variable
	 * @return the value of variable
	 */
	public Object getVariable(final String varKey) {
		return this.variables.get(varKey);
	}
	
	/**
	 * @param varKey the variable name
	 * @param varValue the value of variable
	 */
	public void setVariable(final String varKey, final Object varValue) {
		this.variables.put(varKey, varValue);
	}
	
	/**
	 * @return the map of variables
	 */
	public Map<String, Object> getVariables() {
		return this.variables;
	}
}
