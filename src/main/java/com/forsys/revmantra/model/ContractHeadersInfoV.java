package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="CONTRACT_HEADERS_INFO_V")
public class ContractHeadersInfoV {

    @Column(name="AGREEMENT_NAME")
    private String agreementName;

    @Column(name="END_CUSTOMER_NAME")
    private String endCustomerName;

    @Column(name="ADDITIONAL_INFO1")
    private String additionalInfo1;
    
    @Column(name="ADDITIONAL_INFO2")
    private String additionalInfo2;

    @Column(name="CREATED_DATE")
    private Timestamp createdDate;

    @Column(name="PRICE_LIST")
    private String priceList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DEAL_HEADER_ID")
    private BigDecimal dealHeaderId;

    @Column(name="DEAL_AMOUNT")
    private BigDecimal dealAmount;

    @Column(name="DEAL_TYPE")
    private String dealType;

    @Column(name="SALES_CHANNEL")
    private String salesChannel;

    @Column(name="DEAL_ARRANGEMENT_ID")
    private BigDecimal dealArrangementId;

    @Column(name="DEAL_STATUS")
    private String dealStatus;

    @Column(name="AGREEMENT_NUMBER")
    private String agreementNumber;

    @Column(name="BILL_TO_COUNTRY")
    private String billToCountry;

    @Column(name="OPPORTUNITY_NUM")
    private String opportunityNum;

    @Column(name="DEAL_CURRENCY_CODE")
    private String dealCurrencyCode;

    @Column(name="OPPORTUNITY_NAME")
    private String opportunityName;

    @Column(name="END_CUSTOMER_NUM")
    private String endCustomerNum;

    @Column(name="SHIP_TO_COUNTRY")
    private String shipToCountry;

    @Column(name="DEAL_NUMBER")
    private String dealNumber;

    @Column(name="BILL_TO_CUSTOMER_NAME")
    private String billToCustomerName;

    @Column(name="DEAL_NAME")
    private String dealName;

    @Column(name="GROUPING_RULE_CATEGORY")
    private String groupingRuleCategory;
    
    @Column(name="GROUPING_RULE_NAME")
    private String groupingRuleName;
    
    @Column(name="PO")
    private String po;

    public String getGroupingRuleCategory() {
		return groupingRuleCategory;
	}

	public void setGroupingRuleCategory(String groupingRuleCategory) {
		this.groupingRuleCategory = groupingRuleCategory;
	}

	public String getGroupingRuleName() {
		return groupingRuleName;
	}

	public void setGroupingRuleName(String groupingRuleName) {
		this.groupingRuleName = groupingRuleName;
	}

	public String getPo() {
		return po;
	}

	public void setPo(String po) {
		this.po = po;
	}

	public String getAgreementName() { 
        return this.agreementName;
    }

    public void setAgreementName(String agreementName) { 
        this.agreementName=agreementName;
    }
    public String getEndCustomerName() { 
        return this.endCustomerName;
    }

    public void setEndCustomerName(String endCustomerName) { 
        this.endCustomerName=endCustomerName;
    }
    public String getAdditionalInfo1() { 
        return this.additionalInfo1;
    }

    public void setAdditionalInfo1(String additionalInfo1) { 
        this.additionalInfo1=additionalInfo1;
    }
    public String getAdditionalInfo2() { 
        return this.additionalInfo2;
    }

    public void setAdditionalInfo2(String additionalInfo2) { 
        this.additionalInfo2=additionalInfo2;
    }
    public Timestamp getCreatedDate() { 
        return this.createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) { 
        this.createdDate=createdDate;
    }
    public String getPriceList() { 
        return this.priceList;
    }

    public void setPriceList(String priceList) { 
        this.priceList=priceList;
    }
    public BigDecimal getDealHeaderId() { 
        return this.dealHeaderId;
    }

    public void setDealHeaderId(BigDecimal dealHeaderId) { 
        this.dealHeaderId=dealHeaderId;
    }
    public BigDecimal getDealAmount() { 
        return this.dealAmount;
    }

    public void setDealAmount(BigDecimal dealAmount) { 
        this.dealAmount=dealAmount;
    }
    public String getDealType() { 
        return this.dealType;
    }

    public void setDealType(String dealType) { 
        this.dealType=dealType;
    }
    public String getSalesChannel() { 
        return this.salesChannel;
    }

    public void setSalesChannel(String salesChannel) { 
        this.salesChannel=salesChannel;
    }
    public BigDecimal getDealArrangementId() { 
        return this.dealArrangementId;
    }

    public void setDealArrangementId(BigDecimal dealArrangementId) { 
        this.dealArrangementId=dealArrangementId;
    }
    public String getDealStatus() { 
        return this.dealStatus;
    }

    public void setDealStatus(String dealStatus) { 
        this.dealStatus=dealStatus;
    }
    public String getAgreementNumber() { 
        return this.agreementNumber;
    }

    public void setAgreementNumber(String agreementNumber) { 
        this.agreementNumber=agreementNumber;
    }
    public String getBillToCountry() { 
        return this.billToCountry;
    }

    public void setBillToCountry(String billToCountry) { 
        this.billToCountry=billToCountry;
    }
    public String getOpportunityNum() { 
        return this.opportunityNum;
    }

    public void setOpportunityNum(String opportunityNum) { 
        this.opportunityNum=opportunityNum;
    }
    public String getDealCurrencyCode() { 
        return this.dealCurrencyCode;
    }

    public void setDealCurrencyCode(String dealCurrencyCode) { 
        this.dealCurrencyCode=dealCurrencyCode;
    }
    public String getOpportunityName() { 
        return this.opportunityName;
    }

    public void setOpportunityName(String opportunityName) { 
        this.opportunityName=opportunityName;
    }
    public String getEndCustomerNum() { 
        return this.endCustomerNum;
    }

    public void setEndCustomerNum(String endCustomerNum) { 
        this.endCustomerNum=endCustomerNum;
    }
    public String getShipToCountry() { 
        return this.shipToCountry;
    }

    public void setShipToCountry(String shipToCountry) { 
        this.shipToCountry=shipToCountry;
    }
    public String getDealNumber() { 
        return this.dealNumber;
    }

    public void setDealNumber(String dealNumber) { 
        this.dealNumber=dealNumber;
    }
    public String getBillToCustomerName() { 
        return this.billToCustomerName;
    }

    public void setBillToCustomerName(String billToCustomerName) { 
        this.billToCustomerName=billToCustomerName;
    }
    public String getDealName() { 
        return this.dealName;
    }

    public void setDealName(String dealName) { 
        this.dealName=dealName;
    }

}