interface ILabels {
    [index: string]: string;
}

export class RmanInvoiceLinesVLabels {

    fieldLabels: ILabels;

    constructor() {

        this.fieldLabels = {};

        this.fieldLabels["sourceInvoiceId"] = "Source Invoice Id";
        this.fieldLabels["sourceLineNumber"] = "SO Line #";
        this.fieldLabels["quantity"] = "Quantity";
        this.fieldLabels["invoiceLineNumber"] = "Invoice Line Number";
        this.fieldLabels["salesOrderNumber"] = "SO #";
        this.fieldLabels["lineType"] = "Line Type";
        this.fieldLabels["salesOrderLineId"] = "Sales Order Line Id";
        this.fieldLabels["sourceInvoiceLineId"] = "Source Invoice Line Id";
        this.fieldLabels["rmanInvoiceLineId"] = "Rman Invoice Line Id";
        this.fieldLabels["usdAmount"] = "Amount in FC";
        this.fieldLabels["revenueAmount"] = "Invoice Line Amount";
        this.fieldLabels["unitSellingPrice"] = "Unit Selling Price";
        this.fieldLabels["glDate"] = "GL Date";
        this.fieldLabels["debitAccount"] = "Debit Account";
        this.fieldLabels["creditAccount"] = "Credit Account";
    }

}
