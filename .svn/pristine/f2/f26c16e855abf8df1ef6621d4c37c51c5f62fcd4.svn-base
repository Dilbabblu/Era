package com.forsys.revmantra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.forsys.revmantra.listener.AyaraPendingSubmissionApprovalsVListener;
import java.math.BigDecimal;
import java.lang.String;
import java.sql.Timestamp;


@Entity
@EntityListeners(AyaraPendingSubmissionApprovalsVListener.class)
@Table(name="AYARA_PENDING_SUBMISSION_APPROVALS_V")
public class AyaraPendingSubmissionApprovalsV {

    @Column(name="CREATED_BY")
    private BigDecimal createdBy;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="REVENUE_CONTRACT_NUMBER")
    private BigDecimal revenueContractNumber;

    @Column(name="REVENUE_CONTRACT_AMOUNT")
    private BigDecimal revenueContractAmount;

    @Column(name="REVENUE_CONTRACT_STATUS")
    private String revenueContractStatus;

    @Column(name="CREATION_DATE")
    private Timestamp creationDate;

    @Column(name="FULL_NAME")
    private String fullName;

    @Column(name="APPROVAL_STATUS")
    private String approvalStatus;

    @Column(name="USER_NAME")
    private String userName;



    public BigDecimal getCreatedBy() { 
        return this.createdBy;
    }

    public void setCreatedBy(BigDecimal createdBy) { 
        this.createdBy=createdBy;
    }
    public BigDecimal getRevenueContractNumber() { 
        return this.revenueContractNumber;
    }

    public void setRevenueContractNumber(BigDecimal revenueContractNumber) { 
        this.revenueContractNumber=revenueContractNumber;
    }
    public BigDecimal getRevenueContractAmount() { 
        return this.revenueContractAmount;
    }

    public void setRevenueContractAmount(BigDecimal revenueContractAmount) { 
        this.revenueContractAmount=revenueContractAmount;
    }
    public String getRevenueContractStatus() { 
        return this.revenueContractStatus;
    }

    public void setRevenueContractStatus(String revenueContractStatus) { 
        this.revenueContractStatus=revenueContractStatus;
    }
    public Timestamp getCreationDate() { 
        return this.creationDate;
    }

    public void setCreationDate(Timestamp creationDate) { 
        this.creationDate=creationDate;
    }
    public String getFullName() { 
        return this.fullName;
    }

    public void setFullName(String fullName) { 
        this.fullName=fullName;
    }
    public String getApprovalStatus() { 
        return this.approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) { 
        this.approvalStatus=approvalStatus;
    }
    public String getUserName() { 
        return this.userName;
    }

    public void setUserName(String userName) { 
        this.userName=userName;
    }

}