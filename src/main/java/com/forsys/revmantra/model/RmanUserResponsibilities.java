package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.forsys.revmantra.cpk.id.RmanUserResponsibilitiesPk;
import com.forsys.revmantra.listener.RmanUserResponsibilitiesListener;

@Entity
@EntityListeners(RmanUserResponsibilitiesListener.class)
@IdClass(RmanUserResponsibilitiesPk.class)
@Table(name = "RMAN_USER_RESPONSIBILITIES")
public class RmanUserResponsibilities {

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

	@Column(name = "CREATION_DATE")
	private Timestamp creationDate;

	@Column(name = "LAST_UPDATE_DATE")
	private Timestamp lastUpdateDate;

	@Id
	@Column(name = "RESPONSIBILITY_ID")
	private BigDecimal responsibilityId;

	@Column(name = "ATTRIBUTE5")
	private String attribute5;

	@Column(name = "ATTRIBUTE4")
	private String attribute4;

	@Column(name = "END_DATE_ACTIVE")
	private Timestamp endDateActive;

	@Column(name = "SEEDED_FLAG")
	private String seededFlag;

	@Id
	@Column(name = "RMAN_USER_ID")
	private BigDecimal rmanUserId;
	/**
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "RMAN_USER_ID", insertable = false, updatable = false)
	 * private RmanUsers rmanUsers;
	 */

	@ManyToOne
	@JoinColumn(name = "RESPONSIBILITY_ID", insertable = false, updatable = false)
	private RmanResponsibilities rmanResponsibilities;

	/**
	 * public void setRmanUsers(RmanUsers rmanUsers) { this.rmanUsers =
	 * rmanUsers; }
	 * 
	 * public RmanUsers getRmanUsers() { return this.rmanUsers; }
	 */
	
	@Column(name = "CREATED_USER")
	private String createdUser;
	
	@Column(name = "UPDATED_USER")
	private String updatedUser;
	
	@Column(name = "ENABLED_FLAG")
	private String enabledFlag;
	
	
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

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public BigDecimal getResponsibilityId() {
		return this.responsibilityId;
	}

	public void setResponsibilityId(BigDecimal responsibilityId) {
		this.responsibilityId = responsibilityId;
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

	public BigDecimal getRmanUserId() {
		return this.rmanUserId;
	}

	public void setRmanUserId(BigDecimal rmanUserId) {
		this.rmanUserId = rmanUserId;
	}

	public RmanResponsibilities getRmanResponsibilities() {
		return rmanResponsibilities;
	}

	public void setRmanResponsibilities(RmanResponsibilities rmanResponsibilities) {
		this.rmanResponsibilities = rmanResponsibilities;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public String getUpdatedUser() {
		return updatedUser;
	}

	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	public String getEnabledFlag() {
		return enabledFlag;
	}

	public void setEnabledFlag(String enabledFlag) {
		this.enabledFlag = enabledFlag;
	}
	
	

}