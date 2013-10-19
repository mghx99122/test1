/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.template;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import com.schmidt.himalia.context.Components;
import com.schmidt.himalia.logging.Log;
import com.schmidt.himalia.logging.LogFactory;

/**
 * this component will cache all template engines, other component can request template engine by name from it
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
@ApplicationScoped
public class TemplateEngines {
	
	/**
	 * the logger
	 */
	private Log log = LogFactory.getLog(TemplateEngines.class);

	/**
	 * all registered template engines
	 */
	private Map<String, TemplateEngine> templateEngines = new HashMap<String, TemplateEngine>(); 
	
	/**
	 * Find all registered template engines
	 */
	@PostConstruct public void init() {
		
		for (TemplateEngine engine : Components.iterate(TemplateEngine.class)) {
			this.log.info("Find registered template engine [{}, {}]", 
					engine.getName(), engine.getRemark()
			);
			this.templateEngines.put(engine.getName(), engine);
		}
	}
	
	/**
	 * @param name the template engine name
	 * @return the template engine or <code>null</code> if not exist
	 */
	public TemplateEngine get(final String name) {
		return this.templateEngines.get(name);
	}
	
	/**
	 * @return how many cached template engines
	 */
	public int size() {
		return this.templateEngines.size();
	}

	/**
	 * @return all cached template engines
	 */
	public Collection<TemplateEngine> list() {
		return this.templateEngines.values();
	}
}
