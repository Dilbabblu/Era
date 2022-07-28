package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.forsys.revmantra.validators.NumberValidator;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.processor.PreAssignmentProcessor;
import com.opencsv.bean.validators.PreAssignmentValidator;


@Entity
@Table(name="SSP_RULES_INTERFACE")
public class SspRulesInterface {

	@CsvBindByName(column = "SSP_PARAM3_VALUE")
	@Column(name="SSP_PARAM3_VALUE")
    private String sspParam3Value;

    @Column(name="ERROR_MESSAGE")
    private String errorMessage;

    @Column(name="ERROR_FLAG")
    private String errorFlag;

    @CsvBindByName(column = "SSP_CATEGORY")
    @Column(name="SSP_CATEGORY")
    private String sspCategory;

    @CsvBindByName(column = "SSP_PARAM6")
    @Column(name="SSP_PARAM6")
    private String sspParam6;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SSP_RULES_INTERFACE_seq_gen")
    @SequenceGenerator(name="SSP_RULES_INTERFACE_seq_gen", sequenceName="SSP_RULES_INTERFACE_S", allocationSize=1)
    @Column(name="SNO")
    private BigDecimal sno;
    
    @CsvBindByName(column = "SSP_PARAM1")
    @Column(name="SSP_PARAM1")
    private String sspParam1;
    
    @CsvBindByName(column = "SSP_START_DATE")
    @CsvDate(value = "MM/dd/yyyy")
    @Column(name="SSP_START_DATE")
    private Timestamp sspStartDate;
    
    @CsvBindByName(column = "SSP_PARAM5")
    @Column(name="SSP_PARAM5")
    private String sspParam5;
    
    @CsvBindByName(column = "SSP_PARAM4")
    @Column(name="SSP_PARAM4")
    private String sspParam4;
    
    @CsvBindByName(column = "SSP_PARAM5_VALUE")
    @Column(name="SSP_PARAM5_VALUE")
    private String sspParam5Value;
    
    @CsvBindByName(column = "SSP_PARAM3")
    @Column(name="SSP_PARAM3")
    private String sspParam3;
    
    @CsvBindByName(column = "SSP_PARAM2")
    @Column(name="SSP_PARAM2")
    private String sspParam2;
    
    @Column(name="PROCESS_ID")
    private String processId;
    
    @CsvBindByName(column = "SSP_TYPE")
    @Column(name="SSP_TYPE")
    private String sspType;
    
    @CsvBindByName(column = "SSP_PARAM4_VALUE")
    @Column(name="SSP_PARAM4_VALUE")
    private String sspParam4Value;
    
    @CsvBindByName(column = "SSP_PARAM2_VALUE")
    @Column(name="SSP_PARAM2_VALUE")
    private String sspParam2Value;

    @Column(name="CREATION_DATE")
    private Timestamp creationDate;
    
    @CsvBindByName(column = "SSP_RULE_NAME")
    @Column(name="SSP_RULE_NAME")
    private String sspRuleName;

    @Column(name="SSP_RULE_ID")
    private BigDecimal sspRuleId;
    
