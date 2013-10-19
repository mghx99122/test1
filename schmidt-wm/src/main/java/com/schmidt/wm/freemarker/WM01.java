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
import com.schmidt.wm.data.BinType;

/**
 * 
 *
 * @author LU HI YU
 * @version $Id$
 * @since 1.0
 */
@Path("/")
@RequestScoped
public class WM01 {

	private String typeCode;
	
	private String typeDescription;
	
	private boolean saved;
	
	private boolean firstin;
	
	private List<BinType> binTypes = new ArrayList<BinType>();
	
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}
	
	public void setSaved(boolean saved) {
		this.saved = saved;
	}
	/**
	 * @return the typeCode
	 */
	public String getTypeCode() {
		return this.typeCode;
	}
	
	public String getTypeDescription() {
		return this.typeDescription;
	}
	
	public boolean getSaved() {
		return this.saved;
	}
	
	public boolean getFirstin() {
		return this.firstin;
	}
	
	
	/**
	 * @return the binTypes
	 */
	public List<BinType> getBinTypes() {
		return binTypes;
	}

	@Inject
	HttpServletRequest request;
	
	/**
	 * @return the result
	 */
	@GET
	@Path("/wm01")
	@Renders(value = { 
			@Render(id = "wm01", template = "wm/freemarker/WM01.ftl"),
	})
	public String wm01Edit() {
		this.setTypeCode("");
		this.setTypeDescription("");
		String sid = this.request.getParameter("id");
		if (sid != null) {
			this.setTypeCode("BinTypeCode" + sid);
			this.setTypeDescription("description" + sid);
		}
		this.setSaved(false);
		this.firstin = true;
		return "wm01";
	}
	
	@POST
	@Path("/wm01")
	@Renders(value = { 
			@Render(id = "wm01", template = "wm/freemarker/WM01.ftl"),
	})
	public String wm01Save(@FormParam("typeCode") String typeCode,
			@FormParam("typeDescription") String typeDescription) {
		this.request.getParameterMap();
		this.setTypeCode(typeCode);
		this.setTypeDescription(typeDescription);
		this.setSaved(false);
		if (typeCode == null || !typeCode.equals("")) { 
			this.setSaved(true);
		}
		this.firstin = false;
		return "wm01";
	}
	
	@GET
	@Path("/wm01l")
	@Renders(value = { 
			@Render(id = "wm01l", template = "wm/freemarker/WM01l.ftl"),
	})
	public String listBinTypes() {
		this.findBinTypes();
		return "wm01l";
	}
	
	private void findBinTypes() {
		for (int i = 1; i < 21 ; i++) {
			BinType binType = new BinType();
			binType.setId(i);
			binType.setBinTypeCode("BinTypeCode" + i);
			binType.setBinTypeDescription("description" + i);
			this.binTypes.add(binType);
		}
	}
	
}
