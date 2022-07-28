package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.forsys.revmantra.listener.RmanResponsibilitiesListener;


@Entity
@EntityListeners(RmanResponsibilitiesListener.class)
@Table(name="RMAN_RESPONSIBILITIES")
public class RmanResponsibilities {

    @Column(name="ATTRIBUTE3")
    private String attribute3;

    @Column(name="CREATED_BY")
    private BigDecimal createdBy;

    @Column(name="ATTRIBUTE2")
    private String attribute2;

    @Column(name="LAST_UPDATED_BY")
    private BigDecimal lastUpdatedBy;

    @Column(name="START_DATE_ACTIVE")
    private Timestamp startDateActive;

    @Column(name="ATTRIBUTE1")
    private String attribute1;

    @Column(name="CREATION_DATE")
    private Timestamp creationDate;

    @Column(name="LAST_UPDATE_DATE")
    private Timestamp lastUpdateDate;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RMAN_RESPONSIBILITIES_seq_gen")
    @SequenceGenerator(name="RMAN_RESPONSIBILITIES_seq_gen", sequenceName="RMAN_RESPONSIBILITIES_S", allocationSize=1)
    @Column(name="RESPONSIBILITY_ID")
    private BigDecimal responsibilityId;

    @Column(name="RESPONSIBILITY_NAME")
    private String responsibilityName;

    @Column(name="ATTRIBUTE5")
    private String attribute5;

    @Column(name="ATTRIBUTE4")
    private String attribute4;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="END_DATE_ACTIVE")
    private Timestamp endDateActive;
    
    @Column(name = "ENABLED_FLAG")
	private String enabledFlag;  
    
    @Column(name = "CREATED_USER")
	private String createdUser;
	
	@Column(name = "UPDATED_USER")
	private String updatedUser;
	
    
    
    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="ROLEID",insertable=false,updatable=false,referencedColumnName="RESPONSIBILITY_ID")
    Set<RmanRoleFunctions> rmanRoleFunctions;
     
    
    

	public Set<RmanRoleFunctions> getRmanRoleFunctions() {
		return rmanRoleFunctions;
	}

	public void setRmanRoleFunctions(Set<RmanRoleFunctions> rmanRoleFunctions) {
		this.rmanRoleFunctions = rmanRoleFunctions;
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
    public Timestamp getStartDateActive() { 
        return this.startDateActive;
    }

    public void setStartDateActive(Timestamp startDateActive) { 
        this.startDateActive=startDateActive;
    }
    public String getAttribute1() { 
        return this.attribute1;
    }

    public void setAttribute1(String attribute1) { 
        this.attribute1=attribute1;
    }
    public Timestamp getCreationDate() { 
        return this.creationDate;
    }

    public void setCreationDate(Timestamp creationDate) { 
        this.creationDate=creationDate;
    }
    public Timestamp getLastUpdateDate() { 
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) { 
        this.lastUpdateDate=lastUpdateDate;
    }
    public BigDecimal getResponsibilityId() { 
        return this.responsibilityId;
    }

    public void setResponsibilityId(BigDecimal responsibilityId) { 
        this.responsibilityId=responsibilityId;
    }
    public String getResponsibilityName() { 
        return this.responsibilityName;
    }

    public void setResponsibilityName(String responsibilityName) { 
        this.responsibilityName=responsibilityName;
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
    public String getDescription() { 
        return this.description;
    }

    public void setDescription(String description) { 
        this.description=description;
    }
    public Timestamp getEndDateActive() { 
        return this.endDateActive;
    }

    public void setEndDateActive(Timestamp endDateActive) { 
        this.endDateActive=endDateActive;
    }

	public String getEnabledFlag() {
		return enabledFlag;
	}

	public void setEnabledFlag(String enabledFlag) {
		this.enabledFlag = enabledFlag;
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
    
    

}