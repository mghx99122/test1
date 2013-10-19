/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.template.freemarker;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.schmidt.himalia.logging.Log;
import com.schmidt.himalia.logging.LogFactory;
import com.schmidt.himalia.template.TemplateEngine;
import com.schmidt.himalia.template.Template;

import freemarker.cache.MruCacheStorage;
import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * Template engine that is enable to compile FreeMarker source code into compiled template 
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
@ApplicationScoped
@Named("ftl")
public class FreeMarkerEngine implements TemplateEngine {

	/**
	 * the logger
	 */
	private Log log = LogFactory.getLog(FreeMarkerEngine.class);
	
	/**
	 * the FreeMaker template configuration
	 */
	private Configuration configuration = new Configuration();

	/**
	 * initial FreeMaker configuration
	 */
	@PostConstruct public void init() {

		// create FreeMarker setting to load setting from properties file or JNDI
		try {
			freemarker.log.Logger.selectLoggerLibrary(freemarker.log.Logger.LIBRARY_SLF4J);
		} catch (Exception e) {
			this.log.error("Fail to set FreeMarker logger kit to SLF4j", e);
		}
		FreeMarkerSetting setting = new FreeMarkerSetting();
		
		// Configure FreeMaker template settings
		configuration.setObjectWrapper(new DefaultObjectWrapper());
		configuration.setTemplateLoader(new FreeMarkerTemplateLoader());
		configuration.setCacheStorage(
				new MruCacheStorage(setting.getStrongCacheSize(), setting.getSoftCacheSize())
		);

		// set default encoding and locale to FreeMaker engine
		configuration.setDefaultEncoding(setting.getDefaultEncoding());
		configuration.setLocale(
				new Locale(setting.getLocalLanguage(), setting.getLocalCountry())
		);
		configuration.setLocalizedLookup(setting.isLocalizedLookup());

		// set template new version checking and white space strip
		configuration.setTemplateUpdateDelay(setting.getTemplateUpdateDelay());
		configuration.setWhitespaceStripping(setting.isWhitespaceStripping());

		// add template exception handler to display error on page
		configuration.setTemplateExceptionHandler(new TemplateExceptionHandler() {
			
			public void handleTemplateException(
					final TemplateException e, final Environment env, final Writer out
			) throws TemplateException {

				try {
					out.write(
							"<div style=\"color: red; font-weight: bolder\">[ERROR: " + e.getMessage() + "]</div>"
					);
				} catch (IOException ioe) {
					throw new TemplateException("Failed to print error message. Cause: " + ioe, env);
				}
			}
		});
	}
	
	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.template.TemplateEngine#getName()
	 */
	public String getName() {
		return "ftl";
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.template.TemplateEngine#getRemark()
	 */
	public String getRemark() {
		return "FreeMarker";
	}

	/**
	 * {@inheritDoc}
	 * @see com.schmidt.himalia.template.TemplateEngine#compile(java.lang.String)
	 */
	public Template compile(final String source) throws IOException {
		return new FreeMarkerTemplate(source, this.configuration.getTemplate(source));
	}
}
