interface ILabels {
         [index: string]: string;
}

export class ContractHeadersInfoVLabels {

        fieldLabels: ILabels;

    constructor() {

    this.fieldLabels = {};

        this.fieldLabels["dealNumber"] = "Contract/Deal#";
        this.fieldLabels["dealName"] = "Contract/Deal Name";
        this.fieldLabels["agreementNumber"] = "Agreement#";
        this.fieldLabels["agreementName"] = "Agreement Name";
        this.fieldLabels["opportunityNum"] = "Opportunity #";
        this.fieldLabels["opportunityName"] = "Opportunity Name";
        this.fieldLabels["endCustomerName"] = "Customer Name";
        this.fieldLabels["salesChannel"] = "Sales Channel";
        this.fieldLabels["dealCurrencyCode"] = "Currency";
        this.fieldLabels["dealAmount"] = "Amount";
        this.fieldLabels["createdDate"] = "Created Date";
        this.fieldLabels["additionalInfo1"] = "Additional Info1";
        this.fieldLabels["priceList"] = "Price List";
        this.fieldLabels["additionalInfo2"] = "Additional Info2";
        this.fieldLabels["dealHeaderId"] = "Deal Header ID";
        this.fieldLabels["dealType"] = "Deal Type";
        this.fieldLabels["dealArrangementId"] = "Deal Arrangement ID";
        this.fieldLabels["dealStatus"] = "Deal Staus";
        this.fieldLabels["billToCountry"] = "Bill to Country";
        this.fieldLabels["endCustomerNum"] = "Customer#";
        this.fieldLabels["shipToCountry"] = "Ship To Country";
        this.fieldLabels["billToCustomerName"] = "Bill To Customer Name";
    
    }

}
