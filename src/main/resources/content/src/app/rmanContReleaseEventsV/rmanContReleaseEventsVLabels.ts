interface ILabels {
    [index: string]: string;
}

export class RmanContReleaseEventsVLabels {

    fieldLabels: ILabels;

    constructor() {

        this.fieldLabels = {};

        this.fieldLabels["dealArrangementNumber"] = "Deal Arrangement Number";
        this.fieldLabels["lineNum"] = "Line Num#";
        this.fieldLabels["dealLineNumber"] = "Deal line Number";
        this.fieldLabels["sourceLineId"] = "Source Line ID";
        this.fieldLabels["orderNumber"] = "SO #";
        this.fieldLabels["sourceLineNumber"] = "SO Line #";
        this.fieldLabels["revenue"] = "Revenue";
        this.fieldLabels["applyType"] = "Apply Type";
        this.fieldLabels["dealArrangementName"] = "Deal Arrangement Name";
        this.fieldLabels["contingencyName"] = "Contingency Name";
        this.fieldLabels["dealArrangementId"] = "Deal Arrangement ID";
        this.fieldLabels["ranking"] = "Ranking";
        this.fieldLabels["templateName"] = "Template Name";
        this.fieldLabels["deferredAmount"] = "Deferred Amount";
        this.fieldLabels["sno"] = "SNO";
        this.fieldLabels["dealNumber"] = "Deal Number";
        this.fieldLabels["so"] = "SO";
        this.fieldLabels["deferredReleaseAmount"] = "Release Amount";
        this.fieldLabels["undeferredAmount"] = "Undeferred Amount";
        this.fieldLabels["deliveredAmount"] = "Delivered Amount";
        this.fieldLabels["bookedAmount"] = "Booked Amount";
        this.fieldLabels["dealLineId"] = "Deal Line ID";
        this.fieldLabels["ruleCategory"] = "Rule Category";
        this.fieldLabels["trxCurrency"] = "Transaction Currency";
        this.fieldLabels["dealNum"] = "Deal Line #";
        this.fieldLabels["productName"] = "Product Name";
    }

}
