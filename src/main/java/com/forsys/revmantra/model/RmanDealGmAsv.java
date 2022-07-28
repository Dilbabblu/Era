package com.forsys.revmantra.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RMAN_DEAL_GM_ASV")
public class RmanDealGmAsv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SNO")
    private BigDecimal sno;

    @Column(name="QTY")
    private BigDecimal qty;

    @Column(name="NET_PRICE")
    private BigDecimal netPrice;

    @Column(name="GROSS_MARGIN")
    private BigDecimal grossMargin;

    @Column(name="ELEMENT_TYPE")
    private String elementType;

    @Column(name="TOTAL_EXPECTED_BOOKINGS")
    private BigDecimal totalExpectedBookings;

    @Column(name="ARRANGEMENT_NAME")
    private String arrangementName;

    @Column(name="SKU")
    private String sku;

    @Column(name="ARRANGEMENT_ID")
    private BigDecimal arrangementId;

    @Column(name="LINE_COST")
    private BigDecimal lineCost;

    @Column(name="ARRG_LINE_NUMBER")
    private BigDecimal arrgLineNumber;
    
    @Column(name="SHIPPED_QTY")
    private BigDecimal shippedQty;
    
    @Column(name="SHIPPED_ALLOCATION")
    private BigDecimal shippedAllocation;
    
    @Column(name="LINE_SHIPMENT_AMOUNT")
    private BigDecimal lineShipmentAmount;
    
    @Column(name="SHIPMENT_LINE_COST")
    private BigDecimal lineShipmentCost;
    
    @Column(name="SHIPMENT_GROSS_MARGIN")
    private BigDecimal shipmentGrossMargin;
    
    

    public BigDecimal getSno() { 
        return this.sno;
    }

    public void setSno(BigDecimal sno) { 
        this.sno=sno;
    }
    public BigDecimal getQty() { 
        return this.qty;
    }

    public void setQty(BigDecimal qty) { 
        this.qty=qty;
    }
    public BigDecimal getNetPrice() { 
        return this.netPrice;
    }

    public void setNetPrice(BigDecimal netPrice) { 
        this.netPrice=netPrice;
    }
    public BigDecimal getGrossMargin() { 
        return this.grossMargin;
    }

    public void setGrossMargin(BigDecimal grossMargin) { 
        this.grossMargin=grossMargin;
    }
    public String getElementType() { 
        return this.elementType;
    }

    public void setElementType(String elementType) { 
        this.elementType=elementType;
    }
    public BigDecimal getTotalExpectedBookings() { 
        return this.totalExpectedBookings;
    }

    public void setTotalExpectedBookings(BigDecimal totalExpectedBookings) { 
        this.totalExpectedBookings=totalExpectedBookings;
    }
    public String getArrangementName() { 
        return this.arrangementName;
    }

    public void setArrangementName(String arrangementName) { 
        this.arrangementName=arrangementName;
    }
    public String getSku() { 
        return this.sku;
    }

    public void setSku(String sku) { 
        this.sku=sku;
    }
    public BigDecimal getArrangementId() { 
        return this.arrangementId;
    }

    public void setArrangementId(BigDecimal arrangementId) { 
        this.arrangementId=arrangementId;
    }
    public BigDecimal getLineCost() { 
        return this.lineCost;
    }

    public void setLineCost(BigDecimal lineCost) { 
        this.lineCost=lineCost;
    }

	public BigDecimal getArrgLineNumber() {
		return arrgLineNumber;
	}

	public void setArrgLineNumber(BigDecimal arrgLineNumber) {
		this.arrgLineNumber = arrgLineNumber;
	}

	public BigDecimal getShippedQty() {
		return shippedQty;
	}

	public void setShippedQty(BigDecimal shippedQty) {
		this.shippedQty = shippedQty;
	}

	public BigDecimal getShippedAllocation() {
		return shippedAllocation;
	}

	public void setShippedAllocation(BigDecimal shippedAllocation) {
		this.shippedAllocation = shippedAllocation;
	}

	public BigDecimal getLineShipmentAmount() {
		return lineShipmentAmount;
	}

	public void setLineShipmentAmount(BigDecimal lineShipmentAmount) {
		this.lineShipmentAmount = lineShipmentAmount;
	}

	public BigDecimal getLineShipmentCost() {
		return lineShipmentCost;
	}

	public void setLineShipmentCost(BigDecimal lineShipmentCost) {
		this.lineShipmentCost = lineShipmentCost;
	}

	public BigDecimal getShipmentGrossMargin() {
		return shipmentGrossMargin;
	}

	public void setShipmentGrossMargin(BigDecimal shipmentGrossMargin) {
		this.shipmentGrossMargin = shipmentGrossMargin;
	}
    
    

}