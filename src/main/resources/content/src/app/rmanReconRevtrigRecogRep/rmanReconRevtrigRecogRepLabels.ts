interface ILabels {
    [index: string]: string;
}

export class RmanReconRevtrigRecogRepLabels {

    fieldLabels: ILabels;

    constructor() {

        this.fieldLabels = {};

        this.fieldLabels["allocAmt"] = "Allocation Amount";
        this.fieldLabels["currency"] = "Currency";
        this.fieldLabels["arrangementNumber"] = "Arrangement Number";
        this.fieldLabels["exception"] = "Exceptions";
        this.fieldLabels["deferredAmt"] = "Deferred Amount";
        this.fieldLabels["eventReceived"] = "Event Received";
        this.fieldLabels["recogAmt"] = "Recognized Amount";
        this.fieldLabels["provisionAmt"] = "Provision Amount";
        this.fieldLabels["arrangementLineNumber"] = "Arrangement Line #";
        this.fieldLabels["deliveredAmt"] = "Delivered Amount";
        this.fieldLabels["soLineNum"] = "SO Line #";
        this.fieldLabels["sourceLineId"] = "Source Line Id";
        this.fieldLabels["skuRevTrigger"] = "Revenue Triggers (as per SKU)";
        this.fieldLabels["arrangementName"] = "Arrangement Name";
        this.fieldLabels["so"] = "SO #";
        this.fieldLabels["actualFulfilledDate"] = "Delivered Date";
    }

}
