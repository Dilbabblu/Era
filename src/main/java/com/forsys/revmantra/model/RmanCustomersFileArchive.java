package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_CUSTOMERS_FILE_ARCHIVE")
public class RmanCustomersFileArchive {

    @Column(name="CREATED_BY")
    private BigDecimal createdBy;

    @Column(name="STATUS")
    private String status;

    @Column(name="CUSTOMER_NAME")
    private String customerName;

    @Column(name="CUSTOMER_NUMBER")
    private String customerNumber;

    @Id
    @Column(name="SNO")
    private BigDecimal sno;

    @Column(name="CUSTOMER_ID")
    private BigDecimal customerId;

    @Column(name="CREATION_DATE")
    private Timestamp creationDate;

    @Column(name="FILE_NAME")
    private String fileName;

    @Column(name="PROCESS_ID")
    private String processId;



    public BigDecimal getCreatedBy() { 
        return this.createdBy;
    }

    public void setCreatedBy(BigDecimal createdBy) { 
        this.createdBy=createdBy;
    }
    public String getStatus() { 
        return this.status;
    }

    public void setStatus(String status) { 
        this.status=status;
    }
    public String getCustomerName() { 
        return this.customerName;
    }

    public void setCustomerName(String customerName) { 
        this.customerName=customerName;
    }
    public String getCustomerNumber() { 
        return this.customerNumber;
    }

    public void setCustomerNumber(String customerNumber) { 
        this.customerNumber=customerNumber;
    }
    public BigDecimal getSno() { 
        return this.sno;
    }

    public void setSno(BigDecimal sno) { 
        this.sno=sno;
    }
    public BigDecimal getCustomerId() { 
        return this.customerId;
    }

    public void setCustomerId(BigDecimal customerId) { 
        this.customerId=customerId;
    }
    public Timestamp getCreationDate() { 
        return this.creationDate;
    }

    public void setCreationDate(Timestamp creationDate) { 
        this.creationDate=creationDate;
    }
    public String getFileName() { 
        return this.fileName;
    }

    public void setFileName(String fileName) { 
        this.fileName=fileName;
    }
    public String getProcessId() { 
        return this.processId;
    }

    public void setProcessId(String processId) { 
        this.processId=processId;
    }

}