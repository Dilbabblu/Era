interface ILabels {
    [index: string]: string;
}

export class AllExceptionsLabels {

    fieldLabels: ILabels;

    constructor() {

        this.fieldLabels = {};
        this.fieldLabels["documentCategory"] = "Document Category";
        this.fieldLabels["documentSource"] = "Document Source";
        this.fieldLabels["dealNumber"] = "Deal Number";
        this.fieldLabels["projectNumber"] = "Project Number";
        this.fieldLabels["opportunityNumber"] = "Oppurtunity Number";
        this.fieldLabels["opportunityName"] = "Oppurtunity Name";
        this.fieldLabels["documentNumber"] = "Document Number";
        this.fieldLabels["documentDescription"] = "Document Description";
        this.fieldLabels["documentHeaderId"] = "Document Header Id";
        this.fieldLabels["entityName"] = "Entity Name";
        this.fieldLabels["entityId"] = "Entity Id";
        this.fieldLabels["customerName"] = "Customer Name";
        this.fieldLabels["customerNumber"] = "Customer Number";
        this.fieldLabels["documentDate"] = "Document Date";
        this.fieldLabels["currencyCode"] = "Currency Code";
        this.fieldLabels["salesRep"] = "Sales Rep";
        this.fieldLabels["salesTheater"] = "Sales Theater";
        this.fieldLabels["region"] = "Region";
        this.fieldLabels["salesTerritory"] = "Sales Territory";
        this.fieldLabels["documentLineNumber"] = "Document Line Number";
        this.fieldLabels["documentLineId"] = "Document Line Id";
        this.fieldLabels["productName"] = "Product Name";
        this.fieldLabels["quantity"] = "Quantity";
        this.fieldLabels["uom"] = "UOM";
        this.fieldLabels["unitListPrice"] = "Unit List Price";
        this.fieldLabels["unitSellingPrice"] = "Unit Selling Price";
        this.fieldLabels["serviceStartDate"] = "Service Start Date";
        this.fieldLabels["serviceEndDate"] = "Service End Date";
        this.fieldLabels["unitCost"] = "Unit Cost";
        this.fieldLabels["contingnecyCode"] = "Contingency Code";
        this.fieldLabels["contingnecyPercentage"] = "Contingency Percentage";
        this.fieldLabels["revenueTemplateName"] = "Revenue Template Name";
        this.fieldLabels["refDocumentNumber"] = "Ref Document Number";
        this.fieldLabels["eventType"] = "Event Type";
        this.fieldLabels["customerPo"] = "Customer PO";
        this.fieldLabels["documentType"] = "Document Type";
        this.fieldLabels["inventoryItemId"] = "Inventory Item Id";
        this.fieldLabels["refLineId"] = "Ref Line Id";
        this.fieldLabels["refLineNumber"] = "Ref Line Number";
        this.fieldLabels["amount"] = "Amount";
        this.fieldLabels["exceptionMessage"] = "Exception Message";
        this.fieldLabels["documentLineStatus"] = "Document Line Status";
        this.fieldLabels["processId"] = "Process Id";
        this.fieldLabels["parentLineNumber"] = "Parent Line Number";
        this.fieldLabels["documentStatus"] = "Document Status";
        this.fieldLabels["contApplyType"] = "Cont Apply Type";
        this.fieldLabels["contReleaseType"] = "Cont Release Type";
        this.fieldLabels["contReleaseRevenue"] = "Cont Release Revenue";
    }
}