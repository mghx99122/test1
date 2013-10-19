/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.wm.freemarker;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.schmidt.himalia.restful.Render;
import com.schmidt.himalia.restful.Renders;
import com.schmidt.wm.data.BinSection;

/**
 * 
 *
 * @author LU HI YU
 * @version $Id$
 * @since 1.0
 */
@Path("/")
@RequestScoped
public class WM02 {
	
	private List<BinSection> binSections = new ArrayList<BinSection>();
	
	private String sectionCode;
	
	private String wareHouseCode;
	
	private String description;

	private List<String> wareHouseCodes = new ArrayList<String>();
	
	@Inject
	HttpServletRequest request;
	
	/**
	 * @return the binSections
	 */
	public List<BinSection> getBinSections() {
		return binSections;
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

	
	/**
	 * @return the wareHouseCodes
	 */
	public List<String> getWareHouseCodes() {
		return wareHouseCodes;
	}
	
	@GET
	@Path("/wm02l")
	@Renders(value = { 
			@Render(id = "wm02l", template = "wm/freemarker/WM02l.ftl"),
	})
	public String listBinSections() {
		this.findBinSections();
		return "wm02l";
	}
	
	@GET
	@Path("/wm02")
	@Renders(value = { 
			@Render(id = "wm02", template = "wm/freemarker/WM02.ftl"),
	})
	public String wm02Edit() {
		this.setSectionCode("");
		this.setWareHouseCode("");
		this.setDescription("");
		this.findWareHouseCodes();
		String sid = this.request.getParameter("id");
		
		if (sid != null) {
			this.setSectionCode("Section Code " + sid);
			this.setWareHouseCode("WHS1");
			this.setDescription("Sample Descripion " + sid);
		}
		return "wm02";
	}
	
	@POST
	@Path("/wm02")
	@Renders(value = { 
			@Render(id = "wm02", template = "wm/freemarker/WM02.ftl"),
	})
	public String wm02Save(@FormParam("sectionCode") String sectionCode, 
			@FormParam("wareHouseCode") String wareHouseCode,
			@FormParam("description") String description) {
		this.setSectionCode(sectionCode);
		this.setWareHouseCode(wareHouseCode);
		this.setDescription(description);
		this.findWareHouseCodes();
		return "wm02";
	}
	
	private void findBinSections() {
		for (int i = 1; i < 21; i++) {
			BinSection binSection = new BinSection();
			binSection.setId(i);
			binSection.setSectionCode("Section Code " + i);
			binSection.setWareHouseCode("WHS1");
			binSection.setDescription("Sample Descripion " + i);
			this.binSections.add(binSection);
		}
	}
	
	private void findWareHouseCodes() {
		for (int i = 1; i < 6; i++) {
			this.wareHouseCodes.add("WHS" + i);
		}
	}
}
