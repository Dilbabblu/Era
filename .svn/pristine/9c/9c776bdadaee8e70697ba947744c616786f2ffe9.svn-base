package com.forsys.revmantra.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import com.forsys.revmantra.listener.RmanForecastingDetailsListener;


@Entity
@EntityListeners(RmanForecastingDetailsListener.class)
@Table(name="RMAN_FORECASTING_DETAILS_V")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "populate_fc_details_proc", 
    procedureName = "RMAN_FC_PACKAGE.POPULATE_FC_DETAILS",
    parameters = {
       @StoredProcedureParameter(mode = ParameterMode.IN, name = "arrId", type = BigDecimal.class),
       @StoredProcedureParameter(mode = ParameterMode.IN, name = "fcLevel", type = BigDecimal.class),
       @StoredProcedureParameter(mode = ParameterMode.IN, name = "fcBucket", type = BigDecimal.class),
       @StoredProcedureParameter(mode = ParameterMode.IN, name = "fcMethod", type = BigDecimal.class),
       @StoredProcedureParameter(mode = ParameterMode.IN, name = "fcStartDate", type = Timestamp.class),
       @StoredProcedureParameter(mode = ParameterMode.IN, name = "fcAllocFlag", type = String.class)
    }),
    @NamedStoredProcedureQuery(name = "save_fc_distributions_proc", 
    procedureName = "RMAN_FC_PACKAGE.POPULATE_FC_DISTRIBUTIONS",
    parameters = {
       @StoredProcedureParameter(mode = ParameterMode.IN, name = "arrId", type = BigDecimal.class),
       @StoredProcedureParameter(mode = ParameterMode.IN, name = "fcLevel", type = BigDecimal.class),
       @StoredProcedureParameter(mode = ParameterMode.IN, name = "fcBucket", type = BigDecimal.class),
       @StoredProcedureParameter(mode = ParameterMode.IN, name = "fcMethod", type = BigDecimal.class),
       @StoredProcedureParameter(mode = ParameterMode.IN, name = "fcStartDate", type = Timestamp.class),
       @StoredProcedureParameter(mode = ParameterMode.IN, name = "fcAllocFlag", type = String.class)
    })
})
public class RmanForecastingDetails {
    
    @Id
    @Column(name="KEY")
    private String key;

    
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Column(name="ARRANGEMENT_ID")
    private BigDecimal arrangementId;
    
    @Column(name="LEVEL1_NAME")
    private String level1Name;
    
    @Column(name="LEVEL2_NAME")
    private String level2Name;
    
    public BigDecimal getArrangementId() {
        return arrangementId;
    }

    public void setArrangementId(BigDecimal arrangementId) {
        this.arrangementId = arrangementId;
    }

    public String getLevel1Name() {
        return level1Name;
    }

    public void setLevel1Name(String level1Name) {
        this.level1Name = level1Name;
    }

    public String getLevel2Name() {
        return level2Name;
    }

    public void setLevel2Name(String level2Name) {
        this.level2Name = level2Name;
    }

    public String getLevel3Name() {
        return level3Name;
    }

    public void setLevel3Name(String level3Name) {
        this.level3Name = level3Name;
    }

    public String getLevel4Name() {
        return level4Name;
    }

    public void setLevel4Name(String level4Name) {
        this.level4Name = level4Name;
    }

    public String getLevel5Name() {
        return level5Name;
    }

    public void setLevel5Name(String level5Name) {
        this.level5Name = level5Name;
    }

    @Column(name="LEVEL3_NAME")
    private String level3Name;

    @Column(name="LEVEL4_NAME")
    private String level4Name;

    @Column(name="LEVEL5_NAME")
    private String level5Name;

    @Column(name="BUCKET18")
    private BigDecimal bucket18;

    @Column(name="APPLY_CONTINGENCIES")
    private String applyContingencies;

    @Column(name="BUCKET17")
    private BigDecimal bucket17;

    @Column(name="CREATED_DATE")
    private Timestamp createdDate;

    @Column(name="BUCKET9_PERIOD")
    private String bucket9Period;

    @Column(name="BUCKET3_PERIOD")
    private String bucket3Period;

