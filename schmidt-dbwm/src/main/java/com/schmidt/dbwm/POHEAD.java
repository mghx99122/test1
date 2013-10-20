/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.dbwm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * 
 * 采购单头部Purchase Order Head
 * @author Danny Chen
 * @version $Id$
 * @since 1.0
 */
@Entity
@Table(name = "POHEAD", uniqueConstraints = {

        @UniqueConstraint(
        				  name = "UN_POSHNO",
                          columnNames = { "POSHNO" }

        )
}) 

public class POHEAD {
	
	//ID
	private Long POHDID;
	
	//采购单号
	private String POSHNO;
	
	//采购日期
	private Date POSHDT;
	
	//备注
	private String PODESC;
	
	//页面上显示日期
	private String POSHDT1;
	
	private DateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

	
    /**
	 * @return the pOHDID
	 */
	@Id
	@Column(name = "POHDID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getPOHDID() {
		return POHDID;
	}

	
	/**
	 * @param pOHDID the pOHDID to set
	 */
	public void setPOHDID(Long pOHDID) {
		POHDID = pOHDID;
	}

	
	/**
	 * @return the pOSHNO
	 */
	@Column(name = "POSHNO",length=32,nullable=false)
	public String getPOSHNO() {
		return POSHNO;
	}

	
	/**
	 * @param pOSHNO the pOSHNO to set
	 */
	public void setPOSHNO(String pOSHNO) {
		POSHNO = pOSHNO;
	}

	
	/**
	 * @return the pOSHDT
	 */
	@Column(name = "POSHDT")
	@Temporal(TemporalType.TIMESTAMP) 
	public Date getPOSHDT() {
		return POSHDT;
	}

	
	/**
	 * @param pOSHDT the pOSHDT to set
	 */
	public void setPOSHDT(Date pOSHDT) {
		POSHDT = pOSHDT;
	}

	
	/**
	 * @return the pODESC
	 */
	@Column(name = "PODESC",length=1024)
	public String getPODESC() {
		return PODESC;
	}

	
	/**
	 * @param pODESC the pODESC to set
	 */
	public void setPODESC(String pODESC) {
		PODESC = pODESC;
	}
	
	public String getPOSHDT1() {
		if (this.POSHDT != null) {
			POSHDT1 = sdf.format(POSHDT);
		}
		return POSHDT1;
	}


	public void setPOSHDT1(String pOSHDT1) {
		POSHDT1 = pOSHDT1;
	}

}
