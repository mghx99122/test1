/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.restful;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.MessageBodyWriter;

import com.schmidt.himalia.context.Components;
import com.schmidt.himalia.logging.Log;
import com.schmidt.himalia.logging.LogFactory;
import com.schmidt.himalia.template.Template;
import com.schmidt.himalia.template.TemplateEngine;
import com.schmidt.himalia.template.TemplateEngines;
import com.schmidt.himalia.template.TemplateException;

/**
 * the writer is used to process template with data model to response output
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 * @param <T> the generic type
 */
public abstract class AbstractTemplateWriter<T> implements MessageBodyWriter<T> {

	/**
	 * the log
	 */
	private Log log = LogFactory.getLog(StringTemplateWriter.class);

	/**
	 * the template engines
	 */
	private TemplateEngines templateEngines;
	
	/**
	 * the context of uri info
	 */
	@Context private UriInfo uriInfo;
	
	/**
	 * resolve template engines from CDI container 
	 */
	@PostConstruct void init() {
		this.templateEngines = Components.get(TemplateEngines.class);
	}
	
	/**
	 * {@inheritDoc}
	 * @see javax.ws.rs.ext.MessageBodyWriter#getSize(java.lang.Object, java.lang.Class, java.lang.reflect.Type, 
	 * 	java.lang.annotation.Annotation[], javax.ws.rs.core.MediaType
	 * )
	 */
	public long getSize(
			final T t, final Class<?> type, final Type genericType, final Annotation[] annotations, 
			final MediaType mediaType
	) {
		return -1;
	}

	/**
	 * find <code>Renders</code> annotation instance from a set of annotations in class
	 * 
	 * @param annotations the annotations
	 * @return the <code>Renders</code> annotation or <code>null</code> if not exist
	 */
	protected Renders getAnnotatedRenders(final Annotation[] annotations) {
		
		for (Annotation annotation : annotations) {
			if (annotation instanceof Renders) {
				return (Renders) annotation;
			}
		}
		return null;
	}
	
	/**
	 * find <code>Result</code> annotation that is matched with id from a set of annotations
	 * 
	 * @param id the id
	 * @param annotations the annotations
	 * @return the <code>Result</code> annotation or <code>null</code> if not exist
	 */
	protected Render getMatchedRender(final String id, final Annotation[] annotations) {
		
		for (Render render : this.getAnnotatedRenders(annotations).value()) {
			if (render.id().equals(id)) {
				return render;
			}
		}
		return null;
	}

	/**
	 * @param template the template
	 * @return the template engine according to resource suffix
	 */
	private TemplateEngine getTemplate(final String template) {
		
		int index = template.lastIndexOf('.');
		if (index != -1) {
			return this.templateEngines.get(template.substring(index + 1));
		} else {
			return null;
		}
	}
	
	/**
	 * Write data model to response output by template
	 * 
	 * @param model the data model
	 * @param annotations the annotation
	 * @param out the response output stream
	 * @throws IOException fail if compile template
	 */
	protected void writeTo(
			final Model model, final Annotation[] annotations, final OutputStream out) throws IOException {
		
		String template;
		if (model.getId() != null) {
			
			Render render = this.getMatchedRender(model.getId(), annotations);
			if (render == null) {
				this.log.error("Render with id [{}] is not defined", model.getId());
				throw new WebApplicationException(
						"Render [" + model.getId() + "] is not defined", Response.Status.INTERNAL_SERVER_ERROR
				);
			}
			
			if (render.redirect().length() > 0) {
				HttpServletResponse response = Components.get(HttpServletResponse.class);
				response.sendRedirect(render.redirect());
				return;
			}
			
			template = render.template();
		} else {
			template = model.getTemplate();
		}
		
		TemplateEngine templateEngine = this.getTemplate(template);
		if (templateEngine == null) {
			this.log.error("Template engine for [{}] is not defined", template);
			throw new WebApplicationException(
					"Template engine for [" + template + "] is not defined.", Response.Status.INTERNAL_SERVER_ERROR
			);
		}
		
		Template compiledTemplate = templateEngine.compile(template);
		try {
			if (model.getValue() != null) {
				compiledTemplate.process(model.getValue(), model.getVariables(), out);
			} else {
				compiledTemplate.process(this.uriInfo.getMatchedResources().get(0), model.getVariables(), out);
			}
		} catch (TemplateException e) {
			this.log.error("Fail to process template [{}]", template, e);
			throw new WebApplicationException(
					"Fail to process template [" + model.getId() + "]", e, Response.Status.INTERNAL_SERVER_ERROR
			);
		}
	}
}