    @Column(name="BUCKET4_PERIOD")
    private String bucket4Period;

    @Column(name="BUCKET5_PERIOD")
    private String bucket5Period;

    @Column(name="BUCKET6_PERIOD")
    private String bucket6Period;

    @Column(name="BUCKET7_PERIOD")
    private String bucket7Period;

    @Column(name="BUCKET8_PERIOD")
    private String bucket8Period;

    @Column(name="BUCKET19")
    private BigDecimal bucket19;

    
    @Column(name="FUTURE")
    private BigDecimal future;

    @Column(name="PRODUCT_ORG_ID")
    private BigDecimal productOrgId;

    @Column(name="BUCKET1_PERIOD")
    private String bucket1Period;

    @Column(name="AMOUNT")
    private BigDecimal amount;

    @Column(name="BUCKET2_PERIOD")
    private String bucket2Period;

    @Column(name="BUCKET14")
    private BigDecimal bucket14;

    @Column(name="BUCKET13")
    private BigDecimal bucket13;

    @Column(name="EXPECTED_START_DATE")
    private Timestamp expectedStartDate;

    @Column(name="LEVEL5_VALUE")
    private BigDecimal level5Value;

    @Column(name="BUCKET16")
    private BigDecimal bucket16;

    @Column(name="BUCKET15")
    private BigDecimal bucket15;

    @Column(name="BUCKET10")
    private BigDecimal bucket10;

    @Column(name="TYPE")
    private String type;

    @Column(name="BUCKET12")
    private BigDecimal bucket12;

    @Column(name="BUCKET11")
    private BigDecimal bucket11;

    @Column(name="CREATED_BY")
    private BigDecimal createdBy;

    @Column(name="LAST_UPDATED_BY")
    private BigDecimal lastUpdatedBy;

    @Column(name="BUCKET18_PERIOD")
    private String bucket18Period;

   

    @Column(name="BUCKET4")
    private BigDecimal bucket4;

    @Column(name="LEVEL4_VALUE")
    private BigDecimal level4Value;

    
    @Column(name="BUCKET5")
    private BigDecimal bucket5;

    @Column(name="BUCKET21_PERIOD")
    private String bucket21Period;

    @Column(name="BUCKET2")
    private BigDecimal bucket2;

    @Column(name="BUCKET3")
    private BigDecimal bucket3;

    @Column(name="BUCKET8")
    private BigDecimal bucket8;

    @Column(name="BUCKET9")
    private BigDecimal bucket9;

    @Column(name="APPLY_ALLOCATIONS")
    private String applyAllocations;

   
    @Column(name="BUCKET6")
    private BigDecimal bucket6;

    @Column(name="BUCKET12_PERIOD")
    private String bucket12Period;

    @Column(name="BUCKET14_PERIOD")
    private String bucket14Period;

    @Column(name="BUCKET16_PERIOD")
    private String bucket16Period;

    @Column(name="BUCKET7")
    private BigDecimal bucket7;

    @Column(name="BUCKET10_PERIOD")
    private String bucket10Period;

    @Column(name="BUCKET24")
    private BigDecimal bucket24;

    @Column(name="BUCKET21")
    private BigDecimal bucket21;

    @Column(name="BUCKET1")
    private BigDecimal bucket1;

    @Column(name="BUCKET20")
    private BigDecimal bucket20;

    @Column(name="BUCKET23_PERIOD")
    private String bucket23Period;

    @Column(name="BUCKET23")
    private BigDecimal bucket23;

    @Column(name="LEVEL1_VALUE")
    private BigDecimal level1Value;

    @Column(name="BUCKET22")
    private BigDecimal bucket22;

    @Column(name="FC_BUCKET_ID")
    private BigDecimal fcBucketId;

    @Column(name="REMAINING_AMOUNT")
    private BigDecimal remainingAmount;

    
    @Column(name="FC_CURRENCY")
    private String fcCurrency;

    @Column(name="FC_CONVERSION_TYPE")
    private String fcConversionType;

    @Column(name="LEVEL3_VALUE")
    private BigDecimal level3Value;

