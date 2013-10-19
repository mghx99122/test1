/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.workflow;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

import com.schmidt.himalia.logging.Log;
import com.schmidt.himalia.logging.LogFactory;
import com.schmidt.himalia.restful.Model;

/**
 * the defined work flow by application. All states under work flow should have same type
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
public class WorkflowImpl implements Workflow {

	/**
	 * the logger
	 */
	private Log log = LogFactory.getLog(WorkflowImpl.class);
	
	/**
	 * the work flow type
	 */
	private String type;
	
	/**
	 * the work flow name
	 */
	private String name;
	
	/**
	 * all states of this work flow
	 */
	private Map<String, Bean<?>> stateBeans = new HashMap<String, Bean<?>>();
	
	/**
	 * @param type the work flow type
	 * @param name the work flow name
	 */
	public WorkflowImpl(final String type, final String name) {
		this.type = type;
		this.name = name;
	}
	
	/**
	 * @return the work flow type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * @return the work flow name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @param state the state name
	 * @param bean the state bean
	 */
	public void add(final String state, final Bean<?> bean) {
		
		if (this.stateBeans.containsKey(state)) {
			this.log.error("State [{}] in work flow [{}] already exist, just skip", state, this.name);
		} else {
			this.stateBeans.put(state, bean);
		}
	}
	
	/**
	 * @param beanManager the bean manager
	 * @param state the state
	 * @param step the step
	 * @param id the id
	 * @return the model
	 * @throws WorkflowException if fail to process work flow 
	 */
	public Model process(
			final BeanManager beanManager, final String state, final String step, final String id
	) throws WorkflowException {
		
		
		return null;
	}
}
