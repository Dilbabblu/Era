interface ILabels {
    [index: string]: string;
}

export class RmanReconDealsArggRepLabels {

    fieldLabels: ILabels;

    constructor() {

        this.fieldLabels = {};

        this.fieldLabels["dealLineNumber"] = "Deal Line #";
        this.fieldLabels["sourceLineNumber"] = "SO Line #";
        this.fieldLabels["sourceLineId"] = "Source Line Id";
        this.fieldLabels["arrangementNumber"] = "Arrangement #";
        this.fieldLabels["creationDate"] = "Creation Date";
        this.fieldLabels["arrangementStatus"] = "Arrangement Status";
        this.fieldLabels["trgQty"] = "Quantity (Destination)";
        this.fieldLabels["srcUnitPrice"] = "Unit Price (Source)";
        this.fieldLabels["trgUnitPrice"] = "Unit Price (Destination)";
        this.fieldLabels["exception"] = "Exception";
        this.fieldLabels["customerName"] = "Customer Name";
        this.fieldLabels["srcQty"] = "Quantity (Source)";
        this.fieldLabels["srcAmount"] = "Amount (Source)";
        this.fieldLabels["currency"] = "Currency";
        this.fieldLabels["arrangementLineNum"] = "Arrangement Line #";
        this.fieldLabels["trgAmount"] = "Amount (Destination)";
        this.fieldLabels["dealNumber"] = "Deal #";
        this.fieldLabels["so"] = "SO #";
        this.fieldLabels["sku"] = "Product Name";
    }

}