    @Column(name="REMAINING_FUTURE_FLAG")
    private String remainingFutureFlag;

    @Column(name="ARRANGEMENT_NAME")
    private String arrangementName;

    @Column(name="FC_START_DATE")
    private Timestamp fcStartDate;

    @Column(name="FC_METHOD_ID")
    private BigDecimal fcMethodId;

    @Column(name="EXPECTED_SPLIT")
    private BigDecimal expectedSplit;

    
    @Column(name="BUCKET19_PERIOD")
    private String bucket19Period;

    @Column(name="LEVEL2_VALUE")
    private BigDecimal level2Value;

    @Column(name="EXPECTED_DURATION")
    private BigDecimal expectedDuration;

    @Column(name="MASTER_ARRANGEMENT_ID")
    private BigDecimal masterArrangementId;

    @Column(name="BUCKET_TYPE")
    private String bucketType;

    @Column(name="BUCKET13_PERIOD")
    private String bucket13Period;

    @Column(name="LAST_UPDATED_DATE")
    private Timestamp lastUpdatedDate;

    @Column(name="BUCKET22_PERIOD")
    private String bucket22Period;

    @Column(name="SHIPMENT_DELAY")
    private BigDecimal shipmentDelay;

    @Column(name="CUSTOMER_NAME")
    private String customerName;

    @Column(name="BUCKET11_PERIOD")
    private String bucket11Period;

    @Column(name="BUCKET15_PERIOD")
    private String bucket15Period;

    @Column(name="INOVICE_DELAY")
    private BigDecimal inoviceDelay;

    @Column(name="EXPECTED_END_DATE")
    private Timestamp expectedEndDate;

    @Column(name="BOOKING_DELAY")
    private BigDecimal bookingDelay;

    @Column(name="BUCKET17_PERIOD")
    private String bucket17Period;

    @Column(name="FC_LEVEL_NAME")
    private String fcLevelName;

    @Column(name="BUCKET20_PERIOD")
    private String bucket20Period;

    @Column(name="BUCKET24_PERIOD")
    private String bucket24Period;
    
    

/** @OneToOne(fetch = FetchType.EAGER)
 @JoinColumn(name="FC_CURRENCY",insertable = false, updatable = false )
    private RmanCurrency rmanCurrency;
 @OneToOne(fetch = FetchType.EAGER)
 @JoinColumn(name="FC_CONVERSION_TYPE",insertable = false, updatable = false )
    private RmanFcConversionTypes rmanFcConversionTypes;
 @OneToOne(fetch = FetchType.EAGER)
 @JoinColumn(name="FC_BUCKET_ID",insertable = false, updatable = false )
    private RmanFcBuckets rmanFcBuckets;
 @OneToOne(fetch = FetchType.EAGER)
 @JoinColumn(name="FC_LEVEL_NAME",insertable = false, updatable = false )
    private RmanFcLevel rmanFcLevel;
 @OneToOne(fetch = FetchType.EAGER)
 @JoinColumn(name="APPLY_CONTINGENCIES",insertable = false, updatable = false )
    private RmanLookupsV rmanLookupsV;
 @OneToOne(fetch = FetchType.EAGER)
 @JoinColumn(name="APPLY_ALLOCATIONS",insertable = false, updatable = false )
    private RmanLookupsV rmanLookupsV1;*/
 @OneToOne(fetch = FetchType.EAGER)
 @JoinColumn(name="FC_METHOD_ID",insertable = false, updatable = false )
private RmanFcMethods rmanFcMethods;

    /**@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ARRANGEMENT_ID",insertable = false, updatable = false )
    private RmanDealArrangements rmanDealArrangements;

    
    public RmanDealArrangements getRmanDealArrangements() {
        return rmanDealArrangements;
    }

    public void setRmanDealArrangements(RmanDealArrangements rmanDealArrangements) {
        this.rmanDealArrangements = rmanDealArrangements;
    }*/

    public BigDecimal getBucket18() { 
        return this.bucket18;
    }

    public void setBucket18(BigDecimal bucket18) { 
        this.bucket18=bucket18;
    }
    public String getApplyContingencies() { 
        return this.applyContingencies;
    }

