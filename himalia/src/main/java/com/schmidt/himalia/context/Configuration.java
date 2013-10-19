/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.schmidt.himalia.logging.Log;
import com.schmidt.himalia.logging.LogFactory;

/**
 * The configuration is used to read configuration for application. It can read from JNDI or properties file
 * in class path.
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
public class Configuration {

	/**
	 * the logger
	 */
	private Log log = LogFactory.getLog(Configuration.class);
	
	/**
	 * the loaded properties
	 */
	private Properties properties = new Properties();
	
	/**
	 * the JNDI base name1
	 */
	private String baseName;
	
	/**
	 * @param resource the resource name to load property file 
	 * @param baseName the base JNDI name
	 */
	protected Configuration(final String resource, final String baseName) {
		
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(resource);
		if (in != null) {
			try {
				this.properties.load(in);
			} catch (IOException e) {
				this.log.warn("Fail to load property resource: {}", resource, e);
			} finally {
				
				try {
					in.close();
				} catch (IOException e) {
					this.log.warn("Fail to close opened property resource: {}", resource, e);
				}
			}
		}
		
		this.baseName = baseName;
		for (Object key : this.properties.keySet().toArray()) {
			
			String value = this.lookup(key.toString());
			if (value != null) {
				this.properties.put(key, value);
			}
		}
	}
	
	/**
	 * @return all properties
	 */
	public Properties getProperties() {
		return this.properties;
	}
	
	/**
	 * Get value from JNDI by full name
	 * 
	 * @param name the name
	 * @return the value or <code>null</code> if not find
	 */
	private String lookup(final String name) {
		
		InitialContext context = null;
		try {
			context = new InitialContext();
			return context.lookup(this.baseName + name).toString();
		} catch (NamingException e) {
			this.log.debug("Fail to look up value {} in JNDI", name, e);
		} finally {
			try {
				context.close();
			} catch (NamingException e) {
				this.log.debug("Fail to close open JNDI context {}", name, e);
			}
		}
		
		return null;
	}

	/**
	 * Get string value from JNDI or property file in class path. If can't, use default value 
	 * 
	 * @param name the name
	 * @param defaultValue the default value
	 * @return the value
	 */
	public String getString(final String name, final String defaultValue) {
		
		String value;
		if (this.properties.contains(name)) {
			value = this.properties.getProperty(name);
		} else {
			value = this.lookup(name);
		}
		return value == null ? defaultValue : value;
	}
	
	/**
	 * Get string value from JNDI or property file in class path
	 * 
	 * @param name the name
	 * @return the value
	 */
	public String getString(final String name) {
		return this.getString(name, "");
	}
	
	/**
	 * Get integer value from JNDI or property file in class path. If can't, use default value 
	 * 
	 * @param name the name
	 * @param defaultValue the default value
	 * @return the value
	 */
	public int getInteger(final String name, final int defaultValue) {
		
		String value = this.getString(name, null);
		if (value != null) {
			try {
				return Integer.parseInt(value);
			} catch (Exception e) {
				this.log.warn("Fail to parse name {} of value {} to integer", name, value, e);
			}
		}
		return defaultValue;
	}
	
	/**
	 * Get integer value from JNDI or property file in class path
	 * 
	 * @param name the name
	 * @return the value
	 */
	public int getInteger(final String name) {
		return getInteger(name, 0);
	}

	/**
	 * Get integer value from JNDI or property file in class path. If can't, use default value 
	 * 
	 * @param name the name
	 * @param defaultValue the default value
	 * @return the value
	 */
	public boolean getBoolean(final String name, final boolean defaultValue) {
		
		String value = this.getString(name, null);
		if (value != null) {
			try {
				return Boolean.parseBoolean(value);
			} catch (Exception e) {
				this.log.warn("Fail to parse name {} of value {} to boolean", name, value, e);
			}
		}
		return defaultValue;
	}

	/**
	 * Get float value from JNDI or property file in class path. If can't, use default value 
	 * 
	 * @param name the name
	 * @param defaultValue the default value
	 * @return the value
	 */
	public float getFloat(final String name, final float defaultValue) {
		
		String value = this.getString(name, null);
		if (value != null) {
			try {
				return Float.parseFloat(value);
			} catch (Exception e) {
				this.log.warn("Fail to parse name {} of value {} to float", name, value, e);
			}
		}
		return defaultValue;
	}
}
