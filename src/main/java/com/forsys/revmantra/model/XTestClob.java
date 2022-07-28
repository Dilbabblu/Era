package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="JSON_DOCUMENTS")
public class XTestClob {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AYARA_REPORTS_S_seq_gen")
    @SequenceGenerator(name="AYARA_REPORTS_S_seq_gen", sequenceName="AYARA_REPORTS_S", allocationSize=1)
	@Column(name="ID")
	private BigDecimal id;
	
	@Lob
	@Column(name="DATA")
	private String clob;
	
	@Column(name="REPORT_NAME")
	private String reportName;
	
	@Column(name="FAVORITE_FLAG")
	private String favoriteFlag;
	
	@Column(name="SHOW_ON_DASHBAORD")
	private String showOnDashbaord;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getClob() {
		return clob;
	}

	public void setClob(String clob) {
		this.clob = clob;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getFavoriteFlag() {
		return favoriteFlag;
	}

	public void setFavoriteFlag(String favoriteFlag) {
		this.favoriteFlag = favoriteFlag;
	}

	public String getShowOnDashbaord() {
		return showOnDashbaord;
	}

	public void setShowOnDashbaord(String showOnDashbaord) {
		this.showOnDashbaord = showOnDashbaord;
	}
	

}