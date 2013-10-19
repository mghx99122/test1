/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.gr01;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityTransaction;
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
	
	@Path("create")
	@Renders(value = { 
			@Render(id = "a", template = "gr/freemarker/testa.ftl"),
	})
	//@Transactional
	public String create() { 
		
//		EntityTransaction ts = poHeadDao.getEntityManager().getTransaction();
//		ts.begin();
//		POHEAD pohead = new POHEAD();
//		pohead.setPOSHNO("PO-20131017");
//		pohead.setPOSHDT(new Date());
//		pohead.setPODESC("测试");
//		poHeadDao.create(pohead);
//
//		POLINE poline = new POLINE();
//		poline.setPOHDNO("PO-20131017");
//		poline.setCUSTNO("CU-SO201310");
//		poline.setPOBHNO("BT-20132123-1");
//		poline.setPOLNNO(1);
//		poline.setPOLNDS("测试");
//		poline.setPOLNUN("米");
//		poline.setPOMMDS("测试");
//		poline.setPRICE(100.326);
//		poline.setQUINTY(50.2);
//		poline.setPOMMNA("PC平板电脑");
//		poline.setPORFNA("PC平板电脑");
//		poLineDao.create(poline);
//		ts.commit();
		return "a";
	}
}
