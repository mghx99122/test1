/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.template.freemarker;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

import com.schmidt.himalia.logging.Log;
import com.schmidt.himalia.logging.LogFactory;
import com.schmidt.himalia.template.Template;
import com.schmidt.himalia.template.TemplateException;

/**
 * The compiled FreeMarker template object, use to merge model data to output content
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
public class FreeMarkerTemplate implements Template {

	/**
	 * the logger
	 */
	private Log log = LogFactory.getLog(FreeMarkerTemplate.class);
	
	/**
	 * the template id
	 */
	private String id;
	
	/**
	 * the compiled FreeMarker template
	 */
	private freemarker.template.Template compiledTemplate;

	/**
	 * @param id the template id
	 * @param compiledTemplate the compiled template
	 */
	FreeMarkerTemplate(final String id, final freemarker.template.Template compiledTemplate) {
		this.id = id;
		this.compiledTemplate = compiledTemplate;
	}
	
	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.template.Template#getId()
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.template.Template#process(java.lang.Object, java.util.Map, java.io.OutputStream)
	 */
	public void process(
			final Object value, final Map<String, Object> params, final OutputStream out
	) throws TemplateException {
		
		OutputStreamWriter writer = new OutputStreamWriter(out);
		try {
			
			FreeMarkerModel model = new FreeMarkerModel(value == null ? new Object() : value, params);
			this.compiledTemplate.process(model, writer);
			writer.flush();
		} catch (Exception e) {
			
			this.log.error("Fail to process template {}", this.id, e);
			throw new TemplateException("Fail to process template: " + this.id, e);
		} finally {
			
			try {
				writer.close();
			} catch (Exception e) {
				this.log.error("Fail to close response stream for template {}", this.id, e);
				throw new TemplateException("Fail to close response stream for template: " + this.id, e);
			}
		}
	}
}
