package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.forsys.revmantra.cpk.id.ConversionRatesPkId;
import com.forsys.revmantra.listener.RmanConversionRatesIntListener;


@Entity
@EntityListeners(RmanConversionRatesIntListener.class)
@Table(name="RMAN_CONVERSION_RATES_INT")
@IdClass(ConversionRatesPkId.class)
public class RmanConversionRatesInt {

    @Column(name="ATTRIBUTE10")
    private String attribute10;

    @Column(name="CONVERSION_START_DATE")
    private Timestamp conversionStartDate;

    @Column(name="ATTRIBUTE14")
    private String attribute14;

    @Column(name="ATTRIBUTE13")
    private String attribute13;

    @Column(name="CREATED_DATE")
    private Timestamp createdDate;

    @Column(name="ATTRIBUTE12")
    private String attribute12;

    @Column(name="ATTRIBUTE11")
    private String attribute11;

    @Column(name="INVERSE_CONVERSION_RATE")
    private BigDecimal inverseConversionRate;

    @Column(name="INTERFACE_STATUS")
    private String interfaceStatus;

    @Column(name="STATUS_CODE")
    private String statusCode;

    @Column(name="CONVERSION_TYPE")
    private String conversionType;
    
    @Id
    @Column(name="TO_CURRENCY")
    private String toCurrency;
    
    
    @Column(name="PROCESS_ID")
    private String processId;

    @Column(name="ATTRIBUTE3")
    private String attribute3;

    @Column(name="CREATED_BY")
    private BigDecimal createdBy;

    @Column(name="ATTRIBUTE2")
    private String attribute2;

    @Column(name="LAST_UPDATED_BY")
    private BigDecimal lastUpdatedBy;

    @Column(name="ATTRIBUTE1")
    private String attribute1;
    
    @Column(name="CONVERSION_RATE")
    private BigDecimal conversionRate;

    @Column(name="ATTRIBUTE9")
    private String attribute9;

    @Column(name="ATTRIBUTE8")
    private String attribute8;

    @Column(name="ATTRIBUTE7")
    private String attribute7;

    @Column(name="ATTRIBUTE6")
    private String attribute6;

    @Column(name="ATTRIBUTE5")
    private String attribute5;

    @Column(name="ATTRIBUTE4")
    private String attribute4;

    @Column(name="LAST_UPDATED_DATE")
    private Timestamp lastUpdatedDate;
    
    @Id
    @Column(name="FROM_CURRENCY")
    private String fromCurrency;

    @Column(name="ATTRIBUTE15")
    private String attribute15;

    @Column(name="CONVERSION_END_DATE")
    private Timestamp conversionEndDate;
    
    @Id
    @Column(name="CONVERSION_DATE")
    private Timestamp conversionDate;
    
    @Column(name="ORIGINAL_CREATED_BY")
    private BigDecimal originalCreatedBy;
    
    @Column(name="ORIGINAL_CREATED_DATE")
    private Timestamp originalCreatedDate;
    
    @Column(name="ORIGINAL_LAST_UPDATED_BY")
    private BigDecimal originalLastUpdatedBy;
    
    @Column(name="ORIGINAL_LAST_UPDATED_DATE")
    private Timestamp orginalLastUpdatedDate;
    
    @Column(name="ORIGINAL_LAST_UPDATED_LOGIN")
    private BigDecimal originalLastUpdatedLogin;
    
    @Column(name="CONTEXT")
    private String context;
    

    public String getAttribute10() { 
        return this.attribute10;
    }

    public void setAttribute10(String attribute10) { 
        this.attribute10=attribute10;
    }
    public Timestamp getConversionStartDate() { 
        return this.conversionStartDate;
    }

    public void setConversionStartDate(Timestamp conversionStartDate) { 
        this.conversionStartDate=conversionStartDate;
    }
    public String getAttribute14() { 
        return this.attribute14;
    }

    public void setAttribute14(String attribute14) { 
        this.attribute14=attribute14;
    }
    public String getAttribute13() { 
        return this.attribute13;
    }

    public void setAttribute13(String attribute13) { 
        this.attribute13=attribute13;
    }
    public Timestamp getCreatedDate() { 
        return this.createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) { 
        this.createdDate=createdDate;
    }
    public String getAttribute12() { 
        return this.attribute12;
    }

    public void setAttribute12(String attribute12) { 
        this.attribute12=attribute12;
    }
    public String getAttribute11() { 
        return this.attribute11;
    }

