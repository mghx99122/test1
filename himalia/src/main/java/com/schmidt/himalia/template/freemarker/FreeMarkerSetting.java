/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.himalia.template.freemarker;

import com.schmidt.himalia.context.Configuration;

/**
 * This class is used to read FreeMarker configuration from properties file or JNDI
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
public class FreeMarkerSetting extends Configuration {

	/**
	 * Construct FreeMarker configuration
	 */
	public FreeMarkerSetting() {
		super("/freemarker.properties", "java:comp/env/schmidt/FreeMarker/");
	}

	/**
	 * @return the max strong cache size in order to cache compiled FreeMarker template
	 */
	public int getStrongCacheSize() {
		return this.getInteger("strongCacheSize", 64);
	}
	
	/**
	 * @return the max soft cache size in order to cache compiled FreeMarker template
	 */
	public int getSoftCacheSize() {
		return this.getInteger("softCacheSize", 1024);
	}
	
	/**
	 * @return the default encoding for FreeMarker template
	 */
	public String getDefaultEncoding() {
		return this.getString("defaultEncoding", "UTF-8");
	}
	
	/**
	 * @return the language of local for FreeMarker template
	 */
	public String getLocalLanguage() {
		return this.getString("localLanguage", "en");
	}

	/**
	 * @return the country of local for FreeMarker template
	 */
	public String getLocalCountry() {
		return this.getString("localCountry", "US");
	}
	
	/**
	 * @return whether look up localized FreeMarker template
	 */
	public boolean isLocalizedLookup() {
		return this.getBoolean("localizedLookup", false);
	}
	
	/**
	 * @return seconds that elapse before checking whether there is newer version of template
	 */
	public int getTemplateUpdateDelay() {
		return this.getInteger("templateUpdateDelay", 180);
	}
	
	/**
	 * @return whether the FTL parser will try to remove superfluous white-space around certain FTL tags
	 */
	public boolean isWhitespaceStripping() {
		return this.getBoolean("whitespaceStripping", true);
	}
}
