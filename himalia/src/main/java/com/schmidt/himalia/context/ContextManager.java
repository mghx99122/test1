/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.context;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.spi.Context;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;

/**
 * the context manager gets component instance in a scope
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
@RequestScoped
public class ContextManager {

	/**
	 * the current CDI
	 */
	private CDI<Object> currentCDI;
	
	/**
	 * the bean manager
	 */
	private BeanManager beanManager;
	
	/**
	 * @return the current CDI
	 */
	private CDI<Object> getCurrentCDI() {
		
		if (this.currentCDI == null) {
			this.currentCDI = CDI.current();
		}
		return this.currentCDI;
	}
	
	/**
	 * @return the bean manager
	 */
	private BeanManager getBeanManager() {
		
		if (this.beanManager == null) {
			this.beanManager = this.getCurrentCDI().getBeanManager();
		}
		return this.beanManager;
	}
	
	/**
	 * get a component instance from context container by class type
	 * 
	 * @param <T> the component type
	 * @param type the class of component type
	 * @return the component instance or <code>null</code> not exist
	 */
	public <T> T get(final Class<T> type) {
		return this.getCurrentCDI().select(type).get();
	}
	
	/**
	 * get a component instance by component name that is named by Named annotation
	 * 
	 * @param name the name
	 * @return the component instance or <code>null</code> if not exist
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object get(final String name) {
		
		Set<Bean<?>> beans = this.getBeanManager().getBeans(name);
		if (beans.isEmpty()) {
			return null;
		}
		
		Bean<?> bean = this.getBeanManager().resolve(beans);
		Context context = this.getBeanManager().getContext(bean.getScope());
		
		Object obj = context.get(bean);
		if (obj == null) {
			CreationalContext creationalContext = this.getBeanManager().createCreationalContext(bean);
			obj = context.get(bean, creationalContext);
		}
		return obj;
	}
	
	public <T> T get(final Class<T> type, final String name) {
		
		Set<Bean<?>> beans = this.getBeanManager().getBeans(type);
		for (Bean<?> bean : beans) {
			if (bean.getName() != null) {
				
			}
		}
		// TODO: XXX
		return null;
	}
	
	/**
	 * iterate all component instance from CDI container by class type type
	 * 
	 * @param <T> component type
	 * @param type the class of component type 
	 * @return the iterator of component instances
	 */
	public <T> Iterable<T> iterate(final Class<T> type) {
		return this.getCurrentCDI().select(type);
	}

	/**
	 * list all component instance from CDI container by class type type
	 * 
	 * @param <T> component type
	 * @param type the class of component type 
	 * @return the list of component instances
	 */
	public <T> List<T> list(final Class<T> type) {
	
		List<T> objs = new ArrayList<T>();
		for (T obj : this.iterate(type)) {
			objs.add(obj);
		}
		return objs;
	}
}
