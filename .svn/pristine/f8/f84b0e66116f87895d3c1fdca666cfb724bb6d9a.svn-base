package com.forsys.revmantra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.forsys.revmantra.listener.AyaraRcPendingApprovalsVListener;
import java.math.BigDecimal;
import java.lang.String;
import java.sql.Timestamp;


@Entity
@EntityListeners(AyaraRcPendingApprovalsVListener.class)
@Table(name="AYARA_RC_PENDING_APPROVALS_V")
public class AyaraRcPendingApprovalsV {

    @Column(name="CREATED_BY")
    private BigDecimal createdBy;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="REVENUE_CONTRACT_NUMBER")
    private BigDecimal revenueContractNumber;

    @Column(name="REVENUE_CONTRACT_AMOUNT")
    private BigDecimal revenueContractAmount;

    @Column(name="DELEGATE_USER")
    private String delegateUser;

    @Column(name="REVENUE_CONTRACT_STATUS")
    private String revenueContractStatus;

    @Column(name="CREATION_DATE")
    private Timestamp creationDate;

    @Column(name="FULL_NAME")
    private String fullName;

    @Column(name="APPROVAL_STATUS")
    private String approvalStatus;

    @Column(name="PROCESS_INSTANCE_ID")
    private String processInstanceId;

    @Column(name="USER_NAME")
    private String userName;

    @Column(name="ORIGINAL_USER")
    private String originalUser;

    @Column(name="TASK_ID")
    private String taskId;



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
    public String getDelegateUser() { 
        return this.delegateUser;
    }

    public void setDelegateUser(String delegateUser) { 
        this.delegateUser=delegateUser;
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
    public String getProcessInstanceId() { 
        return this.processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) { 
        this.processInstanceId=processInstanceId;
    }
    public String getUserName() { 
        return this.userName;
    }

    public void setUserName(String userName) { 
        this.userName=userName;
    }
    public String getOriginalUser() { 
        return this.originalUser;
    }

    public void setOriginalUser(String originalUser) { 
        this.originalUser=originalUser;
    }
    public String getTaskId() { 
        return this.taskId;
    }

    public void setTaskId(String taskId) { 
        this.taskId=taskId;
    }

}