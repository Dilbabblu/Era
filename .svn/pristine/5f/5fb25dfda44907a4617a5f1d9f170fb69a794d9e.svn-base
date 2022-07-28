package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import com.forsys.revmantra.listener.RmanFileUploadJobsListener;


@Entity
@EntityListeners(RmanFileUploadJobsListener.class)
@Table(name="RMAN_FILE_UPLOAD_JOBS")
public class RmanFileUploadJobs {

    @Column(name="ATTRIBUTE3")
    private String attribute3;

    @Column(name="TOTAL_FAILED_RECORDS")
    private BigDecimal totalFailedRecords;

    @Column(name="ATTRIBUTE2")
    private String attribute2;

    @Id
    @Column(name="JOB_ID")
    private String jobId;

    @Column(name="TOTAL_SUCCESS_RECORDS")
    private BigDecimal totalSuccessRecords;

    @Column(name="ATTRIBUTE1")
    private String attribute1;

    @Column(name="TOTAL_PROCESS_RECORDS")
    private BigDecimal totalProcessRecords;

    @Column(name="FINISHED_DATE")
    private Timestamp finishedDate;

    @Column(name="START_DATE")
    private Timestamp startDate;

    @Column(name="JOB_NAME")
    private String jobName;
    
    @Column(name="CREATION_DATE")
    private Timestamp creationDate;
    
    @Column(name="CREATED_BY")
    private BigDecimal createdBY;
    
    @Column(name="LAST_UPDATED_BY")
    private BigDecimal lastUpdatedBy;
    
    @Column(name="LAST_UPDATE_DATE")
    private Timestamp lastUpdateDate;
    
    @Column(name="JOB_STATUS")
    private String jobStatus;
    
    public String getAttribute3() { 
        return this.attribute3;
    }

    public void setAttribute3(String attribute3) { 
        this.attribute3=attribute3;
    }
    public BigDecimal getTotalFailedRecords() { 
        return this.totalFailedRecords;
    }

    public void setTotalFailedRecords(BigDecimal totalFailedRecords) { 
        this.totalFailedRecords=totalFailedRecords;
    }
    public String getAttribute2() { 
        return this.attribute2;
    }

    public void setAttribute2(String attribute2) { 
        this.attribute2=attribute2;
    }
    public String getJobId() { 
        return this.jobId;
    }

    public void setJobId(String jobId) { 
        this.jobId=jobId;
    }
    public BigDecimal getTotalSuccessRecords() { 
        return this.totalSuccessRecords;
    }

    public void setTotalSuccessRecords(BigDecimal totalSuccessRecords) { 
        this.totalSuccessRecords=totalSuccessRecords;
    }
    public String getAttribute1() { 
        return this.attribute1;
    }

    public void setAttribute1(String attribute1) { 
        this.attribute1=attribute1;
    }
    public BigDecimal getTotalProcessRecords() { 
        return this.totalProcessRecords;
    }

    public void setTotalProcessRecords(BigDecimal totalProcessRecords) { 
        this.totalProcessRecords=totalProcessRecords;
    }
    public Timestamp getFinishedDate() { 
        return this.finishedDate;
    }

    public void setFinishedDate(Timestamp finishedDate) { 
        this.finishedDate=finishedDate;
    }
    public Timestamp getStartDate() { 
        return this.startDate;
    }

    public void setStartDate(Timestamp startDate) { 
        this.startDate=startDate;
    }
    public String getJobName() { 
        return this.jobName;
    }

    public void setJobName(String jobName) { 
        this.jobName=jobName;
    }

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public BigDecimal getCreatedBY() {
		return createdBY;
	}

	public void setCreatedBY(BigDecimal createdBY) {
		this.createdBY = createdBY;
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

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
    
    

}