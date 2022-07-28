interface ILabels {
    [index: string]: string;
}

export class RmanEventsLabels {

    fieldLabels: ILabels;

    constructor() {

        this.fieldLabels = {};

        this.fieldLabels["createdBy"] = "CREATED BY";
        this.fieldLabels["lastUpdatedBy"] = "LAST UPDATED BY";
        this.fieldLabels["eventDate"] = "Event Date";
        this.fieldLabels["transactionSource"] = "TRANSACTION SOURCE";
        this.fieldLabels["errorMessage"] = "ERROR MESSAGE";
        this.fieldLabels["orderLineId"] = "ORDER LINE ID";
        this.fieldLabels["eventName"] = "Event Name";
        this.fieldLabels["orderLineNo"] = "SO Line#";
        this.fieldLabels["creationDate"] = "CREATION DATE";
        this.fieldLabels["lastUpdateLogin"] = "LAST UPDATE LOGIN";
        this.fieldLabels["lastUpdateDate"] = "LAST UPDATE DATE";
        this.fieldLabels["transactionType"] = "TRANSACTION TYPE";
        this.fieldLabels["status"] = "STATUS";
        this.fieldLabels["orderNumber"] = "SO#";
        this.fieldLabels["cogsAmount"] = "COGS Amount";
        this.fieldLabels["serviceStartDate"] = "Service Start Date";
        this.fieldLabels["serviceEndDate"] = "Service End Date";
        // this.fieldLabels["productName"]="SKU Name";
        this.fieldLabels["productName"] = "Product Name";
        this.fieldLabels["attribute1"] = "Additional Discount";


    }

}
