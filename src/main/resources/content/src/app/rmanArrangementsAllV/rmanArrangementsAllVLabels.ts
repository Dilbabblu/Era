interface ILabels {
    [index: string]: string;
}

export class RmanArrangementsAllVLabels {

    fieldLabels: ILabels;

    constructor() {
        this.fieldLabels = {};
        this.fieldLabels["arrangementKey"] = "Revenue Contract Key";
        this.fieldLabels["arrangementNumber"] = "Revenue Contract Number";
        this.fieldLabels["arrangementName"] = "Revenue Contract Name";
        this.fieldLabels["dealNumber"] = "Deal#";
        this.fieldLabels["dealName"] = "Deal Name";
        this.fieldLabels["customerPoNum"] = "PO#";
        this.fieldLabels["orderNumber"] = "SO#";
        this.fieldLabels["endCustomerNumber"] = "Customer#";
        this.fieldLabels["legalEntityName"] = "Legal Entity Name";
        this.fieldLabels["arrangementCurrency"] = "Currency";
        this.fieldLabels["arrangementTotal"] = "Amount";
        this.fieldLabels["arrangementType"] = "Revenue Contract Type";
        this.fieldLabels["arrangementStatus"] = "Revenue Contract Status";
        this.fieldLabels["creationDate"] = "Creation Date";
        this.fieldLabels["lastUpdateDate"] = "Last Update Date";
        this.fieldLabels["arrangementBasis"] = "Revenue Contract Basis";
        this.fieldLabels["arrangementSource"] = "Revenue Contract Source";
        this.fieldLabels["contApplied"] = "Contingency Applied";
        this.fieldLabels["lastArrgModifiedDate"] = "Modified Date"
        this.fieldLabels["dealFlag"] = "DEAL FLAG";
        this.fieldLabels["endCustomerName"] = "Customer Name";
        this.fieldLabels["masterArrgName"] = "Master Arrg Name";
        this.fieldLabels["revManagerId"] = "Sales Contact";
        this.fieldLabels["msaName"] = "MSA Name";
        this.fieldLabels["contractFlag"] = "CONTRACT FLAG";
        this.fieldLabels["customerContact"] = "CUSTOMER CONTACT";
        this.fieldLabels["changeReason"] = "CHANGE REASON";
        this.fieldLabels["masterArrgId"] = "Master ArrgId";
        this.fieldLabels["repCurrCode"] = "REP CURR CODE";
        this.fieldLabels["createdBy"] = "CREATED BY";
        this.fieldLabels["salesNodeLevel4"] = "SALES NODE LEVEL4";
        this.fieldLabels["lastUpdatedBy"] = "LAST UPDATED BY";
        this.fieldLabels["msaNumber"] = "MSA#";
        this.fieldLabels["salesNodeLevel2"] = "SALES NODE LEVEL2";
        this.fieldLabels["calcuationMethod"] = "CALCUATION METHOD";
        this.fieldLabels["salesNodeLevel3"] = "SALES NODE LEVEL3";
        this.fieldLabels["salesContact"] = "Sales Contact";
        this.fieldLabels["legalEntityId"] = "LEGAL ENTITY ID";
        this.fieldLabels["revAccountantId"] = "Revenue Contact";
        this.fieldLabels["reasonCode"] = "REASON CODE";
        this.fieldLabels["guidanceType"] = "GUIDANCE TYPE";
        this.fieldLabels["masterArrgFlag"] = "MASTER ARRG FLAG";
        this.fieldLabels["arrangementId"] = "Revenue Contract ID";
        this.fieldLabels["salesNodeLevel1"] = "SALES NODE LEVEL1";
        this.fieldLabels["allocationEligible"] = "ALLOCATION ELIGIBLE";
        this.fieldLabels["guidanceName"] = "GUIDANCE NAME";
        this.fieldLabels["arrangementQtr"] = "Revenue Contract QTR";
    }

}
