package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.forsys.revmantra.listener.RmanRoleFunctionsListener;


@Entity
@EntityListeners(RmanRoleFunctionsListener.class)
@Table(name="RMAN_ROLE_FUNCTIONS")
public class RmanRoleFunctions {

    @Column(name="READ")
    private BigDecimal read;

    @Column(name="UPLOAD")
    private BigDecimal upload;

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RMAN_ROLE_FUNCTIONS_seq_gen")
	@SequenceGenerator(name = "RMAN_ROLE_FUNCTIONS_seq_gen", sequenceName = "RMAN_ROLE_FUNCTIONS_S", allocationSize=1)
    @Column(name="RFID")
    private BigDecimal rfid;

    @Column(name="ROLEID")
    private String roleid;

    @Column(name="FUNCTION_ID")
    private BigDecimal functionId;

    @Column(name="WRITE")
    private BigDecimal write;
    
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
    
    
    @ManyToOne
	@JoinColumn(name = "FUNCTION_ID", insertable = false, updatable = false, referencedColumnName = "FID")
	@Where(clause="ENABLED_FLAG = 'Y'")
    private RmanFunctions rmanFunctions;
    
    @Column(name = "CREATED_USER")
    private String createdUser;
	
    @Column(name = "UPDATED_USER")
	private String updatedUser;
	
    @Column(name = "START_DATE_ACTIVE")
	private Timestamp startDateActive;
	
    @Column(name = "END_DATE_ACTIVE")
	private Timestamp endDateActive;
	

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

	
    public BigDecimal getRead() { 
        return this.read;
    }

    public void setRead(BigDecimal read) { 
        this.read=read;
    }
    public BigDecimal getUpload() { 
        return this.upload;
    }

    public void setUpload(BigDecimal upload) { 
        this.upload=upload;
    }
    public BigDecimal getRfid() { 
        return this.rfid;
    }

    public void setRfid(BigDecimal rfid) { 
        this.rfid=rfid;
    }
    public String getRoleid() { 
        return this.roleid;
    }

    public void setRoleid(String roleid) { 
        this.roleid=roleid;
    }
    public BigDecimal getFunctionId() { 
        return this.functionId;
    }

    public void setFunctionId(BigDecimal functionId) { 
        this.functionId=functionId;
    }
    public BigDecimal getWrite() { 
        return this.write;
    }

    public void setWrite(BigDecimal write) { 
        this.write=write;
    }

	public RmanFunctions getRmanFunctions() {
		return rmanFunctions;
	}

	public void setRmanFunctions(RmanFunctions rmanFunctions) {
		this.rmanFunctions = rmanFunctions;
	}

	public String getEnabledFlag() {
		return enabledFlag;
	}

	public void setEnabledFlag(String enabledFlag) {
		this.enabledFlag = enabledFlag;
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

	public Timestamp getStartDateActive() {
		return startDateActive;
	}

	public void setStartDateActive(Timestamp startDateActive) {
		this.startDateActive = startDateActive;
	}

	public Timestamp getEndDateActive() {
		return endDateActive;
	}

	public void setEndDateActive(Timestamp endDateActive) {
		this.endDateActive = endDateActive;
	}
    

}