interface ILabels {
    [index: string]: string;
}

export class RmanContReleaseLinesVLabels {

    fieldLabels: ILabels;

    constructor() {

        this.fieldLabels = {};

        this.fieldLabels["transHeaderId"] = "TRANS HEADER ID";
        this.fieldLabels["transLineId"] = "TRANS LINE ID";
        this.fieldLabels["productGroup"] = "Product Group";
        this.fieldLabels["sourceLineNumber"] = "Source Line Number";
        this.fieldLabels["sourceHeader"] = "Source Header";
        this.fieldLabels["revenue"] = "Revenue";
        this.fieldLabels["releaseCogs"] = "Release COGS";
        this.fieldLabels["cogs"] = "COGS";
        this.fieldLabels["ruleName"] = "Rule Name";
        this.fieldLabels["releaseLevel"] = "Release Level";
        this.fieldLabels["elementType"] = "Element Type";
        this.fieldLabels["applyType"] = "Apply Type";
        this.fieldLabels["productName"] = "Product Name";
        this.fieldLabels["dealArrangementId"] = "DEAL ARRANGEMENT ID";
        this.fieldLabels["event"] = "Event";
        this.fieldLabels["releaseType"] = "Release Type";
        this.fieldLabels["templateName"] = "Template Name";
        this.fieldLabels["productCategory"] = "Product Category";
        this.fieldLabels["releaseRevenue"] = "Release Revenue";
        this.fieldLabels["releaseLineId"] = "Release Line ID";
        this.fieldLabels["customerPayment"] = "Customer Payment";
        this.fieldLabels["releaseDate"] = "Release Date";
    }

}
