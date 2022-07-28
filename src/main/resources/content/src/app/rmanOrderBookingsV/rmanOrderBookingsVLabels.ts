interface ILabels {
    [index: string]: string;
}

export class RmanOrderBookingsVLabels {

    fieldLabels: ILabels;

    constructor() {

        this.fieldLabels = {};

        this.fieldLabels["customerNumber"] = "Bill To Customer Number";
        this.fieldLabels["billToLocation"] = "Bill To Location";
        this.fieldLabels["so"] = "SO#";
        this.fieldLabels["priceList"] = "Price List";
        this.fieldLabels["bookingCurrency"] = "Booking Currency";
        this.fieldLabels["customerPoNum"] = "PO #";
        this.fieldLabels["arrangementId"] = "Arrangement Id";
        this.fieldLabels["funcCurrencyCode"] = "Functional Currency";
        this.fieldLabels["linkedDate"] = "Linked Date";
        this.fieldLabels["ouName"] = "Operating Unit";
        this.fieldLabels["orderBookedDate"] = "Ordered Date";
        this.fieldLabels["orderTrxAmount"] = "Order Trx Amount";
        this.fieldLabels["shipToLocation"] = "Ship To Location";
        this.fieldLabels["endCustomer"] = "Bill To Customer Name";
        this.fieldLabels["orderAcctdAmount"] = "Ordered Amount";
        this.fieldLabels["orderSource"] = "Order Source";
        this.fieldLabels["refOrderNumber"] = "Reference SO #";
        this.fieldLabels["serviceRefOrder"] = "Service Ref SO #";
        this.fieldLabels["serviceRefOrdLineNum"] = "Service Ref Line #";
        this.fieldLabels["orderNumModifier"] = "Contract Modifier";
        this.fieldLabels["sno"] = "Source Header Id";
        this.fieldLabels["salesrep"] = "Sales Rep";

    }

}
