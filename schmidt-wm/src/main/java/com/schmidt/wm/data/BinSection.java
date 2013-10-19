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
public class BinSection {

	private Integer id;
	
	private String sectionCode;
	
	private String wareHouseCode;
	
	private String description;

	
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
	 * @return the sectionCode
	 */
	public String getSectionCode() {
		return sectionCode;
	}

	
	/**
	 * @param sectionCode the sectionCode to set
	 */
	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	
	/**
	 * @return the wareHouseCode
	 */
	public String getWareHouseCode() {
		return wareHouseCode;
	}

	
	/**
	 * @param wareHouseCode the wareHouseCode to set
	 */
	public void setWareHouseCode(String wareHouseCode) {
		this.wareHouseCode = wareHouseCode;
	}

	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
