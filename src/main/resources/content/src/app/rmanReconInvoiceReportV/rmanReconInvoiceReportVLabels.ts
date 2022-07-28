interface ILabels {
    [index: string]: string;
}

export class RmanReconInvoiceReportVLabels {

    fieldLabels: ILabels;

    constructor() {

        this.fieldLabels = {};

        this.fieldLabels["dealArrangementNumber"] = "Arrangement #";
        this.fieldLabels["endCustomerName"] = "Customer Name";
        this.fieldLabels["fxDate"] = "Fx Date";
        this.fieldLabels["acctdCurrency"] = "Accounted Currency";
        this.fieldLabels["repUnitSellingPrice"] = "Rep Unit Selling Price";
        this.fieldLabels["invoicedDate"] = "Invoiced Date";
        this.fieldLabels["dealArrangementName"] = "Arrangement Name";
        this.fieldLabels["invoiceCurrency"] = "Invoice Currency";
        this.fieldLabels["invoicedQuantity"] = "Invoiced Quantity";
        this.fieldLabels["revenueAmount"] = "Revenue Amount";
        this.fieldLabels["productDescription"] = "Product Description";
        this.fieldLabels["dealArrangementBasis"] = "Arrangement Type";
        this.fieldLabels["fxRate"] = "Fx Rate";
        this.fieldLabels["sno"] = "Sno";
        this.fieldLabels["shippedQuantity"] = "Shipped Quantity";
        this.fieldLabels["dealNumber"] = "Deal #";
        this.fieldLabels["itemType"] = "Item Type";
        this.fieldLabels["actualFulfilledDate"] = "Shipped Date";
        this.fieldLabels["salesNodeLevel2"] = "Region";
        this.fieldLabels["salesNodeLevel3"] = "Territory";
        this.fieldLabels["dealLineNumber"] = "Deal Line#";
        this.fieldLabels["sourceLineNumber"] = "SO Line #";
        this.fieldLabels["sourceLineId"] = "Source Line Id";
        this.fieldLabels["legalEntityId"] = "Legal Entity Id";
        this.fieldLabels["dealHeaderId"] = "Deal HeaderId";
        this.fieldLabels["invoiceNumber"] = "Invoice #";
        this.fieldLabels["acctdRevAmount"] = "Accounted Amount";
        this.fieldLabels["productName"] = "Product Name";
        this.fieldLabels["customerPoNum"] = "PO";
        this.fieldLabels["salesNodeLevel1"] = "Sales Theater";
        this.fieldLabels["bookedDate"] = "Booked Date";
        this.fieldLabels["dealArrangementId"] = "Deal Arrangement Id";
        this.fieldLabels["transactionPrice"] = "Transaction Price";
        this.fieldLabels["legalEntityName"] = "Legal Entity Name";
        this.fieldLabels["repUnitListPrice"] = "UnitList Price";
        this.fieldLabels["invoiceLineNumber"] = "Invoice Line #";
        this.fieldLabels["orderNumber"] = "SO #";
        this.fieldLabels["orderedDate"] = "Ordered Date";
        this.fieldLabels["orderedQuantity"] = "Ordered Quantity";
    }

}
