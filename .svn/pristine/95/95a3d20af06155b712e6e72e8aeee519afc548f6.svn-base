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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.forsys.revmantra.listener.RmanGlAccountsListener;

@Entity
@EntityListeners(RmanGlAccountsListener.class)
@Table(name = "RMAN_GL_ACCOUNTS")
public class RmanGlAccounts {

	@Column(name = "CREATED_BY")
	private BigDecimal createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private BigDecimal lastUpdatedBy;

	@Column(name = "SEGMENT10")
	private String segment10;

	@Column(name = "ACCOUNT_TYPE")
	private String accountType;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RMAN_GL_ACCOUNTS_seq_gen")
	@SequenceGenerator(name = "RMAN_GL_ACCOUNTS_seq_gen", sequenceName = "RMAN_ACCOUNT_ID_S", allocationSize=1)
	@Column(name = "ACCOUNT_ID")
	private BigDecimal accountId;

	@Column(name = "SOURCE_LEDGER_ID")
	private BigDecimal sourceLedgerId;

	@Column(name = "CREATION_DATE")
	private Timestamp creationDate;

	@Column(name = "SEGMENT2")
	private String segment2;

	@Column(name = "SEGMENT1")
	private String segment1;

	@Column(name = "ENABLED_FLAG")
	private String enabledFlag;

	@Column(name = "LAST_UPDATE_DATE")
	private Timestamp lastUpdateDate;

	@Column(name = "SEGMENT8")
	private String segment8;

	@Column(name = "SEGMENT7")
	private String segment7;

	@Column(name = "SEGMENT9")
	private String segment9;

	@Column(name = "ACCOUNTING_STRING")
	private String accountingString;

	@Column(name = "SEGMENT4")
	private String segment4;

	@Column(name = "LEDGER_ID")
	private BigDecimal ledgerId;

	@Column(name = "SEGMENT3")
	private String segment3;

	@Column(name = "SEGMENT6")
	private String segment6;

	@Column(name = "SEGMENT5")
	private String segment5;

	@Column(name = "SOURCE_ACCOUNT_ID")
	private BigDecimal sourceAccountId;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ACCOUNT_TYPE", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	private RmanLookupsV rmanLookupsV;

	public RmanLookupsV getRmanLookupsV() {
		return rmanLookupsV;
	}

	public void setRmanLookupsV(RmanLookupsV rmanLookupsV) {
		this.rmanLookupsV = rmanLookupsV;
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

	public String getSegment10() {
		return this.segment10;
	}

	public void setSegment10(String segment10) {
		this.segment10 = segment10;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public BigDecimal getAccountId() {
		return this.accountId;
	}

	public void setAccountId(BigDecimal accountId) {
		this.accountId = accountId;
	}

	public BigDecimal getSourceLedgerId() {
		return this.sourceLedgerId;
	}

	public void setSourceLedgerId(BigDecimal sourceLedgerId) {
		this.sourceLedgerId = sourceLedgerId;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getSegment2() {
		return this.segment2;
	}

	public void setSegment2(String segment2) {
		this.segment2 = segment2;
	}

	public String getSegment1() {
		return this.segment1;
	}

	public void setSegment1(String segment1) {
		this.segment1 = segment1;
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

	public String getSegment8() {
		return this.segment8;
	}

	public void setSegment8(String segment8) {
		this.segment8 = segment8;
	}

	public String getSegment7() {
		return this.segment7;
	}

	public void setSegment7(String segment7) {
		this.segment7 = segment7;
	}

	public String getSegment9() {
		return this.segment9;
	}

	public void setSegment9(String segment9) {
		this.segment9 = segment9;
	}

	public String getAccountingString() {
		return this.accountingString;
	}

	public void setAccountingString(String accountingString) {
		this.accountingString = accountingString;
	}

	public String getSegment4() {
		return this.segment4;
	}

	public void setSegment4(String segment4) {
		this.segment4 = segment4;
	}

	public BigDecimal getLedgerId() {
		return this.ledgerId;
	}

	public void setLedgerId(BigDecimal ledgerId) {
		this.ledgerId = ledgerId;
	}

	public String getSegment3() {
		return this.segment3;
	}

	public void setSegment3(String segment3) {
		this.segment3 = segment3;
	}

	public String getSegment6() {
		return this.segment6;
	}

	public void setSegment6(String segment6) {
		this.segment6 = segment6;
	}

	public String getSegment5() {
		return this.segment5;
	}

	public void setSegment5(String segment5) {
		this.segment5 = segment5;
	}

	public BigDecimal getSourceAccountId() {
		return this.sourceAccountId;
	}

	public void setSourceAccountId(BigDecimal sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}

}