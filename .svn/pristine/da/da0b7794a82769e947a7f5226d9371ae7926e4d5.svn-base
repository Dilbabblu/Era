package com.forsys.revmantra.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.forsys.revmantra.listener.RmanLookupCodesListener;

@Entity
@EntityListeners(RmanLookupCodesListener.class)
@Table(name = "RMAN_LOOKUP_CODES")
//@IdClass(RmanLookupCodesPkId2.class)
public class RmanLookupCodes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ATTRIBUTE3")
	private String attribute3;

	@Column(name = "CREATED_BY")
	private BigDecimal createdBy;

	@Column(name = "ATTRIBUTE2")
	private String attribute2;

	@Column(name = "LAST_UPDATED_BY")
	private BigDecimal lastUpdatedBy;

	@Column(name = "START_DATE_ACTIVE")
	private Timestamp startDateActive;

	@Column(name = "ATTRIBUTE1")
	private String attribute1;

	//@Id
	@Column(name = "LOOKUP_CODE")
	private String lookupCode;

	@Column(name = "CREATION_DATE")
	private Timestamp creationDate;

	@Column(name = "ENABLED_FLAG")
	private String enabledFlag;

	@Column(name = "LAST_UPDATE_DATE")
	private Timestamp lastUpdateDate;

	@Column(name = "ATTRIBUTE5")
	private String attribute5;

	@Column(name = "ATTRIBUTE4")
	private String attribute4;

	@Column(name = "DESCRIPTION")
	private String description;
	
	//@Id
	@Column(name = "LOOKUP_TYPE_CODE")
	private String lookupTypeCode;

	@Column(name = "END_DATE_ACTIVE")
	private Timestamp endDateActive;

	@Column(name = "SEEDED_FLAG")
	private String seededFlag;
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RMAN_LOOKUP_ID_SEQ_gen")
    @SequenceGenerator(name="RMAN_LOOKUP_ID_SEQ_gen", sequenceName="RMAN_LOOKUP_ID_SEQ", allocationSize=1)
	@Column(name="LOOKUP_ID")
	private BigDecimal lookupId;

	public String getAttribute3() {
		return this.attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public BigDecimal getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public String getAttribute2() {
		return this.attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public BigDecimal getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(BigDecimal lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Timestamp getStartDateActive() {
		return this.startDateActive;
	}

	public void setStartDateActive(Timestamp startDateActive) {
		this.startDateActive = startDateActive;
	}

	public String getAttribute1() {
		return this.attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getLookupCode() {
		return this.lookupCode;
	}

	public void setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getEnabledFlag() {
		return this.enabledFlag;
	}

	public void setEnabledFlag(String enabledFlag) {
		this.enabledFlag = enabledFlag;
	}

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getAttribute5() {
		return this.attribute5;
	}

	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}

	public String getAttribute4() {
		return this.attribute4;
	}

	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLookupTypeCode() {
		return this.lookupTypeCode;
	}

	public void setLookupTypeCode(String lookupTypeCode) {
		this.lookupTypeCode = lookupTypeCode;
	}

	public Timestamp getEndDateActive() {
		return this.endDateActive;
	}

	public void setEndDateActive(Timestamp endDateActive) {
		this.endDateActive = endDateActive;
	}

	public String getSeededFlag() {
		return this.seededFlag;
	}

	public void setSeededFlag(String seededFlag) {
		this.seededFlag = seededFlag;
	}

	public BigDecimal getLookupId() {
		return lookupId;
	}

	public void setLookupId(BigDecimal lookupId) {
		this.lookupId = lookupId;
	}

}