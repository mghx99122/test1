/**
 * Copyright (c) 2013 Schmidt & Co., (China) Limited. All rights reserved.
 */
package com.schmidt.dbwm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 
 *
 * @author Ji Chen
 * @version $Id$
 * @since 1.0
 */
@Entity
@Table(name = "POLINE", uniqueConstraints = {

        @UniqueConstraint(
        				  name = "UN_POHDNO_POLNNO",
                          columnNames = { "POHDNO","POLNNO" }

        )
}) 
public class POLINE {
	
	private Long POLNID;
	
	private String POHDNO;
	
	private Integer POLNNO;
	
	private String POBHNO;
	
	private String POMMNA;
	
	private String POMMDS;
	
	private String PORFNA;
	
	private String CUSTNO;
	
	private Double PRICE;
	
	private Double QUINTY;
	
	private String POLNUN;
	
	private String POLNDS;

	
	/**
	 * @return the pOLNID
	 */
	@Id
	@Column(name = "POLNID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getPOLNID() {
		return POLNID;
	}

	
	/**
	 * @param pOLNID the pOLNID to set
	 */
	public void setPOLNID(Long pOLNID) {
		POLNID = pOLNID;
	}

	
	/**
	 * @return the pOHDNO
	 */
	@Column(name = "POHDNO",length=32, nullable=false)
	public String getPOHDNO() {
		return POHDNO;
	}

	
	/**
	 * @param pOHDNO the pOHDNO to set
	 */
	public void setPOHDNO(String pOHDNO) {
		POHDNO = pOHDNO;
	}

	
	/**
	 * @return the pOLNNO
	 */
	@Column(name = "POLNNO", nullable=false)
	public Integer getPOLNNO() {
		return POLNNO;
	}

	
	/**
	 * @param pOLNNO the pOLNNO to set
	 */
	public void setPOLNNO(Integer pOLNNO) {
		POLNNO = pOLNNO;
	}

	
	/**
	 * @return the pOBHNO
	 */
	@Column(name = "POBHNO",length=32, nullable=false)
	public String getPOBHNO() {
		return POBHNO;
	}

	
	/**
	 * @param pOBHNO the pOBHNO to set
	 */
	public void setPOBHNO(String pOBHNO) {
		POBHNO = pOBHNO;
	}

	
	/**
	 * @return the pOMMNA
	 */
	@Column(name = "POMMNA",length=32, nullable=false)
	public String getPOMMNA() {
		return POMMNA;
	}

	
	/**
	 * @param pOMMNA the pOMMNA to set
	 */
	public void setPOMMNA(String pOMMNA) {
		POMMNA = pOMMNA;
	}

	
	/**
	 * @return the pOMMDS
	 */
	@Column(name = "POMMDS",length=100)
	public String getPOMMDS() {
		return POMMDS;
	}

	
	/**
	 * @param pOMMDS the pOMMDS to set
	 */
	public void setPOMMDS(String pOMMDS) {
		POMMDS = pOMMDS;
	}

	
	/**
	 * @return the pORFNA
	 */
	@Column(name = "PORFNA",length=32)
	public String getPORFNA() {
		return PORFNA;
	}

	
	/**
	 * @param pORFNA the pORFNA to set
	 */
	public void setPORFNA(String pORFNA) {
		PORFNA = pORFNA;
	}

	
	/**
	 * @return the cUSTNO
	 */
	@Column(name = "CUSTNO",length=32,nullable=false)
	public String getCUSTNO() {
		return CUSTNO;
	}

	
	/**
	 * @param cUSTNO the cUSTNO to set
	 */
	public void setCUSTNO(String cUSTNO) {
		CUSTNO = cUSTNO;
	}

	
	/**
	 * @return the pRICE
	 */
	@Column(name = "PRICE",precision=5,scale=2,nullable=false)
	public Double getPRICE() {
		return PRICE;
	}

	
	/**
	 * @param pRICE the pRICE to set
	 */
	public void setPRICE(Double pRICE) {
		PRICE = pRICE;
	}

	
	/**
	 * @return the qUINTY
	 */
	@Column(name = "QUINTY",precision=5,scale=2,nullable=false)
	public Double getQUINTY() {
		return QUINTY;
	}

	
	/**
	 * @param qUINTY the qUINTY to set
	 */
	public void setQUINTY(Double qUINTY) {
		QUINTY = qUINTY;
	}

	
	/**
	 * @return the pOLNUN
	 */
	@Column(name = "POLNUN",length=32,nullable=false)
	public String getPOLNUN() {
		return POLNUN;
	}

	
	/**
	 * @param pOLNUN the pOLNUN to set
	 */
	public void setPOLNUN(String pOLNUN) {
		POLNUN = pOLNUN;
	}

	
	/**
	 * @return the pOLNDS
	 */
	@Column(name = "POLNDS",length=1024,nullable=false)
	public String getPOLNDS() {
		return POLNDS;
	}

	
	/**
	 * @param pOLNDS the pOLNDS to set
	 */
	public void setPOLNDS(String pOLNDS) {
		POLNDS = pOLNDS;
	}
	
}
