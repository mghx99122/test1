/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.context;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.spi.Context;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;

/**
 * the components is used to resolve component from CDI
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0, 2013��9��19��
 */
public final class Components {

	/**
	 * the utility class constructor
	 */
	protected Components() {
		
		// do nothing
	}
	
	/**
	 * get a component instance from context container by class type
	 * 
	 * @param <T> the component type
	 * @param type the class of component type
	 * @return the component instance or <code>null</code> not exist
	 */
	public static <T> T get(final Class<T> type) {
		return CDI.current().select(type).get();
	}

	/**
	 * @param beanManager the bean manager
	 * @param bean the bean
	 * @return the object
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object get(final BeanManager beanManager, final Bean<?> bean) {
		
		Context context = beanManager.getContext(bean.getScope());
		Object obj = context.get(bean);
		if (obj == null) {
			CreationalContext creationalContext = beanManager.createCreationalContext(bean);
			obj = context.get(bean, creationalContext);
		}
		return obj;
	}
	
	/**
	 * @param bean the bean
	 * @return the object
	 */
	public static Object get(final Bean<?> bean) {
		return Components.get(CDI.current().getBeanManager(), bean);
	}

	/**
	 * get a component instance by component name that is named by Named annotation
	 * 
	 * @param name the name
	 * @return the component instance or <code>null</code> if not exist
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object get(final String name) {
		
		BeanManager beanManager = CDI.current().getBeanManager();
		Set<Bean<?>> beans = beanManager.getBeans(name);
		if (beans.isEmpty()) {
			return null;
		}
		
		Bean<?> bean = beanManager.resolve(beans);
		Context context = beanManager.getContext(bean.getScope());
		
		Object obj = context.get(bean);
		if (obj == null) {
			CreationalContext creationalContext = beanManager.createCreationalContext(bean);
			obj = context.get(bean, creationalContext);
		}
		return obj;
	}

	/**
	 * iterate all component instance from CDI container by class type type
	 * 
	 * @param <T> component type
	 * @param type the class of component type 
	 * @return the iterator of component instances
	 */
	public static <T> Iterable<T> iterate(final Class<T> type) {
		return CDI.current().select(type);
	}

	/**
	 * list all component instance from CDI container by class type type
	 * 
	 * @param <T> component type
	 * @param type the class of component type 
	 * @return the list of component instances
	 */
	public static <T> List<T> list(final Class<T> type) {
	
		List<T> objs = new ArrayList<T>();
		for (T obj : iterate(type)) {
			objs.add(obj);
		}
		return objs;
	}
}