    public void setAttribute11(String attribute11) { 
        this.attribute11=attribute11;
    }
    public BigDecimal getInverseConversionRate() { 
        return this.inverseConversionRate;
    }

    public void setInverseConversionRate(BigDecimal inverseConversionRate) { 
        this.inverseConversionRate=inverseConversionRate;
    }
    public String getInterfaceStatus() { 
        return this.interfaceStatus;
    }

    public void setInterfaceStatus(String interfaceStatus) { 
        this.interfaceStatus=interfaceStatus;
    }

    public String getConversionType() { 
        return this.conversionType;
    }

    public void setConversionType(String conversionType) { 
        this.conversionType=conversionType;
    }
    public String getToCurrency() { 
        return this.toCurrency;
    }

    public void setToCurrency(String toCurrency) { 
        this.toCurrency=toCurrency;
    }
    public String getProcessId() { 
        return this.processId;
    }

    public void setProcessId(String processId) { 
        this.processId=processId;
    }
    public String getAttribute3() { 
        return this.attribute3;
    }

    public void setAttribute3(String attribute3) { 
        this.attribute3=attribute3;
    }
    public BigDecimal getCreatedBy() { 
        return this.createdBy;
    }

    public void setCreatedBy(BigDecimal createdBy) { 
        this.createdBy=createdBy;
    }
    public String getAttribute2() { 
        return this.attribute2;
    }

    public void setAttribute2(String attribute2) { 
        this.attribute2=attribute2;
    }
    public BigDecimal getLastUpdatedBy() { 
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(BigDecimal lastUpdatedBy) { 
        this.lastUpdatedBy=lastUpdatedBy;
    }
    public String getAttribute1() { 
        return this.attribute1;
    }

    public void setAttribute1(String attribute1) { 
        this.attribute1=attribute1;
    }
    public BigDecimal getConversionRate() { 
        return this.conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) { 
        this.conversionRate=conversionRate;
    }
    public String getAttribute9() { 
        return this.attribute9;
    }

    public void setAttribute9(String attribute9) { 
        this.attribute9=attribute9;
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
    public String getAttribute4() { 
        return this.attribute4;
    }

    public void setAttribute4(String attribute4) { 
        this.attribute4=attribute4;
    }
    public Timestamp getLastUpdatedDate() { 
        return this.lastUpdatedDate;
    }

    public void setLastUpdatedDate(Timestamp lastUpdatedDate) { 
        this.lastUpdatedDate=lastUpdatedDate;
    }
    public String getFromCurrency() { 
        return this.fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) { 
        this.fromCurrency=fromCurrency;
    }
    public String getAttribute15() { 
        return this.attribute15;
    }

    public void setAttribute15(String attribute15) { 
        this.attribute15=attribute15;
    }
    public Timestamp getConversionEndDate() { 
        return this.conversionEndDate;
    }

    public void setConversionEndDate(Timestamp conversionEndDate) { 
        this.conversionEndDate=conversionEndDate;
    }
    public Timestamp getConversionDate() { 
        return this.conversionDate;
    }

    public void setConversionDate(Timestamp conversionDate) { 
        this.conversionDate=conversionDate;
    }

	public BigDecimal getOriginalCreatedBy() {
		return originalCreatedBy;
	}

	public void setOriginalCreatedBy(BigDecimal originalCreatedBy) {
		this.originalCreatedBy = originalCreatedBy;
	}

	public Timestamp getOriginalCreatedDate() {
		return originalCreatedDate;
	}

	public void setOriginalCreatedDate(Timestamp originalCreatedDate) {
		this.originalCreatedDate = originalCreatedDate;
	}

	public BigDecimal getOriginalLastUpdatedBy() {
		return originalLastUpdatedBy;
	}

	public void setOriginalLastUpdatedBy(BigDecimal originalLastUpdatedBy) {
		this.originalLastUpdatedBy = originalLastUpdatedBy;
	}

	public Timestamp getOrginalLastUpdatedDate() {
		return orginalLastUpdatedDate;
	}

	public void setOrginalLastUpdatedDate(Timestamp orginalLastUpdatedDate) {
		this.orginalLastUpdatedDate = orginalLastUpdatedDate;
	}

	public BigDecimal getOriginalLastUpdatedLogin() {
		return originalLastUpdatedLogin;
	}

	public void setOriginalLastUpdatedLogin(BigDecimal originalLastUpdatedLogin) {
		this.originalLastUpdatedLogin = originalLastUpdatedLogin;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	

}