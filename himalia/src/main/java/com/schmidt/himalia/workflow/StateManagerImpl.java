/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.workflow;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

/**
 * the implementation of state manager
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
@ApplicationScoped
public class StateManagerImpl implements StateManager {

	/**
	 * the bean manager
	 */
	@Inject private BeanManager beanManager;
	
	/**
	 * all defined states
	 */
	private Map<String, Map<String, Bean<?>>> stateBeans = new HashMap<String, Map<String, Bean<?>>>();
	
	/**
	 * initial state manager 
	 */
	@PostConstruct public void init() {
		
		for (Bean<?> bean : this.beanManager.getBeans(State.class)) {
			
			Provider provider = this.getProvider(bean);
			if (provider != null) {
				if (!this.stateBeans.containsKey(provider.type())) {
					this.stateBeans.put(provider.type(), new HashMap<String, Bean<?>>());
				}
				this.stateBeans.get(provider.type()).put(provider.id(), bean);
			}
		}
	}
	
	/**
	 * find Provider annotation from a state bean
	 * 
	 * @param bean the state bean
	 * @return the Provider or <code>null</code> if state does not annotated by Provider
	 */
	private Provider getProvider(final Bean<?> bean) {
		return bean.getBeanClass().getAnnotation(Provider.class);
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.workflow.StateManager#getStateBean(java.lang.String, java.lang.String)
	 */
	public Bean<?> getStateBean(final String type, final String name) {
		
		Map<String, Bean<?>> beans = this.stateBeans.get(type);
		return (beans == null) ? null : beans.get(name);
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.workflow.StateManager#getType(javax.enterprise.inject.spi.Bean)
	 */
	@Override
	public String getType(final Bean<?> bean) {
		
		Provider provider = this.getProvider(bean);
		return provider == null ? null : provider.type();
	}
}
