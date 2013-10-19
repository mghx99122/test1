/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.wm.data;

/**
 * 
 *
 * @author LU HI YU
 * @version $Id$
 * @since 1.0
 */
public class BinType {

	public Integer id;
	
	public String binTypeCode;
	
	public String binTypeDescription;

	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return the binTypeCode
	 */
	public String getBinTypeCode() {
		return binTypeCode;
	}

	
	/**
	 * @param binTypeCode the binTypeCode to set
	 */
	public void setBinTypeCode(String binTypeCode) {
		this.binTypeCode = binTypeCode;
	}

	
	/**
	 * @return the binTypeDescription
	 */
	public String getBinTypeDescription() {
		return binTypeDescription;
	}

	
	/**
	 * @param binTypeDescription the binTypeDescription to set
	 */
	public void setBinTypeDescription(String binTypeDescription) {
		this.binTypeDescription = binTypeDescription;
	}
}
