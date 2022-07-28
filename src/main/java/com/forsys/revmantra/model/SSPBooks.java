package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.forsys.revmantra.listener.SspBookListener;


@Entity
@EntityListeners(SspBookListener.class)
@Table(name = "AYARA_SSP_BOOKS")
public class SSPBooks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AYARA_SSP_BOOKS_seq_gen")
	@SequenceGenerator(name = "AYARA_SSP_BOOKS_seq_gen", sequenceName = "AYARA_SSP_BOOKS_S", allocationSize=1)
	@Column(name="BOOK_ID")
	private BigDecimal bookId;
		
	@Column(name="BOOK_NAME")
	private String bookName;
	
	@Column(name="START_DATE")
	private Timestamp startDate;
	
	@Column(name="END_DATE")
	private Timestamp endDate;
	
	@Column(name="BOOK_STATUS")
	private String status;
	
	@Column(name="ATTRIBUTE1")
	private String attribute1;
	
	@Column(name="ATTRIBUTE2")
	private String attribute2;
	
	@Column(name="ATTRIBUTE3")
	private String attribute3;
	
	@Column(name="ATTRIBUTE4")
	private String attribute4;
	
	@Column(name="ATTRIBUTE5")
	private String attribute5;
	
	@Column(name="ATTRIBUTE6")
	private String attribute6;
	
	@Column(name="ATTRIBUTE7")
	private String attribute7;
	
	@Column(name="ATTRIBUTE8")
	private String attribute8;
	
	@Column(name="ATTRIBUTE9")
	private String attribute9;
	
	@Column(name="ATTRIBUTE10")
	private String attribute10;
	
	@Column(name="CREATION_DATE")
	private Timestamp creationDate;
	
	@Column(name="CREATED_BY")
	private BigDecimal createdBy;
	
	@Column(name="LAST_UPDATE_DATE")
	private Timestamp lastUpdateDate;
	
	@Column(name="LAST_UPDATED_BY")
	private BigDecimal lastUpdatedBy;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "BOOK_ID", updatable = false, insertable = false)
	private List<RmanFmvRulesDef> rmanFmvRulesDef;
	
	public List<RmanFmvRulesDef> getRmanFmvRulesDef() {
		return rmanFmvRulesDef;
	}

	public void setRmanFmvRulesDef(List<RmanFmvRulesDef> rmanFmvRulesDef) {
		this.rmanFmvRulesDef = rmanFmvRulesDef;
	}

	public BigDecimal getBookId() {
		return bookId;
	}

	public void setBookId(BigDecimal bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getAttribute2() {
		return attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public String getAttribute3() {
		return attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public String getAttribute4() {
		return attribute4;
	}

	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	public String getAttribute5() {
		return attribute5;
	}

	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}

	public String getAttribute6() {
		return attribute6;
	}

	public void setAttribute6(String attribute6) {
		this.attribute6 = attribute6;
	}

	public String getAttribute7() {
		return attribute7;
	}

	public void setAttribute7(String attribute7) {
		this.attribute7 = attribute7;
	}

	public String getAttribute8() {
		return attribute8;
	}

	public void setAttribute8(String attribute8) {
		this.attribute8 = attribute8;
	}

	public String getAttribute9() {
		return attribute9;
	}

	public void setAttribute9(String attribute9) {
		this.attribute9 = attribute9;
	}

	public String getAttribute10() {
		return attribute10;
	}

	public void setAttribute10(String attribute10) {
		this.attribute10 = attribute10;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public BigDecimal getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public BigDecimal getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(BigDecimal lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	

}