    public void setApplyContingencies(String applyContingencies) { 
        this.applyContingencies=applyContingencies;
    }
    public BigDecimal getBucket17() { 
        return this.bucket17;
    }

    public void setBucket17(BigDecimal bucket17) { 
        this.bucket17=bucket17;
    }
    public Timestamp getCreatedDate() { 
        return this.createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) { 
        this.createdDate=createdDate;
    }
    public String getBucket9Period() { 
        return this.bucket9Period;
    }

    public void setBucket9Period(String bucket9Period) { 
        this.bucket9Period=bucket9Period;
    }
    public String getBucket3Period() { 
        return this.bucket3Period;
    }

    public void setBucket3Period(String bucket3Period) { 
        this.bucket3Period=bucket3Period;
    }
    public String getBucket4Period() { 
        return this.bucket4Period;
    }

    public void setBucket4Period(String bucket4Period) { 
        this.bucket4Period=bucket4Period;
    }
    public String getBucket5Period() { 
        return this.bucket5Period;
    }

    public void setBucket5Period(String bucket5Period) { 
        this.bucket5Period=bucket5Period;
    }
    public String getBucket6Period() { 
        return this.bucket6Period;
    }

    public void setBucket6Period(String bucket6Period) { 
        this.bucket6Period=bucket6Period;
    }
    public String getBucket7Period() { 
        return this.bucket7Period;
    }

    public void setBucket7Period(String bucket7Period) { 
        this.bucket7Period=bucket7Period;
    }
    public String getBucket8Period() { 
        return this.bucket8Period;
    }

    public void setBucket8Period(String bucket8Period) { 
        this.bucket8Period=bucket8Period;
    }
    public BigDecimal getBucket19() { 
        return this.bucket19;
    }

    public void setBucket19(BigDecimal bucket19) { 
        this.bucket19=bucket19;
    }
    
    public BigDecimal getFuture() { 
        return this.future;
    }

    public void setFuture(BigDecimal future) { 
        this.future=future;
    }
    public BigDecimal getProductOrgId() { 
        return this.productOrgId;
    }

    public void setProductOrgId(BigDecimal productOrgId) { 
        this.productOrgId=productOrgId;
    }
    public String getBucket1Period() { 
        return this.bucket1Period;
    }

    public void setBucket1Period(String bucket1Period) { 
        this.bucket1Period=bucket1Period;
    }
    public BigDecimal getAmount() { 
        return this.amount;
    }

    public void setAmount(BigDecimal amount) { 
        this.amount=amount;
    }
    public String getBucket2Period() { 
        return this.bucket2Period;
    }

    public void setBucket2Period(String bucket2Period) { 
        this.bucket2Period=bucket2Period;
    }
    public BigDecimal getBucket14() { 
        return this.bucket14;
    }

    public void setBucket14(BigDecimal bucket14) { 
        this.bucket14=bucket14;
    }
    public BigDecimal getBucket13() { 
        return this.bucket13;
    }

    public void setBucket13(BigDecimal bucket13) { 
        this.bucket13=bucket13;
    }
    public Timestamp getExpectedStartDate() { 
        return this.expectedStartDate;
    }

    public void setExpectedStartDate(Timestamp expectedStartDate) { 
        this.expectedStartDate=expectedStartDate;
    }
    public BigDecimal getLevel5Value() { 
        return this.level5Value;
    }

    public void setLevel5Value(BigDecimal level5Value) { 
        this.level5Value=level5Value;
    }
    public BigDecimal getBucket16() { 
        return this.bucket16;
    }

    public void setBucket16(BigDecimal bucket16) { 
        this.bucket16=bucket16;
    }
    public BigDecimal getBucket15() { 
        return this.bucket15;
    }

    public void setBucket15(BigDecimal bucket15) { 
        this.bucket15=bucket15;
    }
    public BigDecimal getBucket10() { 
        return this.bucket10;
    }

    public void setBucket10(BigDecimal bucket10) { 
        this.bucket10=bucket10;
    }
    public String getType() { 
        return this.type;
    }

    public void setType(String type) { 
        this.type=type;
    }
    public BigDecimal getBucket12() { 
        return this.bucket12;
    }

