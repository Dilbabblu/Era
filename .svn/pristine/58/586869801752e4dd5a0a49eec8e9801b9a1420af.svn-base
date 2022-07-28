package com.forsys.revmantra.model;

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

import com.forsys.revmantra.listener.RmanAccountSetupListener;

@Entity
@EntityListeners(RmanAccountSetupListener.class)
@Table(name = "RMAN_ACCOUNT_SETUP")
public class RmanAccountSetup {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RMAN_ACCOUNT_SETUP_seq_gen")
    @SequenceGenerator(name="RMAN_ACCOUNT_SETUP_seq_gen", sequenceName="RMAN_ACCOUNT_SETUP_S", allocationSize=1)
    @Column(name="ACCT_SETUP_ID")
	private BigDecimal acctSetupId;
	
	public BigDecimal getAcctSetupId() {
		return acctSetupId;
	}

	public void setAcctSetupId(BigDecimal acctSetupId) {
		this.acctSetupId = acctSetupId;
	}

	@Column(name = "ACCOUNTING_STRUCTURE")
	private String accountingStructure;

	@Column(name = "REVENUE")
	private String revenue;

	@Column(name = "COGS")
	private String cogs;

	@Column(name = "DEFERRED_COGS")
	private String deferredCogs;

	@Column(name = "PROVISION")
	private String provision;

	@Column(name = "AMORTIZATION_DEFERRALS")
	private String amortizationDeferrals;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DEFERRED_REVENUE")
	private String deferredRevenue;

	@Column(name = "CLEARING_ACCOUNT")
	private String cearingAccount;

	@Column(name = "DEF_REVENUE_CONTINGENCY")
	private String defRevenueContingency;

	@Column(name = "CONTRACT_LIABILITY")
	private String contractLiability;
	
	@Column(name="CONTRACT_ASSET")
	private String contractAsset;
	
	
	@Column(name="LEGAL_ENTITY_ID")
	private BigDecimal legalEntityId;
	
	@Column(name="LEGAL_ENTITY_NAME")
	private String legalEntityName;
	
	@Column(name="DEFERRED_REVENUE_ST")
	private String deferredRevenueSt;
	
	@Column(name="DEFERRED_REVENUE_LT")
	private String deferredRevenueLt;
	

	@Column(name = "CREATED_BY")
	private BigDecimal createdBy;
	
	@Column(name = "CREATION_DATE")
	private Timestamp creationDate;
	
	@Column(name = "LAST_UPDATED_BY")
	private BigDecimal lastUpdatedBy;
	
	@Column(name = "LAST_UPDATED_DATE")
	private Timestamp lastUpdatedDate;
	
	
	public String getContractAsset() {
		return contractAsset;
	}

	public void setContractAsset(String contractAsset) {
		this.contractAsset = contractAsset;
	}

	public String getContractLiability() {
		return contractLiability;
	}

	public void setContractLiability(String contractLiability) {
		this.contractLiability = contractLiability;
	}

	public String getAccountingStructure() {
		return this.accountingStructure;
	}

	public void setAccountingStructure(String accountingStructure) {
		this.accountingStructure = accountingStructure;
	}

	public String getRevenue() {
		return this.revenue;
	}

	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}

	public String getCogs() {
		return this.cogs;
	}

	public void setCogs(String cogs) {
		this.cogs = cogs;
	}

	public String getDeferredCogs() {
		return this.deferredCogs;
	}

	public void setDeferredCogs(String deferredCogs) {
		this.deferredCogs = deferredCogs;
	}

	public String getProvision() {
		return this.provision;
	}

	public void setProvision(String provision) {
		this.provision = provision;
	}

	public String getAmortizationDeferrals() {
		return this.amortizationDeferrals;
	}

	public void setAmortizationDeferrals(String amortizationDeferrals) {
		this.amortizationDeferrals = amortizationDeferrals;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeferredRevenue() {
		return this.deferredRevenue;
	}

	public void setDeferredRevenue(String deferredRevenue) {
		this.deferredRevenue = deferredRevenue;
	}

	public String getDefRevenueContingency() {
		return defRevenueContingency;
	}

	public void setDefRevenueContingency(String defRevenueContingency) {
		this.defRevenueContingency = defRevenueContingency;
	}

	public String getCearingAccount() {
		return cearingAccount;
	}

	public void setCearingAccount(String cearingAccount) {
		this.cearingAccount = cearingAccount;
	}

	public BigDecimal getLegalEntityId() {
		return legalEntityId;
	}

	public void setLegalEntityId(BigDecimal legalEntityId) {
		this.legalEntityId = legalEntityId;
	}

	public String getLegalEntityName() {
		return legalEntityName;
	}

	public void setLegalEntityName(String legalEntityName) {
		this.legalEntityName = legalEntityName;
	}

	public String getDeferredRevenueSt() {
		return deferredRevenueSt;
	}

	public void setDeferredRevenueSt(String deferredRevenueSt) {
		this.deferredRevenueSt = deferredRevenueSt;
	}

	public String getDeferredRevenueLt() {
		return deferredRevenueLt;
	}

	public void setDeferredRevenueLt(String deferredRevenueLt) {
		this.deferredRevenueLt = deferredRevenueLt;
	}

	public BigDecimal getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public BigDecimal getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(BigDecimal lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Timestamp getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	
	
	
}