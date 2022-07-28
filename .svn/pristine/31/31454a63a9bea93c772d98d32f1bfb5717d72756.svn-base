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

import com.forsys.revmantra.listener.RmanUsageSummaryInterfaceListener;
import com.forsys.revmantra.validators.NumberValidator;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.processor.PreAssignmentProcessor;
import com.opencsv.bean.validators.PreAssignmentValidator;


@Entity
@EntityListeners(RmanUsageSummaryInterfaceListener.class)
@Table(name="RMAN_USAGE_SUMMARY_INTERFACE")
public class RmanUsageSummaryInterface {
	
	@CsvBindByName(column="ACCOUNTING_DATE", required = true)
    @Column(name="ATTRIBUTE3")
    private String attribute3;

	@CsvBindByName(column="USAGE_TOTAL", required = true)
    @Column(name="ATTRIBUTE10")
    private String attribute10;
    
    @CsvBindByName(column="USAGE_ID", required = true)
    @Column(name="SF_USAGE_SUMMARY_ID")
    private String sfUsageSummaryId;

    @Column(name="ATTRIBUTE2")
    private String attribute2;

    @Column(name="ATTRIBUTE1")
    private String attribute1;
    
    @CsvDate(value = "MM/dd/yyyy")
    @CsvBindByName(column="USAGE_END_DATE", required = true)
    @Column(name="SUMMARY_END_DATE")
    private Timestamp summaryEndDate;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RMAN_USAGE_SUMMARY_INT_seq_gen")
    @SequenceGenerator(name="RMAN_USAGE_SUMMARY_INT_seq_gen", sequenceName="RMAN_USAGE_SUMMARY_INT_S", allocationSize=1)
    @Column(name="USAGE_ID")
    private BigDecimal usageId;
    
    @CsvBindByName(column="ORDER_LINE_ID", required = true)
    @Column(name="ORDER_LINE_ID")
    private String orderLineId;

    @CsvBindByName(column="USAGE_LIST_PRICE", required = true)
    @Column(name="ATTRIBUTE9")
    private String attribute9;
    
    @PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
    @CsvBindByName(column="UNBILLED_SUB_TOTAL", required = true)
    @Column(name="UNBILLED_SUB_TOTAL")
    private BigDecimal unbilledSubTotal;

    @CsvBindByName(column="USAGE_NUMBER", required = true)
    @Column(name="ATTRIBUTE8")
    private String attribute8;

    @CsvBindByName(column="USAGE_SUMMARY_ID", required = true)
    @Column(name="ATTRIBUTE7")
    private String attribute7;

    @CsvBindByName(column="USAGE_TYPE", required = true)
    @Column(name="ATTRIBUTE6")
    private String attribute6;

    @CsvBindByName(column="USAGE_PERIOD", required = true)
    @Column(name="ATTRIBUTE5")
    private String attribute5;

    @Column(name="INTERFACE_PROCESS_ID")
    private BigDecimal interfaceProcessId;

    @CsvBindByName(column="ACCOUNTING_PERIOD", required = true)
    @Column(name="ATTRIBUTE4")
    private String attribute4;

    @CsvBindByName(column="USAGE_SUMMARY_NUMBER", required = true)
    @Column(name="SF_USAGE_SUMMARY_NUMBER")
    private String sfUsageSummaryNumber;

    @Column(name="INTERFACE_STATUS")
    private String interfaceStatus;

    @PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
    @CsvBindByName(column="UNIT_SELLING_PRICE", required = true)
    @Column(name="UNIT_SELLING_PRICE")
    private BigDecimal unitSellingPrice;

    @CsvBindByName(column="ORDER_LINE_NUMBER", required = true)
    @Column(name="ORDER_LINE_NUMBER")
    private String orderLineNumber;

    @PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
    @CsvBindByName(column="TOTAL_QTY", required = true)
    @Column(name="TOTAL_QTY")
    private BigDecimal totalQty;
    
    @CsvBindByName(column="ORDER_NUMBER", required = true)
    @Column(name="ORDER_NUMBER")
    private String orderNumber;
    
    @CsvDate(value = "MM/dd/yyyy")
    @CsvBindByName(column="USAGE_START_DATE", required = true)
    @Column(name="SUMMARY_START_DATE")
    private Timestamp summaryStartDate;

    @Column(name = "ERROR_MESSAGE")
    private String errorMessage;

    @Column(name = "OPERATION_CODE")
    private String operation_code;
    
    @CsvBindByName(column="USAGE_CUMMULATIVE_TOTAL", required = true)
    @Column(name="ATTRIBUTE11")
    private String attribute11;
    
    @Column(name="ATTRIBUTE12")
    private String attribute12;
    
    @Column(name="ATTRIBUTE13")
    private String attribute13;
    
    @Column(name="ATTRIBUTE14")
    private String attribute14;
    
    @Column(name="ATTRIBUTE15")
    private String attribute15;
    
    @Column(name="CREATED_BY")
    private BigDecimal createdBy;
    
    @Column(name="CREATION_DATE")
    private Timestamp creationDate;
    
    @Column(name="LAST_UPDATED_BY")
    private BigDecimal lastUpdatedBy;
    
    @Column(name="LAST_UPDATE_DATE")
    private Timestamp lastUpdateDate;
    
