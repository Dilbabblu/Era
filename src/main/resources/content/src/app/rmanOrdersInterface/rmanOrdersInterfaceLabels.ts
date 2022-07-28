interface ILabels {
    [index: string]: string;
}

export class RmanOrdersInterfaceLabels {

    fieldLabels: ILabels;

    constructor() {

        this.fieldLabels = {};
        this.fieldLabels["sourceHeaderId"] = "Header Id";
        this.fieldLabels["orderNumber"] = "SO #";
        this.fieldLabels["customerPoNum"] = "PO #";
        this.fieldLabels["orderType"] = "Order Type";
        this.fieldLabels["bookingEntityName"] = "Booking Entity Name";
        this.fieldLabels["shippingEntityName"] = "Shipping Entity Name";
        this.fieldLabels["soldToCustomer"] = "Sold to Customer";
        this.fieldLabels["billToCustomerNumber"] = "Bill to Customer #";
        this.fieldLabels["billToCustomer"] = "Bill to Customer";
        this.fieldLabels["shipToCustomer"] = "Ship To Customer";
        this.fieldLabels["shipToCustomerNumber"] = "Ship to Customer #";
        this.fieldLabels["billToCountry"] = "Bill to Country";
        this.fieldLabels["shipToCountry"] = "Ship to Country";
        this.fieldLabels["shippingOrgCode"] = "Shipping Org Code";
        this.fieldLabels["bookedDate"] = "Booked Date";
        this.fieldLabels["orderedDate"] = "Ordered Date";
        this.fieldLabels["scheduleShipDate"] = "Schedule Ship Date";
        this.fieldLabels["orderStatus"] = "Order Status";
        this.fieldLabels["priceList"] = "Price List";
        this.fieldLabels["bookingCurrency"] = "Booking Currency";
        this.fieldLabels["sourceLineId"] = "Source Line Id";
        this.fieldLabels["sourceLineNumber"] = "SO Line #";
        this.fieldLabels["productName"] = "Product Name";
        this.fieldLabels["productOrgName"] = "Product Org Name";
        this.fieldLabels["orderedQuantity"] = "Ordered Quantity";
        this.fieldLabels["shippedQuantity"] = "Shipped Quantity";
        this.fieldLabels["fulfilledQuantity"] = "Fulfilled Quantity";
        this.fieldLabels["lineStatus"] = "Line Status";
        this.fieldLabels["unitSellingPrice"] = "Unit Selling Price";
        this.fieldLabels["unitListPrice"] = "Unit List Price";
        this.fieldLabels["extendedListAmount"] = "Extended List Amt";
        this.fieldLabels["extendedSellingmount"] = "Extended Selling Amt";
        this.fieldLabels["discountPercent"] = "Disocunt Percent";
        this.fieldLabels["orginalLineId"] = "Reference Line Id";
        this.fieldLabels["orginalLineNumber"] = "Reference SO Line #";
        this.fieldLabels["orginalOrderNumber"] = "Reference SO #";
        this.fieldLabels["serviceStartDate"] = "Service Start Date";
        this.fieldLabels["serviceEndDate"] = "Service End Date";
        this.fieldLabels["serviceDuration"] = "Service Duration";
        this.fieldLabels["servicePeriod"] = "Service Period";
        this.fieldLabels["actualFulfilledDate"] = "Actual Fulfilled Date";
        this.fieldLabels["lineCost"] = "Unit Cost";
        this.fieldLabels["domesticInternational"] = "Domestic International";
        this.fieldLabels["region"] = "Region";
        this.fieldLabels["territory"] = "Territory";
        this.fieldLabels["revrecHoldType"] = "Rev Rec Hold Type";
        this.fieldLabels["cancelledQty"] = "Cancelled Qty";
        this.fieldLabels["cancelledDate"] = "Cancelled Date";
        this.fieldLabels["lineCategoryCode"] = "Line Category Code";
        this.fieldLabels["customerNumber"] = "Customer #";
        this.fieldLabels["extWarrantySku"] = "Ext Warranty SKU";
        this.fieldLabels["extServStartDate"] = "Ext Service Start Date";
        this.fieldLabels["extServEndDate"] = "Ext Service End Date";
        this.fieldLabels["extPeriod"] = "Ext Period";
        this.fieldLabels["extDuration"] = "Ext Duration";
        this.fieldLabels["extListPrice"] = "Ext List Price";
        this.fieldLabels["extDiscount"] = "Ext Discount";
        this.fieldLabels["supportSku"] = "Support SKU";
        this.fieldLabels["supportServStartDate"] = "Support Service Start Date";
        this.fieldLabels["supportServEndDate"] = "Support Service End Date";
        this.fieldLabels["supportPeriod"] = "Support Period";
        this.fieldLabels["supportDuration"] = "Support Duration";
        this.fieldLabels["supportListPrice"] = "Support List Price";
        this.fieldLabels["supportDiscount"] = "Support Discount";
        this.fieldLabels["trainingSku"] = "Training SKU";
        this.fieldLabels["percentageSplit"] = "Percentage Split";
        this.fieldLabels["salesrep"] = "Salesrep";
        this.fieldLabels["errorMessage"] = "Error Message";
        this.fieldLabels["bookingEntityId"] = "Booking Entity Id";
        this.fieldLabels["shippingEntityId"] = "Shipping Entity Id";
        this.fieldLabels["dealNumber"] = "Deal #";
        this.fieldLabels["dealLineNumber"] = "Deal Line #";
    }

}