    public void setBucket12(BigDecimal bucket12) { 
        this.bucket12=bucket12;
    }
    public BigDecimal getBucket11() { 
        return this.bucket11;
    }

    public void setBucket11(BigDecimal bucket11) { 
        this.bucket11=bucket11;
    }
    public BigDecimal getCreatedBy() { 
        return this.createdBy;
    }

    public void setCreatedBy(BigDecimal createdBy) { 
        this.createdBy=createdBy;
    }
    public BigDecimal getLastUpdatedBy() { 
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(BigDecimal lastUpdatedBy) { 
        this.lastUpdatedBy=lastUpdatedBy;
    }
    public String getBucket18Period() { 
        return this.bucket18Period;
    }

    public void setBucket18Period(String bucket18Period) { 
        this.bucket18Period=bucket18Period;
    }
   
    public BigDecimal getBucket4() { 
        return this.bucket4;
    }

    public void setBucket4(BigDecimal bucket4) { 
        this.bucket4=bucket4;
    }
    public BigDecimal getLevel4Value() { 
        return this.level4Value;
    }

    public void setLevel4Value(BigDecimal level4Value) { 
        this.level4Value=level4Value;
    }
    
    public BigDecimal getBucket5() { 
        return this.bucket5;
    }

    public void setBucket5(BigDecimal bucket5) { 
        this.bucket5=bucket5;
    }
    public String getBucket21Period() { 
        return this.bucket21Period;
    }

    public void setBucket21Period(String bucket21Period) { 
        this.bucket21Period=bucket21Period;
    }
    public BigDecimal getBucket2() { 
        return this.bucket2;
    }

    public void setBucket2(BigDecimal bucket2) { 
        this.bucket2=bucket2;
    }
    public BigDecimal getBucket3() { 
        return this.bucket3;
    }

    public void setBucket3(BigDecimal bucket3) { 
        this.bucket3=bucket3;
    }
    public BigDecimal getBucket8() { 
        return this.bucket8;
    }

    public void setBucket8(BigDecimal bucket8) { 
        this.bucket8=bucket8;
    }
    public BigDecimal getBucket9() { 
        return this.bucket9;
    }

    public void setBucket9(BigDecimal bucket9) { 
        this.bucket9=bucket9;
    }
    public String getApplyAllocations() { 
        return this.applyAllocations;
    }

    public void setApplyAllocations(String applyAllocations) { 
        this.applyAllocations=applyAllocations;
    }
    
    public BigDecimal getBucket6() { 
        return this.bucket6;
    }

    public void setBucket6(BigDecimal bucket6) { 
        this.bucket6=bucket6;
    }
    public String getBucket12Period() { 
        return this.bucket12Period;
    }

    public void setBucket12Period(String bucket12Period) { 
        this.bucket12Period=bucket12Period;
    }
    public String getBucket14Period() { 
        return this.bucket14Period;
    }

    public void setBucket14Period(String bucket14Period) { 
        this.bucket14Period=bucket14Period;
    }
    public String getBucket16Period() { 
        return this.bucket16Period;
    }

    public void setBucket16Period(String bucket16Period) { 
        this.bucket16Period=bucket16Period;
    }
    public BigDecimal getBucket7() { 
        return this.bucket7;
    }

    public void setBucket7(BigDecimal bucket7) { 
        this.bucket7=bucket7;
    }
    public String getBucket10Period() { 
        return this.bucket10Period;
    }

    public void setBucket10Period(String bucket10Period) { 
        this.bucket10Period=bucket10Period;
    }
    public BigDecimal getBucket24() { 
        return this.bucket24;
    }

    public void setBucket24(BigDecimal bucket24) { 
        this.bucket24=bucket24;
    }
    public BigDecimal getBucket21() { 
        return this.bucket21;
    }

    public void setBucket21(BigDecimal bucket21) { 
        this.bucket21=bucket21;
    }
    public BigDecimal getBucket1() { 
        return this.bucket1;
    }

    public void setBucket1(BigDecimal bucket1) { 
        this.bucket1=bucket1;
    }
    public BigDecimal getBucket20() { 
        return this.bucket20;
    }

    public void setBucket20(BigDecimal bucket20) { 
        this.bucket20=bucket20;
    }
    public String getBucket23Period() { 
        return this.bucket23Period;
    }

    public void setBucket23Period(String bucket23Period) { 
        this.bucket23Period=bucket23Period;
    }
    public BigDecimal getBucket23() { 
        return this.bucket23;
    }

    public void setBucket23(BigDecimal bucket23) { 
        this.bucket23=bucket23;
    }
    public BigDecimal getLevel1Value() { 
        return this.level1Value;
    }

    public void setLevel1Value(BigDecimal level1Value) { 
        this.level1Value=level1Value;
    }
    public BigDecimal getBucket22() { 
        return this.bucket22;
    }

    public void setBucket22(BigDecimal bucket22) { 
        this.bucket22=bucket22;
    }
    public BigDecimal getFcBucketId() { 
        return this.fcBucketId;
    }

    public void setFcBucketId(BigDecimal fcBucketId) { 
        this.fcBucketId=fcBucketId;
    }
    public BigDecimal getRemainingAmount() { 
        return this.remainingAmount;
    }

    public void setRemainingAmount(BigDecimal remainingAmount) { 
        this.remainingAmount=remainingAmount;
    }
    
    public String getFcCurrency() { 
        return this.fcCurrency;
    }

    public void setFcCurrency(String fcCurrency) { 
        this.fcCurrency=fcCurrency;
    }
    public String getFcConversionType() { 
        return this.fcConversionType;
    }

    public void setFcConversionType(String fcConversionType) { 
        this.fcConversionType=fcConversionType;
    }
    public BigDecimal getLevel3Value() { 
        return this.level3Value;
    }

    public void setLevel3Value(BigDecimal level3Value) { 
        this.level3Value=level3Value;
    }
    public String getRemainingFutureFlag() { 
        return this.remainingFutureFlag;
    }

    public void setRemainingFutureFlag(String remainingFutureFlag) { 
        this.remainingFutureFlag=remainingFutureFlag;
    }
    public String getArrangementName() { 
        return this.arrangementName;
    }

    public void setArrangementName(String arrangementName) { 
        this.arrangementName=arrangementName;
    }
    public Timestamp getFcStartDate() { 
        return this.fcStartDate;
    }

    public void setFcStartDate(Timestamp fcStartDate) { 
        this.fcStartDate=fcStartDate;
    }
    public BigDecimal getFcMethodId() { 
        return this.fcMethodId;
    }

    public void setFcMethodId(BigDecimal fcMethodId) { 
        this.fcMethodId=fcMethodId;
    }
    public BigDecimal getExpectedSplit() { 
        return this.expectedSplit;
    }

    public void setExpectedSplit(BigDecimal expectedSplit) { 
        this.expectedSplit=expectedSplit;
    }
    
    public String getBucket19Period() { 
        return this.bucket19Period;
    }

    public void setBucket19Period(String bucket19Period) { 
        this.bucket19Period=bucket19Period;
    }
    public BigDecimal getLevel2Value() { 
        return this.level2Value;
    }

    public void setLevel2Value(BigDecimal level2Value) { 
        this.level2Value=level2Value;
    }
    public BigDecimal getExpectedDuration() { 
        return this.expectedDuration;
    }

    public void setExpectedDuration(BigDecimal expectedDuration) { 
        this.expectedDuration=expectedDuration;
    }
    public BigDecimal getMasterArrangementId() { 
        return this.masterArrangementId;
    }

    public void setMasterArrangementId(BigDecimal masterArrangementId) { 
        this.masterArrangementId=masterArrangementId;
    }
    public String getBucketType() { 
        return this.bucketType;
    }

    public void setBucketType(String bucketType) { 
        this.bucketType=bucketType;
    }
    public String getBucket13Period() { 
        return this.bucket13Period;
    }

    public void setBucket13Period(String bucket13Period) { 
        this.bucket13Period=bucket13Period;
    }
    public Timestamp getLastUpdatedDate() { 
        return this.lastUpdatedDate;
    }

    public void setLastUpdatedDate(Timestamp lastUpdatedDate) { 
        this.lastUpdatedDate=lastUpdatedDate;
    }
    public String getBucket22Period() { 
        return this.bucket22Period;
    }

    public void setBucket22Period(String bucket22Period) { 
        this.bucket22Period=bucket22Period;
    }
    public BigDecimal getShipmentDelay() { 
        return this.shipmentDelay;
    }

    public void setShipmentDelay(BigDecimal shipmentDelay) { 
        this.shipmentDelay=shipmentDelay;
    }
    public String getCustomerName() { 
        return this.customerName;
    }

    public void setCustomerName(String customerName) { 
        this.customerName=customerName;
    }
    public String getBucket11Period() { 
        return this.bucket11Period;
    }

    public void setBucket11Period(String bucket11Period) { 
        this.bucket11Period=bucket11Period;
    }
    public String getBucket15Period() { 
        return this.bucket15Period;
    }

    public void setBucket15Period(String bucket15Period) { 
        this.bucket15Period=bucket15Period;
    }
    public BigDecimal getInoviceDelay() { 
        return this.inoviceDelay;
    }

    public void setInoviceDelay(BigDecimal inoviceDelay) { 
        this.inoviceDelay=inoviceDelay;
    }
    public Timestamp getExpectedEndDate() { 
        return this.expectedEndDate;
    }

    public void setExpectedEndDate(Timestamp expectedEndDate) { 
        this.expectedEndDate=expectedEndDate;
    }
    public BigDecimal getBookingDelay() { 
        return this.bookingDelay;
    }

    public void setBookingDelay(BigDecimal bookingDelay) { 
        this.bookingDelay=bookingDelay;
    }
    public String getBucket17Period() { 
        return this.bucket17Period;
    }

    public void setBucket17Period(String bucket17Period) { 
        this.bucket17Period=bucket17Period;
    }
    public String getFcLevelName() { 
        return this.fcLevelName;
    }

    public void setFcLevelName(String fcLevelName) { 
        this.fcLevelName=fcLevelName;
    }
    public String getBucket20Period() { 
        return this.bucket20Period;
    }

    public void setBucket20Period(String bucket20Period) { 
        this.bucket20Period=bucket20Period;
    }
    public String getBucket24Period() { 
        return this.bucket24Period;
    }

    public void setBucket24Period(String bucket24Period) { 
        this.bucket24Period=bucket24Period;
    }
   /** public RmanCurrency getRmanCurrency() {
         return rmanCurrency;
    }

    public void setRmanCurrency(RmanCurrency rmanCurrency) {
         this.rmanCurrency=rmanCurrency;
    }

    public RmanFcConversionTypes getRmanFcConversionTypes() {
         return rmanFcConversionTypes;
    }

    public void setRmanFcConversionTypes(RmanFcConversionTypes rmanFcConversionTypes) {
         this.rmanFcConversionTypes=rmanFcConversionTypes;
    }

    public RmanFcBuckets getRmanFcBuckets() {
         return rmanFcBuckets;
    }

    public void setRmanFcBuckets(RmanFcBuckets rmanFcBuckets) {
         this.rmanFcBuckets=rmanFcBuckets;
    }

    public RmanFcLevel getRmanFcLevel() {
         return rmanFcLevel;
    }

    public void setRmanFcLevel(RmanFcLevel rmanFcLevel) {
         this.rmanFcLevel=rmanFcLevel;
    }

    public RmanLookupsV getRmanLookupsV() {
         return rmanLookupsV;
    }

    public void setRmanLookupsV(RmanLookupsV rmanLookupsV) {
         this.rmanLookupsV=rmanLookupsV;
    }

    public RmanLookupsV getRmanLookupsV1() {
         return rmanLookupsV1;
    }

    public void setRmanLookupsV1(RmanLookupsV rmanLookupsV1) {
         this.rmanLookupsV1=rmanLookupsV1;
    }
*/
    public RmanFcMethods getRmanFcMethods() {
         return rmanFcMethods;
    }

    public void setRmanFcMethods(RmanFcMethods rmanFcMethods) {
         this.rmanFcMethods=rmanFcMethods;
    }


}