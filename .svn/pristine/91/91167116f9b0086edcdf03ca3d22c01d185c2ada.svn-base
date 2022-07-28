package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_CONT_PROD_NAME_LOV_V")
public class RmanContProdNameLovV {

    @Column(name="PRODUCT_TYPE")
    private String productType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SNO")
    private BigDecimal sno;

    @Column(name="PRODUCT_CATEGORY")
    private String productCategory;

    @Column(name="ELEMENT_TYPE")
    private String elementType;

    @Column(name="PRODUCT_NAME")
    private String productName;

    @Column(name="DEAL_ARRANGEMENT_ID")
    private BigDecimal dealArrangementId;



    public String getProductType() { 
        return this.productType;
    }

    public void setProductType(String productType) { 
        this.productType=productType;
    }
    public BigDecimal getSno() { 
        return this.sno;
    }

    public void setSno(BigDecimal sno) { 
        this.sno=sno;
    }
    public String getProductCategory() { 
        return this.productCategory;
    }

    public void setProductCategory(String productCategory) { 
        this.productCategory=productCategory;
    }
    public String getElementType() { 
        return this.elementType;
    }

    public void setElementType(String elementType) { 
        this.elementType=elementType;
    }
    public String getProductName() { 
        return this.productName;
    }

    public void setProductName(String productName) { 
        this.productName=productName;
    }
    public BigDecimal getDealArrangementId() { 
        return this.dealArrangementId;
    }

    public void setDealArrangementId(BigDecimal dealArrangementId) { 
        this.dealArrangementId=dealArrangementId;
    }

}