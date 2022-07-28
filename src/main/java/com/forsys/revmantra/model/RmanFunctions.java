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


@Entity
//@EntityListeners(RmanFunctionsListener.class)
@Table(name="RMAN_FUNCTIONS")
public class RmanFunctions {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RMAN_FUNCTIONS_seq_gen")
	@SequenceGenerator(name = "RMAN_FUNCTIONS_seq_gen", sequenceName = "RMAN_FUNCTIONS_S", allocationSize=1)
	@Column(name="FID")
    private BigDecimal fid;

    @Column(name="MODULE")
    private String module;

    @Column(name="FCODE")
    private String fcode;

    @Column(name="URL")
    private String url;

    @Column(name="NAME")
    private String name;
    
    @Column(name = "ENABLED_FLAG")
    private String enabledFlag;
    
    @Column(name = "CREATED_BY")
    private BigDecimal createdBy;
    
    @Column(name = "CREATION_DATE")
    private Timestamp creationDate;
    
    @Column(name = "LAST_UPDATED_BY")
    private BigDecimal lastUpdatedBy;
    
    @Column(name = "LAST_UPDATE_DATE")
    private Timestamp lastUpdateDate;
    
   
    @Column(name = "CREATED_USER")
	private String createdUser;
    
    @Column(name = "UPDATED_USER")
	private String updatedUser;
    
    @Column(name = "FTYPE")
    private String fType;
	
	


    public String getEnabledFlag() {
		return enabledFlag;
	}

	public void setEnabledFlag(String enabledFlag) {
		this.enabledFlag = enabledFlag;
	}

	public BigDecimal getFid() { 
        return this.fid;
    }

    public void setFid(BigDecimal fid) { 
        this.fid=fid;
    }
    public String getModule() { 
        return this.module;
    }

    public void setModule(String module) { 
        this.module=module;
    }
    public String getFcode() { 
        return this.fcode;
    }

    public void setFcode(String fcode) { 
        this.fcode=fcode;
    }
    public String getUrl() { 
        return this.url;
    }

    public void setUrl(String url) { 
        this.url=url;
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

	public Timestamp getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public String getUpdatedUser() {
		return updatedUser;
	}

	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	public String getfType() {
		return fType;
	}

	public void setfType(String fType) {
		this.fType = fType;
	}
    
    

}