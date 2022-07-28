package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AYARA_ACTIVE_DELEGATE_USERS_LIST_V")
public class AyaraActiveDelegateUsersListV {
	
	@Id
	@Column(name="RMAN_USER_ID")
	private BigDecimal rmanUserId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="EMAIL_ADDRESS")
	private String emailAddress;
	
	@Column(name="FULL_NAME")
	private String fullName;
	
	@Column(name="ENTITY_NAME")
	private String entityName;
	
	@Column(name="ENTITY_ID")
	private BigDecimal entityId;
	
	@Column(name="USER_ROLE")
	private String userRole;
	
	@Column(name="USER_ROLE_ID")
	private BigDecimal userRoleId;
	
	@Column(name="RANK")
	private String rank;

	public BigDecimal getRmanUserId() {
		return rmanUserId;
	}

	public void setRmanUserId(BigDecimal rmanUserId) {
		this.rmanUserId = rmanUserId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public BigDecimal getEntityId() {
		return entityId;
	}

	public void setEntityId(BigDecimal entityId) {
		this.entityId = entityId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public BigDecimal getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(BigDecimal userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	
}
