interface ILabels {
    [index: string]: string;
}

export class RmanDealGmAsvLabels {

    fieldLabels: ILabels;

    constructor() {

        this.fieldLabels = {};

        this.fieldLabels["sno"] = "SNO";
        this.fieldLabels["qty"] = "Quantity";
        this.fieldLabels["netPrice"] = "Allocated Revenue";
        this.fieldLabels["grossMargin"] = "Gross Margin";
        this.fieldLabels["elementType"] = "Element Type";
        this.fieldLabels["totalExpectedBookings"] = "Bookings";
        this.fieldLabels["arrangementName"] = "Revenue Contract Name";
        this.fieldLabels["sku"] = "Product Name";
        this.fieldLabels["arrangementId"] = "Revenue Contract Id";
        this.fieldLabels["lineCost"] = "Cost";
        this.fieldLabels["arrgLineNumber"] = "Revenue Contract Line #";
        this.fieldLabels["shippedQty"] = "Delivered Quantity";
        this.fieldLabels["shippedAllocation"] = "Delivered Allocation Amount";
        this.fieldLabels["lineShipmentAmount"] = "Delivered Amount";
        this.fieldLabels["lineShipmentCost"] = "Line Cost";
        this.fieldLabels["shipmentGrossMargin"] = "Gross Margin";
    }

}
