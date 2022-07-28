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

import com.forsys.revmantra.listener.RmanConversionRatesListener;


@Entity
@EntityListeners(RmanConversionRatesListener.class)
@Table(name="RMAN_CONVERSION_RATES")
public class RmanConversionRates {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RMAN_CONVERSION_RATES_seq_gen")
	@SequenceGenerator(name = "RMAN_CONVERSION_RATES_seq_gen", sequenceName = "RMAN_CONVERSION_RATES_S", allocationSize=1)
    @Column(name="CONVERSION_ID")
    private BigDecimal convresionId;

	@Column(name="ATTRIBUTE10")
    private String attribute10;
	
	
    @Column(name="CONVERSION_START_DATE",nullable = true)
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

    @Column(name="CONVERSION_TYPE")
    private String conversionType;
    
    @Column(name="TO_CURRENCY")
    private String toCurrency;

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
    
    @Column(name="FROM_CURRENCY")
    private String fromCurrency;

    @Column(name="ATTRIBUTE15")
    private String attribute15;

    @Column(name="CONVERSION_END_DATE",nullable = true)
    private Timestamp conversionEndDate;
    
    @Column(name="CONVERSION_DATE",nullable = true)
    private Timestamp conversionDate;
    

    @Column(name="STATUS_CODE")
    private String statusCode;

    public Timestamp getConversionDate() {
		return conversionDate;
	}

	public void setConversionDate(Timestamp conversionDate) {
		this.conversionDate = conversionDate;
	}

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

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
    
    

}