    public String getOperation_code() {
		return operation_code;
	}

	public void setOperation_code(String operation_code) {
		this.operation_code = operation_code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getAttribute3() { 
        return this.attribute3;
    }

    public void setAttribute3(String attribute3) { 
        this.attribute3=attribute3;
    }
    public String getAttribute10() { 
        return this.attribute10;
    }

    public void setAttribute10(String attribute10) { 
        this.attribute10=attribute10;
    }
    public String getSfUsageSummaryId() { 
        return this.sfUsageSummaryId;
    }

    public void setSfUsageSummaryId(String sfUsageSummaryId) { 
        this.sfUsageSummaryId=sfUsageSummaryId;
    }
    public String getAttribute2() { 
        return this.attribute2;
    }

    public void setAttribute2(String attribute2) { 
        this.attribute2=attribute2;
    }
    public String getAttribute1() { 
        return this.attribute1;
    }

    public void setAttribute1(String attribute1) { 
        this.attribute1=attribute1;
    }
    public Timestamp getSummaryEndDate() { 
        return this.summaryEndDate;
    }

    public void setSummaryEndDate(Timestamp summaryEndDate) { 
        this.summaryEndDate=summaryEndDate;
    }
    public BigDecimal getUsageId() { 
        return this.usageId;
    }

    public void setUsageId(BigDecimal usageId) { 
        this.usageId=usageId;
    }
    public String getOrderLineId() { 
        return this.orderLineId;
    }

    public void setOrderLineId(String orderLineId) { 
        this.orderLineId=orderLineId;
    }
    public String getAttribute9() { 
        return this.attribute9;
    }

    public void setAttribute9(String attribute9) { 
        this.attribute9=attribute9;
    }
    public BigDecimal getUnbilledSubTotal() { 
        return this.unbilledSubTotal;
    }

    public void setUnbilledSubTotal(BigDecimal unbilledSubTotal) { 
        this.unbilledSubTotal=unbilledSubTotal;
    }
    public String getAttribute8() { 
        return this.attribute8;
    }

    public void setAttribute8(String attribute8) { 
        this.attribute8=attribute8;
    }
    public String getAttribute7() { 
        return this.attribute7;
    }

    public void setAttribute7(String attribute7) { 
        this.attribute7=attribute7;
    }
    public String getAttribute6() { 
        return this.attribute6;
    }

    public void setAttribute6(String attribute6) { 
        this.attribute6=attribute6;
    }
    public String getAttribute5() { 
        return this.attribute5;
    }

    public void setAttribute5(String attribute5) { 
        this.attribute5=attribute5;
    }
    public BigDecimal getInterfaceProcessId() { 
        return this.interfaceProcessId;
    }

    public void setInterfaceProcessId(BigDecimal interfaceProcessId) { 
        this.interfaceProcessId=interfaceProcessId;
    }
    public String getAttribute4() { 
        return this.attribute4;
    }

    public void setAttribute4(String attribute4) { 
        this.attribute4=attribute4;
    }
    public String getSfUsageSummaryNumber() { 
        return this.sfUsageSummaryNumber;
    }

    public void setSfUsageSummaryNumber(String sfUsageSummaryNumber) { 
        this.sfUsageSummaryNumber=sfUsageSummaryNumber;
    }
    public String getInterfaceStatus() { 
        return this.interfaceStatus;
    }

    public void setInterfaceStatus(String interfaceStatus) { 
        this.interfaceStatus=interfaceStatus;
    }
    public BigDecimal getUnitSellingPrice() { 
        return this.unitSellingPrice;
    }

    public void setUnitSellingPrice(BigDecimal unitSellingPrice) { 
        this.unitSellingPrice=unitSellingPrice;
    }
    public String getOrderLineNumber() { 
        return this.orderLineNumber;
    }

    public void setOrderLineNumber(String orderLineNumber) { 
        this.orderLineNumber=orderLineNumber;
    }
    public BigDecimal getTotalQty() { 
        return this.totalQty;
    }

    public void setTotalQty(BigDecimal totalQty) { 
        this.totalQty=totalQty;
    }
    public String getOrderNumber() { 
        return this.orderNumber;
    }

    public void setOrderNumber(String orderNumber) { 
        this.orderNumber=orderNumber;
    }
    public Timestamp getSummaryStartDate() { 
        return this.summaryStartDate;
    }

    public void setSummaryStartDate(Timestamp summaryStartDate) { 
        this.summaryStartDate=summaryStartDate;
    }

	public String getAttribute11() {
		return attribute11;
	}

	public void setAttribute11(String attribute11) {
		this.attribute11 = attribute11;
	}

	public String getAttribute12() {
		return attribute12;
	}

	public void setAttribute12(String attribute12) {
		this.attribute12 = attribute12;
	}

	public String getAttribute13() {
		return attribute13;
	}

	public void setAttribute13(String attribute13) {
		this.attribute13 = attribute13;
	}

	public String getAttribute14() {
		return attribute14;
	}

	public void setAttribute14(String attribute14) {
		this.attribute14 = attribute14;
	}

	public String getAttribute15() {
		return attribute15;
	}

	public void setAttribute15(String attribute15) {
		this.attribute15 = attribute15;
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

	public Timestamp getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
    
    

}