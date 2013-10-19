/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.dn.freemarker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.schmidt.himalia.restful.Render;
import com.schmidt.himalia.restful.Renders;

/**
 * 
 *
 * @author LU HI YU
 * @version $Id$
 * @since 1.0
 */
@Path("/")
@RequestScoped
public class DN01 {
	
	private String deliveryNo;
	
	public String getDeliveryNo() {
		return this.deliveryNo;
	}
	
	@GET
	@Path("/dn01")
	@Renders(value = { 
			@Render(id = "dn01", template = "dn/freemarker/DN01.ftl"),
	})
	public String dn01() {
		this.deliveryNo = new SimpleDateFormat("YYYYMMddHHmmss").format(Calendar.getInstance().getTime());
		return "dn01";
	}
}
