interface ILabels {
         [index: string]: string;
}

export class BsbReportLabels {

        fieldLabels: ILabels;

    constructor() {

    this.fieldLabels = {};

this.fieldLabels["financialMonth"]      = "Financial Month";
this.fieldLabels["shipToCustomerName"]  = "Ship to Customer";
this.fieldLabels["shipToCountry"]       = "Ship to Country";
this.fieldLabels["billToCustomerName"]  = "Bill to Customer";
this.fieldLabels["billToState"]         = "Bill to State";
this.fieldLabels["billToCountry"]       = "Bill to Country";
this.fieldLabels["customerPo"]          = "Cutomer PO#";
this.fieldLabels["fob"]                 = "FOB";
this.fieldLabels["freightTerms"]        = "Freight Terms";
this.fieldLabels["freightCarrier"]      = "Freight Carrier";
this.fieldLabels["orderNumber"]         = "SO#";
this.fieldLabels["orderLine"]           = "SO Line#";
this.fieldLabels["orderType"]           = "Order Type";
this.fieldLabels["subOrderType"]        = "Sub Order Type";
this.fieldLabels["isRevenue"]           = "Is Revenue";
this.fieldLabels["salesrepName"]        = "Salesrep Name";
this.fieldLabels["region"]              = "Region";
this.fieldLabels["productNumber"]       = "Product Name";
this.fieldLabels["productFamily"]       = "Product Family";
this.fieldLabels["productLine"]         = "Product Line";
this.fieldLabels["shipDate"]            = "Shipped Date";
this.fieldLabels["invoiceNumber"]       = "Invoice Number";
this.fieldLabels["invoiceLine"]         = "Invoice Line#";
this.fieldLabels["shippedQuantity"]     = "Shipped Quantity";
this.fieldLabels["extendedCost"]        = "Extended Cost";
this.fieldLabels["shippedAmount"]       = "Shipped Amount";
this.fieldLabels["division"]            = "Division";
this.fieldLabels["totalMonths"]         = "Total Months";
this.fieldLabels["serviceCode"]         = "Service Code";
this.fieldLabels["endCustomer"]         = "End Customer";
this.fieldLabels["snExists"]            = "SN Exits";
this.fieldLabels["username"]            = "Username";
this.fieldLabels["itemType"]            = "Item Type";
this.fieldLabels["warrantyTransferred"] = "Warranty Transferred";
this.fieldLabels["serviceStartDate"]    = "Service Start Date";
this.fieldLabels["serviceEndDate"]      = "Service End Date";
this.fieldLabels["productService"]      = "Product Service";
this.fieldLabels["productFamily2"]      = "Product Family2";
this.fieldLabels["note"]                = "Note";
this.fieldLabels["je"]                  = "JE";
this.fieldLabels["geography10k"]        = "Geography-10K";
this.fieldLabels["concatenate"]         = "Concatenate";
this.fieldLabels["source"]              = "Source";
this.fieldLabels["extendedWarranty"]    = "Extended Warranty";
this.fieldLabels["reasonForExclusion"]  = "Reason for Exclusion";
this.fieldLabels["serviceMaintLegacy"]  = "Service Maint Legacy";
this.fieldLabels["reasonForExclusion2"] = "Reason for Exclusion2";
this.fieldLabels["serviceMaintNewParts"]= "Service Maint New Parts";
this.fieldLabels["reasonForExclusion3"] = "Reason for Exclusion3";
this.fieldLabels["contingencyApplied"] = "Contingency Applied";
this.fieldLabels["elementType"] = "Element Type";
    
    }

}