    @PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "SSP_MAX")
    @Column(name="SSP_MAX")
    private BigDecimal sspMax;
    
    @CsvBindByName(column = "SSP_PARAM6_VALUE")
    @Column(name="SSP_PARAM6_VALUE")
    private String sspParam6Value;
    
    @Column(name="PROCESS_FLAG")
    private String processFlag;
    
    @CsvBindByName(column = "SSP_END_DATE")
    @CsvDate(value = "MM/dd/yyyy")
    @Column(name="SSP_END_DATE")
    private Timestamp sspEndDate;
    
    @PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "SSP_MIN")
    @Column(name="SSP_MIN")
    private BigDecimal sspMin;
    
    @CsvBindByName(column = "SSP_PARAM1_VALUE")
    @Column(name="SSP_PARAM1_VALUE")
    private String sspParam1Value;
    
    @PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "SSP_PRICE")
    @Column(name="SSP_PRICE")
    private BigDecimal sspPrice;
    
    @PreAssignmentValidator(validator = NumberValidator.class)
	@PreAssignmentProcessor(processor = NumberValidator.class)
	@CsvBindByName(column = "SSP_MEDIAN")
    @Column(name="SSP_MEDIAN")
    private BigDecimal sspMedian;
    
    @CsvBindByName(column = "SSP_PARAM1_QUALIFIER")
    @Column(name="SSP_PARAM1_QUALIFIER")
    private String sspParam1Qualifier;

    @CsvBindByName(column = "SSP_PARAM2_QUALIFIER")
    @Column(name="SSP_PARAM2_QUALIFIER")
    private String sspParam2Qualifier;

    @CsvBindByName(column = "SSP_PARAM3_QUALIFIER")
    @Column(name="SSP_PARAM3_QUALIFIER")
    private String sspParam3Qualifier;

    @CsvBindByName(column = "SSP_PARAM4_QUALIFIER")
    @Column(name="SSP_PARAM4_QUALIFIER")
    private String sspParam4Qualifier;

    @CsvBindByName(column = "SSP_PARAM5_QUALIFIER")
    @Column(name="SSP_PARAM5_QUALIFIER")
    private String sspParam5Qualifier;

    @CsvBindByName(column = "SSP_PARAM6_QUALIFIER")
    @Column(name="SSP_PARAM6_QUALIFIER")
    private String sspParam6Qualifier;
    
    @CsvBindByName(column = "SSP_CURRENCY")
    @Column(name="SSP_CURRENCY")
    private String sspcurrency;
    
    @CsvBindByName(column = "SSP_RULE_STATUS")
    @Column(name="SSP_RULE_STATUS")
    private String sspRuleStatus;
    
    @CsvBindByName(column = "SSP_BOOK_NAME")
    @Column(name="SSP_BOOK_NAME")
    private String sspBookName;
    
    @Column(name="CREATED_BY")
    private BigDecimal createdBy;
    
    @Column(name="LAST_UPDATED_BY")
    private BigDecimal lastUpdatedBy;
    
    @Column(name="LAST_UPDATE_DATE")
    private Timestamp lastUpdateDate;
    
    @CsvBindByName(column = "ATTRIBUTE1")
    @Column(name="ATTRIBUTE1")
    private String attribute1;
    
    @CsvBindByName(column = "ATTRIBUTE2")
    @Column(name="ATTRIBUTE2")
    private String attribute2;
    
    @CsvBindByName(column = "ATTRIBUTE3")
    @Column(name="ATTRIBUTE3")
    private String attribute3;
    
    @CsvBindByName(column = "ATTRIBUTE4")
    @Column(name="ATTRIBUTE4")
    private String attribute4;
    
    @CsvBindByName(column = "ATTRIBUTE5")
    @Column(name="ATTRIBUTE5")
    private String attribute5;
    
    public String getSspParam3Value() { 
        return this.sspParam3Value;
    }

    public void setSspParam3Value(String sspParam3Value) { 
        this.sspParam3Value=sspParam3Value;
    }
    public String getErrorMessage() { 
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) { 
        this.errorMessage=errorMessage;
    }
    public String getErrorFlag() { 
        return this.errorFlag;
    }

    public void setErrorFlag(String errorFlag) { 
        this.errorFlag=errorFlag;
    }
    public String getSspCategory() { 
        return this.sspCategory;
    }

    public void setSspCategory(String sspCategory) { 
        this.sspCategory=sspCategory;
    }
    public String getSspParam6() { 
        return this.sspParam6;
    }

    public void setSspParam6(String sspParam6) { 
        this.sspParam6=sspParam6;
    }
    public BigDecimal getSno() { 
        return this.sno;
    }

    public void setSno(BigDecimal sno) { 
        this.sno=sno;
    }
    public String getSspParam1() { 
        return this.sspParam1;
    }

    public void setSspParam1(String sspParam1) { 
        this.sspParam1=sspParam1;
    }
    public Timestamp getSspStartDate() { 
        return this.sspStartDate;
    }

    public void setSspStartDate(Timestamp sspStartDate) { 
        this.sspStartDate=sspStartDate;
    }
    public String getSspParam5() { 
        return this.sspParam5;
    }

    public void setSspParam5(String sspParam5) { 
        this.sspParam5=sspParam5;
    }
    public String getSspParam4() { 
        return this.sspParam4;
    }

    public void setSspParam4(String sspParam4) { 
        this.sspParam4=sspParam4;
    }
    public String getSspParam5Value() { 
        return this.sspParam5Value;
    }

    public void setSspParam5Value(String sspParam5Value) { 
        this.sspParam5Value=sspParam5Value;
    }
    public String getSspParam3() { 
        return this.sspParam3;
    }

    public void setSspParam3(String sspParam3) { 
        this.sspParam3=sspParam3;
    }
    public String getSspParam2() { 
        return this.sspParam2;
    }

    public void setSspParam2(String sspParam2) { 
        this.sspParam2=sspParam2;
    }
    public String getProcessId() { 
        return this.processId;
    }

    public void setProcessId(String processId) { 
        this.processId=processId;
    }
    public String getSspType() { 
        return this.sspType;
    }

    public void setSspType(String sspType) { 
        this.sspType=sspType;
    }
    public String getSspParam4Value() { 
        return this.sspParam4Value;
    }

    public void setSspParam4Value(String sspParam4Value) { 
        this.sspParam4Value=sspParam4Value;
    }
    public String getSspParam2Value() { 
        return this.sspParam2Value;
    }

    public void setSspParam2Value(String sspParam2Value) { 
        this.sspParam2Value=sspParam2Value;
    }
    public Timestamp getCreationDate() { 
        return this.creationDate;
    }

    public void setCreationDate(Timestamp creationDate) { 
        this.creationDate=creationDate;
    }
    public String getSspRuleName() { 
        return this.sspRuleName;
    }

    public void setSspRuleName(String sspRuleName) { 
        this.sspRuleName=sspRuleName;
    }
    public BigDecimal getSspRuleId() { 
        return this.sspRuleId;
    }

    public void setSspRuleId(BigDecimal sspRuleId) { 
        this.sspRuleId=sspRuleId;
    }
    public BigDecimal getSspMax() { 
        return this.sspMax;
    }

    public void setSspMax(BigDecimal sspMax) { 
        this.sspMax=sspMax;
    }
    public String getSspParam6Value() { 
        return this.sspParam6Value;
    }

    public void setSspParam6Value(String sspParam6Value) { 
        this.sspParam6Value=sspParam6Value;
    }
    public String getProcessFlag() { 
        return this.processFlag;
    }

    public void setProcessFlag(String processFlag) { 
        this.processFlag=processFlag;
    }
    public Timestamp getSspEndDate() { 
        return this.sspEndDate;
    }

    public void setSspEndDate(Timestamp sspEndDate) { 
        this.sspEndDate=sspEndDate;
    }
    public BigDecimal getSspMin() { 
        return this.sspMin;
    }

    public void setSspMin(BigDecimal sspMin) { 
        this.sspMin=sspMin;
    }
    public String getSspParam1Value() { 
        return this.sspParam1Value;
    }

    public void setSspParam1Value(String sspParam1Value) { 
        this.sspParam1Value=sspParam1Value;
    }

	public BigDecimal getSspPrice() {
		return sspPrice;
	}

	public void setSspPrice(BigDecimal sspPrice) {
		this.sspPrice = sspPrice;
	}

	public BigDecimal getSspMedian() {
		return sspMedian;
	}

	public void setSspMedian(BigDecimal sspMedian) {
		this.sspMedian = sspMedian;
	}

	public String getSspParam1Qualifier() {
		return sspParam1Qualifier;
	}

	public void setSspParam1Qualifier(String sspParam1Qualifier) {
		this.sspParam1Qualifier = sspParam1Qualifier;
	}

	public String getSspParam2Qualifier() {
		return sspParam2Qualifier;
	}

	public void setSspParam2Qualifier(String sspParam2Qualifier) {
		this.sspParam2Qualifier = sspParam2Qualifier;
	}

	public String getSspParam3Qualifier() {
		return sspParam3Qualifier;
	}

	public void setSspParam3Qualifier(String sspParam3Qualifier) {
		this.sspParam3Qualifier = sspParam3Qualifier;
	}

	public String getSspParam4Qualifier() {
		return sspParam4Qualifier;
	}

	public void setSspParam4Qualifier(String sspParam4Qualifier) {
		this.sspParam4Qualifier = sspParam4Qualifier;
	}

	public String getSspParam5Qualifier() {
		return sspParam5Qualifier;
	}

	public void setSspParam5Qualifier(String sspParam5Qualifier) {
		this.sspParam5Qualifier = sspParam5Qualifier;
	}

	public String getSspParam6Qualifier() {
		return sspParam6Qualifier;
	}

	public void setSspParam6Qualifier(String sspParam6Qualifier) {
		this.sspParam6Qualifier = sspParam6Qualifier;
	}

	public String getSspcurrency() {
		return sspcurrency;
	}

	public void setSspcurrency(String sspcurrency) {
		this.sspcurrency = sspcurrency;
	}

	public String getSspRuleStatus() {
		return sspRuleStatus;
	}

	public void setSspRuleStatus(String sspRuleStatus) {
		this.sspRuleStatus = sspRuleStatus;
	}

	public String getSspBookName() {
		return sspBookName;
	}

	public void setSspBookName(String sspBookName) {
		this.sspBookName = sspBookName;
	}

	public BigDecimal getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
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
    
    

}