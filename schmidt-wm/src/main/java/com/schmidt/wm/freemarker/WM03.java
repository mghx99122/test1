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
import com.schmidt.wm.data.Bin;

/**
 * 
 *
 * @author LU HI YU
 * @version $Id$
 * @since 1.0
 */
@Path("/")
@RequestScoped
public class WM03 {
	
	private String binCode;
	
	private String sectionCode;
	
	private String typeCode;
	
	private String state;
	
	private String line;
	
	private String row;
	
	private String column;
	
	private Float length;
	
	private Float width;
	
	private Float height;
	
	private Float weight;
	
	private String description;
	
	private List<Bin> bins = new ArrayList<Bin>();
	
	private List<String> binSections = new ArrayList<String>();
	
	private List<String> binTypes = new ArrayList<String>();
	
	private List<String> states = new ArrayList<String>();
	
	/**
	 * @return the binCode
	 */
	public String getBinCode() {
		return binCode;
	}

	
	/**
	 * @param binCode the binCode to set
	 */
	public void setBinCode(String binCode) {
		this.binCode = binCode;
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
	 * @return the typeCode
	 */
	public String getTypeCode() {
		return typeCode;
	}

	
	/**
	 * @param typeCode the typeCode to set
	 */
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	
	/**
	 * @return the line
	 */
	public String getLine() {
		return line;
	}

	
	/**
	 * @param line the line to set
	 */
	public void setLine(String line) {
		this.line = line;
	}

	
	/**
	 * @return the row
	 */
	public String getRow() {
		return row;
	}

	
	/**
	 * @param row the row to set
	 */
	public void setRow(String row) {
		this.row = row;
	}

	
	/**
	 * @return the column
	 */
	public String getColumn() {
		return column;
	}

	
	/**
	 * @param column the column to set
	 */
	public void setColumn(String column) {
		this.column = column;
	}

	
	/**
	 * @return the length
	 */
	public Float getLength() {
		return length;
	}

	
	/**
	 * @param length the length to set
	 */
	public void setLength(Float length) {
		this.length = length;
	}

	
	/**
	 * @return the width
	 */
	public Float getWidth() {
		return width;
	}

	
	/**
	 * @param width the width to set
	 */
	public void setWidth(Float width) {
		this.width = width;
	}

	
	/**
	 * @return the height
	 */
	public Float getHeight() {
		return height;
	}

	
	/**
	 * @param height the height to set
	 */
	public void setHeight(Float height) {
		this.height = height;
	}

	
	/**
	 * @return the weight
	 */
	public Float getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Float weight) {
		this.weight = weight;
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
	 * @return the bins
	 */
	public List<Bin> getBins() {
		return bins;
	}


	
	/**
	 * @return the binSections
	 */
	public List<String> getBinSections() {
		return binSections;
	}


	
	/**
	 * @return the binTypes
	 */
	public List<String> getBinTypes() {
		return binTypes;
	}


	/**
	 * @return the states
	 */
	public List<String> getStates() {
		return states;
	}

	@Inject
	HttpServletRequest request;

	@GET
	@Path("/wm03")
	@Renders(value = { 
			@Render(id = "wm03", template = "wm/freemarker/WM03.ftl"),
	})
	public String editBin() {
		findBinSections();
		findBinTypes();
		findStates();
		this.setBinCode("");
		this.setSectionCode("");
		this.setTypeCode("");
		this.setState("E");
		this.setLine("");
		this.setRow("");
		this.setColumn("");
		this.setLength(new Float(0.0));
		this.setWidth(new Float(0.0));
		this.setHeight(new Float(0.0));
		this.setWeight(new Float(0.0));
		this.setDescription("");
		if (this.request.getParameter("id") != null) {
			String inId = this.request.getParameter("id");
			this.setBinCode("BIN" + inId);
			this.setSectionCode("Section 1");
			this.setTypeCode("Type 2");
			this.setLine("L " + inId);
			this.setRow("R " + inId);
			this.setColumn("C " + inId);
			this.setLength(new Float(1));
			this.setWidth(new Float(0.5));
			this.setHeight(new Float(0.6));
			this.setWeight(new Float(2));
			this.setState("E");
			this.setDescription("Des");
		}
		return "wm03";
	}
	
	@POST
	@Path("/wm03")
	@Renders(value = { 
			@Render(id = "wm03", template = "wm/freemarker/WM03.ftl"),
	})
	public String saveBin(@FormParam("binCode") String binCode) {
		findBinSections();
		findBinTypes();
		findStates();
		
		this.setBinCode(binCode);
		this.setSectionCode(this.request.getParameter("sectionCode"));
		this.setTypeCode(this.request.getParameter("typeCode"));
		this.setState(this.request.getParameter("state"));
		this.setLine(this.request.getParameter("line"));
		this.setRow(this.request.getParameter("row"));
		this.setColumn(this.request.getParameter("column"));
		this.setLength(new Float(this.request.getParameter("length")));
		this.setWidth(new Float(this.request.getParameter("width")));
		this.setHeight(new Float(this.request.getParameter("height")));
		this.setWeight(new Float(this.request.getParameter("weight")));
		this.setDescription(this.request.getParameter("description"));
		
		return "wm03";
	}
	
	@GET
	@Path("/wm03l")
	@Renders(value = { 
			@Render(id = "wm03l", template = "wm/freemarker/WM03l.ftl"),
	})
	public String listBins() {
		findBins();
		return "wm03l";
	}
	
	private void findBins() {
		for (int i = 1; i < 21; i++) {
			Bin bin = new Bin();
			bin.setId(i);
			bin.setBinCode("BIN" + i);
			bin.setSectionCode("Section 1");
			bin.setTypeCode("Type 2");
			bin.setLine("L " + i);
			bin.setRow("R " + i);
			bin.setColumn("C " + i);
			bin.setLength(new Float(1));
			bin.setWidth(new Float(0.5));
			bin.setHeight(new Float(0.6));
			bin.setWeight(new Float(2));
			bin.setState("E");
			bin.setDescription("Des");
			this.bins.add(bin);
		}
	} 
	
	private void findBinSections() {
		for(int i = 1; i < 6; i++) {
			this.binSections.add("Section " + i);
		}
	}
	
	private void findBinTypes() {
		for(int i = 1; i < 6; i++) {
			this.binTypes.add("Type " + i);
		}
	}
	
	private void findStates() {
		this.states.add("N");
		this.states.add("E");
		this.states.add("B");
	}

}
