package com.schmidt.gr;

import java.util.Date;

import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;

import com.schmidt.dbwm.common.AbstractQuery;

/**
 * 
 * GR01页面查询
 * @author Ji Chen
 * @version $Id$
 * @since 1.0
 */
public class GR01Query extends AbstractQuery {
	
	@FormParam("POSHNO")
	private String POSHNO;
	
	@FormParam("POSHDT")
	private Date POSHDT;

	public String getPOSHNO() {
		return POSHNO;
	}

	public void setPOSHNO(String pOSHNO) {
		POSHNO = pOSHNO;
	}

	public Date getPOSHDT() {
		return POSHDT;
	}

	public void setPOSHDT(Date pOSHDT) {
		POSHDT = pOSHDT;
	}

}
