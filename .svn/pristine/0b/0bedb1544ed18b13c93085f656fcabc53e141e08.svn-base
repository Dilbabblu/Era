package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import com.forsys.revmantra.listener.RmanCurrencyListener;


@Entity
@EntityListeners(RmanCurrencyListener.class)
@Table(name="RMAN_CURRENCY")
public class RmanCurrency {

    @Column(name="FORMAT")
    private String format;

    @Id
    @Column(name="CURRENCY_CODE")
    private String currencyCode;

    @Column(name="NAME")
    private String name;

    @Column(name = "CREATED_BY")
	private BigDecimal createdBy;
	
	@Column(name = "CREATION_DATE")
	private Timestamp creationDate;
	
	@Column(name = "LAST_UPDATED_BY")
	private BigDecimal lastUpdatedBy;
	
	@Column(name = "LAST_UPDATED_DATE")
	private Timestamp lastUpdatedDate;


    public String getFormat() { 
        return this.format;
    }

    public void setFormat(String format) { 
        this.format=format;
    }
    public String getCurrencyCode() { 
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) { 
        this.currencyCode=currencyCode;
    }
    public String getName() { 
        return this.name;
    }

    public void setName(String name) { 
        this.name=name;
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