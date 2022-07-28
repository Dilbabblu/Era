package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.forsys.revmantra.listener.RmanUsersListener;

@Entity
@EntityListeners(RmanUsersListener.class)
@Table(name = "RMAN_USERS")
public class RmanUsers {

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

	@Column(name = "RMAN_EMPLOYEE_ID")
	private String rmanEmployeeId;

	@Column(name = "CREATION_DATE")
	private Timestamp creationDate;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "LAST_UPDATE_DATE")
	private Timestamp lastUpdateDate;

	@Column(name = "WORK_PHONE")
	private String workPhone;

	@Column(name = "FIRST_NAME")
	private String firstName;

	/**
	 * Reset Password Token
	 */
	@Column(name = "ATTRIBUTE5")
	private String attribute5;

	/**
	 * Reset Password Secret Key
	 */
	@Column(name = "ATTRIBUTE4")
	private String attribute4;

	@Column(name = "CELL_PHONE")
	private String cellPhone;

	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;

	@Column(name = "USER_PASSWORD")
	private String userPassword;

	@Column(name = "MGR_ID")
	private BigDecimal mgrId;

	@Column(name = "FULL_NAME")
	private String fullName;

	@Column(name = "HOME_PHONE")
	private String homePhone;

	@Column(name = "END_DATE_ACTIVE")
	private Timestamp endDateActive;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RMAN_USERS_seq_gen")
	@SequenceGenerator(name = "RMAN_USERS_seq_gen", sequenceName = "RMAN_USERS_S", allocationSize=1)
	@Column(name = "RMAN_USER_ID")
	private BigDecimal rmanUserId;
	
	@Column(name = "ENABLED_FLAG")
	private String enabledFlag;
	
	@Column(name = "CREATED_USER")
	private String createdUser;
	
	@Column(name = "UPDATED_USER")
	private String updatedUser;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "RMAN_USER_ID",insertable=false,updatable=false)
	Set<RmanUserResponsibilities> rmanUserResponsibilitiesSet;
	
	@OneToOne(fetch=FetchType.EAGER,optional=true)
	@JoinColumn(name="ATTRIBUTE1",insertable=false,updatable=false,referencedColumnName="LEGAL_ENTITY_ID")
	private RmanLegalEntities rmanLegalEntities;

	public RmanLegalEntities getRmanLegalEntities() {
		return rmanLegalEntities;
	}

	public void setRmanLegalEntities(RmanLegalEntities rmanLegalEntities) {
		this.rmanLegalEntities = rmanLegalEntities;
	}

	public Set<RmanUserResponsibilities> getRmanUserResponsibilitiesSet() {
		return rmanUserResponsibilitiesSet;
	}

	public void setRmanUserResponsibilitiesSet(Set<RmanUserResponsibilities> rmanUserResponsibilitiesSet) {
		this.rmanUserResponsibilitiesSet = rmanUserResponsibilitiesSet;
	}

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

	public String getRmanEmployeeId() {
		return this.rmanEmployeeId;
	}

	public void setRmanEmployeeId(String rmanEmployeeId) {
		this.rmanEmployeeId = rmanEmployeeId;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getWorkPhone() {
		return this.workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getCellPhone() {
		return this.cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public BigDecimal getMgrId() {
		return this.mgrId;
	}

	public void setMgrId(BigDecimal mgrId) {
		this.mgrId = mgrId;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getHomePhone() {
		return this.homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public Timestamp getEndDateActive() {
		return this.endDateActive;
	}

	public void setEndDateActive(Timestamp endDateActive) {
		this.endDateActive = endDateActive;
	}

	public BigDecimal getRmanUserId() {
		return this.rmanUserId;
	}

	public void setRmanUserId(BigDecimal rmanUserId) {
		this.rmanUserId = rmanUserId;
	}

	public RmanUsers() {
		/** No-code */
	}

	public String getEnabledFlag() {
		return enabledFlag;
	}

	public void setEnabledFlag(String enabledFlag) {
		this.enabledFlag = enabledFlag;
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
	
	

}