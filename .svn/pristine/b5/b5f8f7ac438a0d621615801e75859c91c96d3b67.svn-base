package com.forsys.revmantra.model;

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
import javax.persistence.Transient;

import com.forsys.revmantra.listener.RmanPobMappingListener;

@Entity
@EntityListeners(RmanPobMappingListener.class)
@Table(name = "RMAN_POB_MAPPING")
public class RmanPobMapping {

	@Column(name = "POB_GROUPING")
	private String pobGrouping;

	@Column(name = "PARENT_SKU")
	private String parentSku;

	@Column(name = "ATTRIBUTE3")
	private String attribute3;

	@Column(name = "ATTRIBUTE2")
	private String attribute2;

	@Column(name = "ATTRIBUTE1")
	private String attribute1;

	@Column(name = "STANDALONE_SUB_SKU")
	private String standaloneSubSku;

	@Column(name = "END_DATE")
	private Timestamp endDate;

	@Column(name = "START_DATE")
	private Timestamp startDate;

	@Column(name = "SPLIT")
	private BigDecimal split;

	@Column(name = "ATTRIBUTE5")
	private String attribute5;

	@Column(name = "ATTRIBUTE4")
	private String attribute4;

	@Column(name = "SPLIT_BASIS")
	private String splitBasis;

	@Column(name = "STATUS")
	private String status;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RMAN_POB_MAPPING_seq_gen")
	@SequenceGenerator(name = "RMAN_POB_MAPPING_seq_gen", sequenceName = "RMAN_POB_MAPPING_S", allocationSize=1)
	@Column(name = "POB_MAP_ID")
	private BigDecimal pobMapId;

	@Column(name = "SKU_TYPE")
	private String skuType;
	
	@Column(name = "CREATED_BY")
	private BigDecimal createdBy;
	
	@Column(name = "CREATION_DATE")
	private Timestamp creationDate;
	
	@Column(name = "LAST_UPDATED_BY")
	private BigDecimal lastUpdatedBy;
	
	@Column(name = "LAST_UPDATED_DATE")
	private Timestamp lastUpdatedDate;

	/**
	 * @OneToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name="PARENT_SKU",insertable = false, updatable = false )
	 * private RmanProducts rmanProducts;
	 * 
	 * @OneToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name="STANDALONE_SUB_SKU",insertable = false, updatable =
	 * false ) private RmanProducts rmanProducts1;
	 */

	@OneToOne(fetch = FetchType.EAGER,optional=true)
	@JoinColumn(name = "SPLIT_BASIS", insertable = false, updatable = false)
	private RmanLookupsV rmanLookupsV;
	
	@OneToOne(fetch=FetchType.EAGER,optional=true)
	@JoinColumn(name="ATTRIBUTE1",insertable=false,updatable=false,referencedColumnName="LEGAL_ENTITY_ID")
	private RmanLegalEntities rmanLegalEntities;
	
	@Transient
	private String legalEntityName;
	
	@Transient
	public String getLegalEntityName(){
		return rmanLegalEntities!=null ? rmanLegalEntities.getName() : "";
	}
	
	public RmanLegalEntities getRmanLegalEntities() {
		return rmanLegalEntities;
	}

	public void setRmanLegalEntities(RmanLegalEntities rmanLegalEntities) {
		this.rmanLegalEntities = rmanLegalEntities;
	}

	public RmanLookupsV getRmanLookupsV() {
		return rmanLookupsV;
	}

	public void setRmanLookupsV(RmanLookupsV rmanLookupsV) {
		this.rmanLookupsV = rmanLookupsV;
	}

	public String getPobGrouping() {
		return this.pobGrouping;
	}

	public void setPobGrouping(String pobGrouping) {
		this.pobGrouping = pobGrouping;
	}

	public String getParentSku() {
		return this.parentSku;
	}

	public void setParentSku(String parentSku) {
		this.parentSku = parentSku;
	}

	public String getAttribute3() {
		return this.attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public String getAttribute2() {
		return this.attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public String getAttribute1() {
		return this.attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getStandaloneSubSku() {
		return this.standaloneSubSku;
	}

	public void setStandaloneSubSku(String standaloneSubSku) {
		this.standaloneSubSku = standaloneSubSku;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public BigDecimal getSplit() {
		return this.split;
	}

	public void setSplit(BigDecimal split) {
		this.split = split;
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

	public String getSplitBasis() {
		return this.splitBasis;
	}

	public void setSplitBasis(String splitBasis) {
		this.splitBasis = splitBasis;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getPobMapId() {
		return this.pobMapId;
	}

	public void setPobMapId(BigDecimal pobMapId) {
		this.pobMapId = pobMapId;
	}

	public String getSkuType() {
		return this.skuType;
	}

	public void setSkuType(String skuType) {
		this.skuType = skuType;
	}

	/**
	 * public RmanProducts getRmanProducts() { return rmanProducts; }
	 * 
	 * public void setRmanProducts(RmanProducts rmanProducts) {
	 * this.rmanProducts = rmanProducts; }
	 * 
	 * public RmanProducts getRmanProducts1() { return rmanProducts1; }
	 * 
	 * public void setRmanProducts1(RmanProducts rmanProducts1) {
	 * this.rmanProducts1 = rmanProducts1; }
	 */
	

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