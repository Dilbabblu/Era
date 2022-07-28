package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "RMAN_ORDER_BOOKINGS_IFRS_V")
public class RmanOrderBookingsV {
	
	@Transient
	private List<RmanOrderLinesBookingsV> rmanOrderBookingLines;

	public List<RmanOrderLinesBookingsV> getRmanOrderBookingLines() {
		return rmanOrderBookingLines;
	}

	public void setRmanOrderBookingLines(List<RmanOrderLinesBookingsV> rmanOrderBookingLines) {
		this.rmanOrderBookingLines = rmanOrderBookingLines;
	}

	@Column(name = "CUSTOMER_NUMBER")
	private String customerNumber;

	@Column(name = "BILL_TO_LOCATION")
	private String billToLocation;

	@Id
	@Column(name = "SNO")
	private BigDecimal sno;
	
	@Column(name = "SOURCE_HEADER_ID")
	private BigDecimal sourceHeaderId;
	
	

	public BigDecimal getSourceHeaderId() {
		return sourceHeaderId;
	}

	public void setSourceHeaderId(BigDecimal sourceHeaderId) {
		this.sourceHeaderId = sourceHeaderId;
	}

	public BigDecimal getSno() {
		return sno;
	}

	public void setSno(BigDecimal sno) {
		this.sno = sno;
	}

	@Column(name = "SO#")
	private BigDecimal so;

	@Column(name = "PRICE_LIST")
	private String priceList;

	@Column(name = "BOOKING_CURRENCY")
	private String bookingCurrency;

	@Column(name = "CUSTOMER_PO_NUM")
	private String customerPoNum;

	@Column(name = "ARRANGEMENT_ID")
	private BigDecimal arrangementId;

	@Column(name = "FUNC_CURRENCY_CODE")
	private String funcCurrencyCode;

	@Column(name = "LINKED_DATE")
	private Timestamp linkedDate;

	@Column(name = "OU_NAME")
	private String ouName;

	@Column(name = "ORDER_BOOKED_DATE")
	private Timestamp orderBookedDate;

	@Column(name = "ORDER_TRX_AMOUNT")
	private BigDecimal orderTrxAmount;

	@Column(name = "SHIP_TO_LOCATION")
	private String shipToLocation;

	@Column(name = "END_CUSTOMER")
	private String endCustomer;

	@Column(name = "ORDER_ACCTD_AMOUNT")
	private BigDecimal orderAcctdAmount;

	@Column(name = "ORDER_SOURCE")
	private String orderSource;

	@Column(name = "REF_ORDER_NUMBER")
	private BigDecimal refOrderNumber;

	@Column(name = "SERVICE_REF_ORDER")
	private BigDecimal serviceRefOrder;

	@Column(name = "SERVICE_REF_ORD_LINE_NUM")
	private BigDecimal serviceRefOrdLineNum;

	@Column(name = "ORDER_NUM_MODIFIER")
	private String orderNumModifier;
	
	@Column(name = "SALESREP")
	private String salesrep;

	public String getCustomerNumber() {
		return this.customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getBillToLocation() {
		return this.billToLocation;
	}

	public void setBillToLocation(String billToLocation) {
		this.billToLocation = billToLocation;
	}

	public BigDecimal getSo() {
		return this.so;
	}

	public void setSo(BigDecimal so) {
		this.so = so;
	}

	public String getPriceList() {
		return this.priceList;
	}

	public void setPriceList(String priceList) {
		this.priceList = priceList;
	}

	public String getBookingCurrency() {
		return this.bookingCurrency;
	}

	public void setBookingCurrency(String bookingCurrency) {
		this.bookingCurrency = bookingCurrency;
	}

	public String getCustomerPoNum() {
		return this.customerPoNum;
	}

	public void setCustomerPoNum(String customerPoNum) {
		this.customerPoNum = customerPoNum;
	}

	public BigDecimal getArrangementId() {
		return this.arrangementId;
	}

	public void setArrangementId(BigDecimal arrangementId) {
		this.arrangementId = arrangementId;
	}

	public String getFuncCurrencyCode() {
		return this.funcCurrencyCode;
	}

	public void setFuncCurrencyCode(String funcCurrencyCode) {
		this.funcCurrencyCode = funcCurrencyCode;
	}

	public Timestamp getLinkedDate() {
		return this.linkedDate;
	}

	public void setLinkedDate(Timestamp linkedDate) {
		this.linkedDate = linkedDate;
	}

	public String getOuName() {
		return this.ouName;
	}

	public void setOuName(String ouName) {
		this.ouName = ouName;
	}

	public Timestamp getOrderBookedDate() {
		return this.orderBookedDate;
	}

	public void setOrderBookedDate(Timestamp orderBookedDate) {
		this.orderBookedDate = orderBookedDate;
	}

	public BigDecimal getOrderTrxAmount() {
		return this.orderTrxAmount;
	}

	public void setOrderTrxAmount(BigDecimal orderTrxAmount) {
		this.orderTrxAmount = orderTrxAmount;
	}

	public String getShipToLocation() {
		return this.shipToLocation;
	}

	public void setShipToLocation(String shipToLocation) {
		this.shipToLocation = shipToLocation;
	}

	public String getEndCustomer() {
		return this.endCustomer;
	}

	public void setEndCustomer(String endCustomer) {
		this.endCustomer = endCustomer;
	}

	public BigDecimal getOrderAcctdAmount() {
		return this.orderAcctdAmount;
	}

	public void setOrderAcctdAmount(BigDecimal orderAcctdAmount) {
		this.orderAcctdAmount = orderAcctdAmount;
	}

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}

	public BigDecimal getRefOrderNumber() {
		return refOrderNumber;
	}

	public void setRefOrderNumber(BigDecimal refOrderNumber) {
		this.refOrderNumber = refOrderNumber;
	}

	public BigDecimal getServiceRefOrder() {
		return serviceRefOrder;
	}

	public void setServiceRefOrder(BigDecimal serviceRefOrder) {
		this.serviceRefOrder = serviceRefOrder;
	}

	public BigDecimal getServiceRefOrdLineNum() {
		return serviceRefOrdLineNum;
	}

	public void setServiceRefOrdLineNum(BigDecimal serviceRefOrdLineNum) {
		this.serviceRefOrdLineNum = serviceRefOrdLineNum;
	}

	public String getOrderNumModifier() {
		return orderNumModifier;
	}

	public void setOrderNumModifier(String orderNumModifier) {
		this.orderNumModifier = orderNumModifier;
	}

	public String getSalesrep() {
		return salesrep;
	}

	public void setSalesrep(String salesrep) {
		this.salesrep = salesrep;
	}
	
	

}