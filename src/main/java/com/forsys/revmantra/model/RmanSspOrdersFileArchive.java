package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_SSP_ORDERS_FILE_ARCHIVE")
public class RmanSspOrdersFileArchive {

    @Column(name="LOCATION")
    private String location;

    @Column(name="CREATED_BY")
    private BigDecimal createdBy;

    @Column(name="CREATION_DATE")
    private Timestamp creationDate;

    @Column(name="ORDER_TYPE")
    private String orderType;

    @Column(name="CUSTOMER_PO_NUM")
    private String customerPoNum;

    @Column(name="PRODUCT_NAME")
    private String productName;

    @Column(name="BOOKED_DATE")
    private Timestamp bookedDate;

    @Column(name="BILL_TO_CUSTOMER_NUMBER")
    private String billToCustomerNumber;

    @Column(name="FILE_NAME")
    private String fileName;

    @Column(name="GROUP_ID")
    private String groupId;

    @Column(name="SERVICE_END_DATE")
    private Timestamp serviceEndDate;

    @Column(name="PERIOD_NAME")
    private String periodName;

    @Column(name="NET_DISCOUNT")
    private BigDecimal netDiscount;

    @Id
    @Column(name="SNO")
    private BigDecimal sno;

    @Column(name="UNIT_SELLING_PRICE")
    private BigDecimal unitSellingPrice;

    @Column(name="EXTENDED_SELLING_AMOUNT")
    private BigDecimal extendedSellingAmount;

    @Column(name="UNIT_LIST_PRICE")
    private BigDecimal unitListPrice;

    @Column(name="ORDERED_QUANTITY")
    private BigDecimal orderedQuantity;

    @Column(name="SERVICE_START_DATE")
    private Timestamp serviceStartDate;

    @Column(name="PROCESSED_DATE")
    private Timestamp processedDate;

    @Column(name="BILL_TO_CUSTOMER")
    private String billToCustomer;



    public String getLocation() { 
        return this.location;
    }

    public void setLocation(String location) { 
        this.location=location;
    }
    public BigDecimal getCreatedBy() { 
        return this.createdBy;
    }

    public void setCreatedBy(BigDecimal createdBy) { 
        this.createdBy=createdBy;
    }
    public Timestamp getCreationDate() { 
        return this.creationDate;
    }

    public void setCreationDate(Timestamp creationDate) { 
        this.creationDate=creationDate;
    }
    public String getOrderType() { 
        return this.orderType;
    }

    public void setOrderType(String orderType) { 
        this.orderType=orderType;
    }
    public String getCustomerPoNum() { 
        return this.customerPoNum;
    }

    public void setCustomerPoNum(String customerPoNum) { 
        this.customerPoNum=customerPoNum;
    }
    public String getProductName() { 
        return this.productName;
    }

    public void setProductName(String productName) { 
        this.productName=productName;
    }
    public Timestamp getBookedDate() { 
        return this.bookedDate;
    }

    public void setBookedDate(Timestamp bookedDate) { 
        this.bookedDate=bookedDate;
    }
    public String getBillToCustomerNumber() { 
        return this.billToCustomerNumber;
    }

    public void setBillToCustomerNumber(String billToCustomerNumber) { 
        this.billToCustomerNumber=billToCustomerNumber;
    }
    public String getFileName() { 
        return this.fileName;
    }

    public void setFileName(String fileName) { 
        this.fileName=fileName;
    }
    public String getGroupId() { 
        return this.groupId;
    }

    public void setGroupId(String groupId) { 
        this.groupId=groupId;
    }
    public Timestamp getServiceEndDate() { 
        return this.serviceEndDate;
    }

    public void setServiceEndDate(Timestamp serviceEndDate) { 
        this.serviceEndDate=serviceEndDate;
    }
    public String getPeriodName() { 
        return this.periodName;
    }

    public void setPeriodName(String periodName) { 
        this.periodName=periodName;
    }
    public BigDecimal getNetDiscount() { 
        return this.netDiscount;
    }

    public void setNetDiscount(BigDecimal netDiscount) { 
        this.netDiscount=netDiscount;
    }
    public BigDecimal getSno() { 
        return this.sno;
    }

    public void setSno(BigDecimal sno) { 
        this.sno=sno;
    }
    public BigDecimal getUnitSellingPrice() { 
        return this.unitSellingPrice;
    }

    public void setUnitSellingPrice(BigDecimal unitSellingPrice) { 
        this.unitSellingPrice=unitSellingPrice;
    }
    public BigDecimal getExtendedSellingAmount() { 
        return this.extendedSellingAmount;
    }

    public void setExtendedSellingAmount(BigDecimal extendedSellingAmount) { 
        this.extendedSellingAmount=extendedSellingAmount;
    }
    public BigDecimal getUnitListPrice() { 
        return this.unitListPrice;
    }

    public void setUnitListPrice(BigDecimal unitListPrice) { 
        this.unitListPrice=unitListPrice;
    }
    public BigDecimal getOrderedQuantity() { 
        return this.orderedQuantity;
    }

    public void setOrderedQuantity(BigDecimal orderedQuantity) { 
        this.orderedQuantity=orderedQuantity;
    }
    public Timestamp getServiceStartDate() { 
        return this.serviceStartDate;
    }

    public void setServiceStartDate(Timestamp serviceStartDate) { 
        this.serviceStartDate=serviceStartDate;
    }
    public Timestamp getProcessedDate() { 
        return this.processedDate;
    }

    public void setProcessedDate(Timestamp processedDate) { 
        this.processedDate=processedDate;
    }
    public String getBillToCustomer() { 
        return this.billToCustomer;
    }

    public void setBillToCustomer(String billToCustomer) { 
        this.billToCustomer=billToCustomer;
    }

}