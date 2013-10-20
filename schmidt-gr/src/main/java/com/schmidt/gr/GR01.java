/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.gr;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityTransaction;
import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.schmidt.dbwm.HPOHEAD;
import com.schmidt.dbwm.HPOLINE;
import com.schmidt.dbwm.POHEAD;
import com.schmidt.dbwm.POLINE;
import com.schmidt.himalia.restful.Render;
import com.schmidt.himalia.restful.Renders;

/**
 * 
 *
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
@Path("/")
@RequestScoped
public class GR01 {
	
	@Inject private HPOHEAD poHeadDao;
	
	@Inject private HPOLINE poLineDao;
	
	private List<POHEAD> poheads = new ArrayList<POHEAD>();
	
	private GR01Query query;
	
	@GET
	@Path("/gr01c")
	@Renders(value = { 
			@Render(id = "SUCCESS", template = "wm/freemarker/WM01.ftl"),
	})
	public String create() { 
		
		EntityTransaction ts = poHeadDao.getEntityManager().getTransaction();
		ts.begin();
		POHEAD pohead = new POHEAD();
		pohead.setPOSHNO("PO-20131017");
		pohead.setPOSHDT(new Date());
		pohead.setPODESC("测试");
		poHeadDao.create(pohead);

		POLINE poline = new POLINE();
		poline.setPOHDNO("PO-20131017");
		poline.setCUSTNO("CU-SO201310");
		poline.setPOBHNO("BT-20132123-1");
		poline.setPOLNNO(1);
		poline.setPOLNDS("测试");
		poline.setPOLNUN("米");
		poline.setPOMMDS("测试");
		poline.setPRICE(100.326);
		poline.setQUINTY(50.2);
		poline.setPOMMNA("PC平板电脑");
		poline.setPORFNA("PC平板电脑");
		poLineDao.create(poline);
		ts.commit();
		return "SUCCESS";
	}
	
	@GET
	@Path("/gr01l")
	@Renders(value = { 
			@Render(id = "LIST", template = "gr/freemarker/GR01l.ftl"),
	})
	public String list() {
		Map<String,Object> propertiesMap = new HashMap<String,Object>();
		poheads = poHeadDao.list(POHEAD.class, propertiesMap);
		return "LIST";
	}
	
	@POST
	@Path("/gr01q")
	@Renders(value = { 
			@Render(id = "LIST", template = "gr/freemarker/GR01l.ftl"),
	})
	public String query(@BeanParam GR01Query query) {
		Map<String,Object> propertiesMap = new HashMap<String,Object>();
		
		if (query.getPOSHNO() != null) {
			propertiesMap.put("POSHNO", query.getPOSHNO());
		}
		poheads = poHeadDao.list(POHEAD.class, propertiesMap);
		this.query = query;
		return "LIST";
	}
	
	public List<POHEAD> getPoheads() {
		return poheads;
	}

	public void setPoheads(List<POHEAD> poheads) {
		this.poheads = poheads;
	}
	
	public GR01Query getQuery() {
		return query;
	}

	public void setQuery(GR01Query query) {
		this.query = query;
	}
}
