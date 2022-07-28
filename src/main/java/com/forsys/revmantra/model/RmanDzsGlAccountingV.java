package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RMAN_DZS_GL_ACCOUNTING_V")
public class RmanDzsGlAccountingV {

	@Column(name = "DEAL_ARRANGEMENT_NUMBER")
	private String dealArrangementNumber;

	@Column(name = "SOURCE_LINE_ID")
	private BigDecimal sourceLineId;

	@Column(name = "PO")
	private String po;

	@Column(name = "SO")
	private BigDecimal so;

	@Column(name = "ELEMENT_TYPE")
	private String elementType;

	@Column(name = "DEAL_ARRANGEMENT_NAME")
	private String dealArrangementName;

	@Column(name = "POSTED_FLAG")
	private String postedFlag;

	@Column(name = "PERIOD_NAME")
	private String periodName;

	@Column(name = "ACCOUNT")
	private String account;

	@Column(name = "T_CUR")
	private String tcur;

	@Column(name = "AMOUNT_TC")
	private BigDecimal amountTc;

	@Column(name = "NOTE")
	private String note;

	@Column(name = "CUSTOMER")
	private String customer;

	@Id
	@Column(name = "RMAN_INTERFACE_ID")
	private BigDecimal rmanInterfaceId;

	@Column(name = "ACCOUNT_DESCRIPTION")
	private String accountDescription;

	@Column(name = "AMOUNT_FC")
	private BigDecimal amountFc;

	@Column(name = "DEAL_LINE_NUMBER")
	private BigDecimal dealLineNumber;

	@Column(name = "DR_CR")
	private String drCr;

	@Column(name = "SO_LINE")
	private String soLine;

	@Column(name = "CUST")
	private String cust;

	@Column(name = "LINE_STATUS")
	private String lineStatus;

	@Column(name = "GL_DATE")
	private Timestamp glDate;

	@Column(name = "INVOICE")
	private String invoice;

	@Column(name = "ACCOUNT_CLASS")
	private String accountClass;

	@Column(name = "F_CUR")
	private String fcur;

	@Column(name = "DELIVERED_DATE")
	private Timestamp deliveredDate;

	@Column(name = "CONT_NAME")
	private String contName;

	@Column(name = "ENTRY_TYPE")
	private String entryType;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "PRODUCT_LINE")
	private String productLine;

	@Column(name = "DIVISION")
	private String division;

	public String getDealArrangementNumber() {
		return this.dealArrangementNumber;
	}

	public void setDealArrangementNumber(String dealArrangementNumber) {
		this.dealArrangementNumber = dealArrangementNumber;
	}

	public BigDecimal getSourceLineId() {
		return this.sourceLineId;
	}

	public void setSourceLineId(BigDecimal sourceLineId) {
		this.sourceLineId = sourceLineId;
	}

	public String getPo() {
		return this.po;
	}

	public void setPo(String po) {
		this.po = po;
	}

	public BigDecimal getSo() {
		return this.so;
	}

	public void setSo(BigDecimal so) {
		this.so = so;
	}

	public String getElementType() {
		return this.elementType;
	}

	public void setElementType(String elementType) {
		this.elementType = elementType;
	}

	public String getDealArrangementName() {
		return this.dealArrangementName;
	}

	public void setDealArrangementName(String dealArrangementName) {
		this.dealArrangementName = dealArrangementName;
	}

	public String getPostedFlag() {
		return this.postedFlag;
	}

	public void setPostedFlag(String postedFlag) {
		this.postedFlag = postedFlag;
	}

	public String getPeriodName() {
		return this.periodName;
	}

	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getTcur() {
		return this.tcur;
	}

	public void setTcur(String tcur) {
		this.tcur = tcur;
	}

	public BigDecimal getAmountTc() {
		return this.amountTc;
	}

	public void setAmountTc(BigDecimal amountTc) {
		this.amountTc = amountTc;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCustomer() {
		return this.customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public BigDecimal getRmanInterfaceId() {
		return this.rmanInterfaceId;
	}

	public void setRmanInterfaceId(BigDecimal rmanInterfaceId) {
		this.rmanInterfaceId = rmanInterfaceId;
	}

	public String getAccountDescription() {
		return this.accountDescription;
	}

	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}

	public BigDecimal getAmountFc() {
		return this.amountFc;
	}

	public void setAmountFc(BigDecimal amountFc) {
		this.amountFc = amountFc;
	}

	public BigDecimal getDealLineNumber() {
		return this.dealLineNumber;
	}

	public void setDealLineNumber(BigDecimal dealLineNumber) {
		this.dealLineNumber = dealLineNumber;
	}

	public String getDrCr() {
		return this.drCr;
	}

	public void setDrCr(String drCr) {
		this.drCr = drCr;
	}

	public String getSoLine() {
		return this.soLine;
	}

	public void setSoLine(String soLine) {
		this.soLine = soLine;
	}

	public String getCust() {
		return this.cust;
	}

	public void setCust(String cust) {
		this.cust = cust;
	}

	public String getLineStatus() {
		return this.lineStatus;
	}

	public void setLineStatus(String lineStatus) {
		this.lineStatus = lineStatus;
	}

	public Timestamp getGlDate() {
		return this.glDate;
	}

	public void setGlDate(Timestamp glDate) {
		this.glDate = glDate;
	}

	public String getInvoice() {
		return this.invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getAccountClass() {
		return this.accountClass;
	}

	public void setAccountClass(String accountClass) {
		this.accountClass = accountClass;
	}

	public String getFcur() {
		return this.fcur;
	}

	public void setFcur(String fcur) {
		this.fcur = fcur;
	}

	public Timestamp getDeliveredDate() {
		return this.deliveredDate;
	}

	public void setDeliveredDate(Timestamp deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public String getContName() {
		return this.contName;
	}

	public void setContName(String contName) {
		this.contName = contName;
	}

	public String getEntryType() {
		return entryType;
	}

	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

}