/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.restful;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

/**
 * The template provider is used to process template with string and template engine to output content 
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
@Provider
// TODO: how to support mime type by template engine
// TODO: how to find resource object to invoke Path method
public class ModelTemplateWriter extends AbstractTemplateWriter<Model> {

	/**
	 * {@inheritDoc}
	 * @see javax.ws.rs.ext.MessageBodyWriter#isWriteable(java.lang.Class, java.lang.reflect.Type, 
	 * 	java.lang.annotation.Annotation[], javax.ws.rs.core.MediaType
	 * )
	 */
	public boolean isWriteable(final Class<?> type, final Type genericType, final Annotation[] annotations, 
			final MediaType mediaType
	) {
		return Model.class.isAssignableFrom(type);
	}

	/**
	 * {@inheritDoc}
	 * @see javax.ws.rs.ext.MessageBodyWriter#writeTo(java.lang.Object, java.lang.Class, java.lang.reflect.Type, 
	 * 	java.lang.annotation.Annotation[], javax.ws.rs.core.MediaType, javax.ws.rs.core.MultivaluedMap, 
	 * 	java.io.OutputStream
	 * )
	 */
	public void writeTo(final Model model, final Class<?> type, final Type genericType, 
			final Annotation[] annotations, final MediaType mediaType, 
			final MultivaluedMap<String, Object> headers, final OutputStream out) throws IOException {
		
		this.writeTo(model, annotations, out);
	}
}
