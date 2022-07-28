package com.forsys.revmantra.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

import com.forsys.revmantra.listener.RmanRevenueTemplatesListener;

@Entity
@EntityListeners(RmanRevenueTemplatesListener.class)
@Table(name = "RMAN_REVENUE_TEMPLATES")
public class RmanRevenueTemplates implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "AMORT_RULE_REVENUE")
	private String amortRuleRevenue;

	@Column(name = "CREATED_DATE")
	private Timestamp createdDate;

	@Column(name = "END_DATE")
	private Timestamp endDate;

	@Column(name = "AMORT_METHOD_REVENUE")
	private String amortMethodRevenue;

	@Column(name = "AMORT_RULE_COGS")
	private String amortRuleCogs;

	@Column(name = "REVENUE_RESERVE_SUBACCOUNT")
	private String revenueReserveSubaccount;

	@Column(name = "DEF_COGS_SUBACCOUNT")
	private String defCogsSubaccount;

	@Column(name = "COGS_SUBACCOUNT")
	private String cogsSubaccount;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "REV_AMORT_ACCOUNT")
	private String revAmortAccount;

	@Column(name = "ACC_RULE_COGS")
	private String accRuleCogs;

	@Column(name = "REV_AMORT_SUBACCOUNT")
	private String revAmortSubaccount;

	@Column(name = "ACC_TRIGGER_COGS")
	private String accTriggerCogs;

	@Column(name = "CREATED_BY")
	private BigDecimal createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private BigDecimal lastUpdatedBy;

	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;

	@Column(name = "AMORT_METHOD_COGS")
	private String amortMethodCogs;

	@Column(name = "COGS_ACCOUNT")
	private String cogsAccount;

	@Column(name = "REV_ACCOUNT")
	private String revAccount;

	@Column(name = "START_DATE")
	private Timestamp startDate;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RMAN_REVENUE_TEMPLATES_seq_gen")
	@SequenceGenerator(name = "RMAN_REVENUE_TEMPLATES_seq_gen", sequenceName = "RMAN_REV_TEMPLATE_S", allocationSize=1)
	@Column(name = "REVENUE_TEMPLATE_ID")
	private BigDecimal revenueTemplateId;

	@Column(name = "LAST_UPDATED_DATE")
	private Timestamp lastUpdatedDate;

	@Column(name = "TEMPLATE_NAME")
	private String templateName;

	@Column(name = "REV_SUBACCOUNT")
	private String revSubaccount;

	@Column(name = "DEF_COGS_ACCOUNT")
	private String defCogsAccount;

	@Column(name = "ACC_TRIGGER_REVENUE")
	private String accTriggerRevenue;

	@Column(name = "ACC_RULE_REVENUE")
	private String accRuleRevenue;

	@Column(name = "DEF_REV_SUBACCOUNT")
	private String defRevSubaccount;

	@Column(name = "DEF_REV_ACCOUNT")
	private String defRevAccount;

	@Column(name = "REV_RESERVE_ACCOUNT")
	private String revReserveAccount;

	@Column(name = "DEF_REVENUE_CONT_ACCOUNT")
	private String defRevenueContAccount;

	@Column(name = "DEF_REVENUE_CONT_SUBACCOUNT")
	private String defRevenueContSubaccount;
	
	@Column(name = "LT_ST_FLAG")
	private String ltstFlag;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumnsOrFormulas({
	@JoinColumnOrFormula(column = @JoinColumn(name = "ACC_TRIGGER_COGS", insertable = false, updatable = false,referencedColumnName = "LOOKUP_CODE")),
	@JoinColumnOrFormula(formula = @JoinFormula(value="'ACCOUNTING_TRIGGER'",referencedColumnName = "LOOKUP_TYPE_NAME"))
	}
	)
	private RmanLookupsV rmanLookupsV;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column = @JoinColumn(name = "ACC_RULE_REVENUE", insertable = false, updatable = false,referencedColumnName = "LOOKUP_CODE")),
		@JoinColumnOrFormula(formula = @JoinFormula(value= "'REVENUE_TEMPLATE_RULE'",referencedColumnName = "LOOKUP_TYPE_NAME"))
	})
	private RmanLookupsV rmanLookupsV1;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column = @JoinColumn(name = "ACC_TRIGGER_REVENUE", insertable = false, updatable = false,referencedColumnName = "LOOKUP_CODE")),
		@JoinColumnOrFormula(formula = @JoinFormula(value= "'ACCOUNTING_TRIGGER'",referencedColumnName = "LOOKUP_TYPE_NAME"))
	})
	private RmanLookupsV rmanLookupsV2;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column = @JoinColumn(name = "AMORT_METHOD_COGS", insertable = false, updatable = false,referencedColumnName = "LOOKUP_CODE")),
		@JoinColumnOrFormula(formula = @JoinFormula(value= "'AMORTIZATION_METHOD'",referencedColumnName = "LOOKUP_TYPE_NAME"))
	})
	private RmanLookupsV rmanLookupsV3;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column = @JoinColumn(name = "AMORT_METHOD_REVENUE", insertable = false, updatable = false,referencedColumnName = "LOOKUP_CODE")),
		@JoinColumnOrFormula(formula = @JoinFormula(value= "'AMORTIZATION_METHOD'",referencedColumnName = "LOOKUP_TYPE_NAME"))
	})
	private RmanLookupsV rmanLookupsV4;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column = @JoinColumn(name = "ACC_RULE_COGS", insertable = false, updatable = false,referencedColumnName = "LOOKUP_CODE")),
		@JoinColumnOrFormula(formula = @JoinFormula(value= "'REVENUE_TEMPLATE_RULE'",referencedColumnName = "LOOKUP_TYPE_NAME"))
	})
	private RmanLookupsV rmanLookupsV5;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column = @JoinColumn(name = "AMORT_RULE_REVENUE", insertable = false, updatable = false,referencedColumnName = "LOOKUP_CODE")),
		@JoinColumnOrFormula(formula = @JoinFormula(value= "'AMORTIZATION_RULE'",referencedColumnName = "LOOKUP_TYPE_NAME"))
	})
	private RmanLookupsV rmanLookupsV6;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumnsOrFormulas({
		@JoinColumnOrFormula(column = @JoinColumn(name = "AMORT_RULE_COGS", insertable = false, updatable = false,referencedColumnName = "LOOKUP_CODE")),
		@JoinColumnOrFormula(formula = @JoinFormula(value= "'AMORTIZATION_RULE'",referencedColumnName = "LOOKUP_TYPE_NAME"))
	})
	private RmanLookupsV rmanLookupsV7;

	public String getAmortRuleRevenue() {
		return this.amortRuleRevenue;
	}

	public void setAmortRuleRevenue(String amortRuleRevenue) {
		this.amortRuleRevenue = amortRuleRevenue;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getAmortMethodRevenue() {
		return this.amortMethodRevenue;
	}

	public void setAmortMethodRevenue(String amortMethodRevenue) {
		this.amortMethodRevenue = amortMethodRevenue;
	}

	public String getAmortRuleCogs() {
		return this.amortRuleCogs;
	}

	public void setAmortRuleCogs(String amortRuleCogs) {
		this.amortRuleCogs = amortRuleCogs;
	}

	public String getRevenueReserveSubaccount() {
		return this.revenueReserveSubaccount;
	}

	public void setRevenueReserveSubaccount(String revenueReserveSubaccount) {
		this.revenueReserveSubaccount = revenueReserveSubaccount;
	}

	public String getDefCogsSubaccount() {
		return this.defCogsSubaccount;
	}

	public void setDefCogsSubaccount(String defCogsSubaccount) {
		this.defCogsSubaccount = defCogsSubaccount;
	}

	public String getCogsSubaccount() {
		return this.cogsSubaccount;
	}

	public void setCogsSubaccount(String cogsSubaccount) {
		this.cogsSubaccount = cogsSubaccount;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRevAmortAccount() {
		return this.revAmortAccount;
	}

	public void setRevAmortAccount(String revAmortAccount) {
		this.revAmortAccount = revAmortAccount;
	}

	public String getAccRuleCogs() {
		return this.accRuleCogs;
	}

	public void setAccRuleCogs(String accRuleCogs) {
		this.accRuleCogs = accRuleCogs;
	}

	public String getRevAmortSubaccount() {
		return this.revAmortSubaccount;
	}

	public void setRevAmortSubaccount(String revAmortSubaccount) {
		this.revAmortSubaccount = revAmortSubaccount;
	}

	public String getAccTriggerCogs() {
		return this.accTriggerCogs;
	}

	public void setAccTriggerCogs(String accTriggerCogs) {
		this.accTriggerCogs = accTriggerCogs;
	}

	public BigDecimal getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public BigDecimal getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(BigDecimal lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getAmortMethodCogs() {
		return this.amortMethodCogs;
	}

	public void setAmortMethodCogs(String amortMethodCogs) {
		this.amortMethodCogs = amortMethodCogs;
	}

	public String getCogsAccount() {
		return this.cogsAccount;
	}

	public void setCogsAccount(String cogsAccount) {
		this.cogsAccount = cogsAccount;
	}

	public String getRevAccount() {
		return this.revAccount;
	}

	public void setRevAccount(String revAccount) {
		this.revAccount = revAccount;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public BigDecimal getRevenueTemplateId() {
		return this.revenueTemplateId;
	}

	public void setRevenueTemplateId(BigDecimal revenueTemplateId) {
		this.revenueTemplateId = revenueTemplateId;
	}

	public Timestamp getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getTemplateName() {
		return this.templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getRevSubaccount() {
		return this.revSubaccount;
	}

	public void setRevSubaccount(String revSubaccount) {
		this.revSubaccount = revSubaccount;
	}

	public String getDefCogsAccount() {
		return this.defCogsAccount;
	}

	public void setDefCogsAccount(String defCogsAccount) {
		this.defCogsAccount = defCogsAccount;
	}

	public String getAccTriggerRevenue() {
		return this.accTriggerRevenue;
	}

	public void setAccTriggerRevenue(String accTriggerRevenue) {
		this.accTriggerRevenue = accTriggerRevenue;
	}

	public String getAccRuleRevenue() {
		return this.accRuleRevenue;
	}

	public void setAccRuleRevenue(String accRuleRevenue) {
		this.accRuleRevenue = accRuleRevenue;
	}

	public String getDefRevSubaccount() {
		return this.defRevSubaccount;
	}

	public void setDefRevSubaccount(String defRevSubaccount) {
		this.defRevSubaccount = defRevSubaccount;
	}

	public String getDefRevAccount() {
		return this.defRevAccount;
	}

	public void setDefRevAccount(String defRevAccount) {
		this.defRevAccount = defRevAccount;
	}

	public String getRevReserveAccount() {
		return this.revReserveAccount;
	}

	public void setRevReserveAccount(String revReserveAccount) {
		this.revReserveAccount = revReserveAccount;
	}

	public RmanLookupsV getRmanLookupsV() {
		return rmanLookupsV;
	}

	public void setRmanLookupsV(RmanLookupsV rmanLookupsV) {
		this.rmanLookupsV = rmanLookupsV;
	}

	public RmanLookupsV getRmanLookupsV1() {
		return rmanLookupsV1;
	}

	public void setRmanLookupsV1(RmanLookupsV rmanLookupsV1) {
		this.rmanLookupsV1 = rmanLookupsV1;
	}

	public RmanLookupsV getRmanLookupsV2() {
		return rmanLookupsV2;
	}

	public void setRmanLookupsV2(RmanLookupsV rmanLookupsV2) {
		this.rmanLookupsV2 = rmanLookupsV2;
	}

	public RmanLookupsV getRmanLookupsV3() {
		return rmanLookupsV3;
	}

	public void setRmanLookupsV3(RmanLookupsV rmanLookupsV3) {
		this.rmanLookupsV3 = rmanLookupsV3;
	}

	public RmanLookupsV getRmanLookupsV4() {
		return rmanLookupsV4;
	}

	public void setRmanLookupsV4(RmanLookupsV rmanLookupsV4) {
		this.rmanLookupsV4 = rmanLookupsV4;
	}

	public RmanLookupsV getRmanLookupsV5() {
		return rmanLookupsV5;
	}

	public void setRmanLookupsV5(RmanLookupsV rmanLookupsV5) {
		this.rmanLookupsV5 = rmanLookupsV5;
	}

	public RmanLookupsV getRmanLookupsV6() {
		return rmanLookupsV6;
	}

	public void setRmanLookupsV6(RmanLookupsV rmanLookupsV6) {
		this.rmanLookupsV6 = rmanLookupsV6;
	}

	public RmanLookupsV getRmanLookupsV7() {
		return rmanLookupsV7;
	}

	public void setRmanLookupsV7(RmanLookupsV rmanLookupsV7) {
		this.rmanLookupsV7 = rmanLookupsV7;
	}

	public String getDefRevenueContAccount() {
		return defRevenueContAccount;
	}

	public void setDefRevenueContAccount(String defRevenueContAccount) {
		this.defRevenueContAccount = defRevenueContAccount;
	}

	public String getDefRevenueContSubaccount() {
		return defRevenueContSubaccount;
	}

	public void setDefRevenueContSubaccount(String defRevenueContSubaccount) {
		this.defRevenueContSubaccount = defRevenueContSubaccount;
	}
	

	@Column(name = "ADDITIONAL_ATTRIBUTE1")
	private String additionalAttribute1;

	@Column(name = "ADDITIONAL_ATTRIBUTE2")
	private String additionalAttribute2;
	

	@Column(name = "ADDITIONAL_ATTRIBUTE3")
	private String additionalAttribute3;

	@Column(name = "ADDITIONAL_ATTRIBUTE4")
	private String additionalAttribute4;

	@Column(name = "ADDITIONAL_ATTRIBUTE5")
	private String additionalAttribute5;
	
	public String getAdditionalAttribute1() {
		return additionalAttribute1;
	}

	public void setAdditionalAttribute1(String additionalAttribute1) {
		this.additionalAttribute1 = additionalAttribute1;
	}

	public String getAdditionalAttribute2() {
		return additionalAttribute2;
	}

	public void setAdditionalAttribute2(String additionalAttribute2) {
		this.additionalAttribute2 = additionalAttribute2;
	}

	public String getAdditionalAttribute3() {
		return additionalAttribute3;
	}

	public void setAdditionalAttribute3(String additionalAttribute3) {
		this.additionalAttribute3 = additionalAttribute3;
	}

	public String getAdditionalAttribute4() {
		return additionalAttribute4;
	}

	public void setAdditionalAttribute4(String additionalAttribute4) {
		this.additionalAttribute4 = additionalAttribute4;
	}

	public String getAdditionalAttribute5() {
		return additionalAttribute5;
	}

	public void setAdditionalAttribute5(String additionalAttribute5) {
		this.additionalAttribute5 = additionalAttribute5;
	}

	public String getLtstFlag() {
		return ltstFlag;
	}

	public void setLtstFlag(String ltstFlag) {
		this.ltstFlag = ltstFlag;
	}

}