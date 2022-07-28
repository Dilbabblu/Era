interface ILabels {
         [index: string]: string;
}

export class RmanArrgSummaryReportVLabels {

        fieldLabels: ILabels;

    constructor() {

    this.fieldLabels = {};

        this.fieldLabels["dealArrangementNumber"] = "Arrangement Number";
        this.fieldLabels["revEndBal"] = "Revenue Ending Balance (TC)";
        this.fieldLabels["postBillingDeferrals"] = "Post Billing Deferrals (TC)";
        this.fieldLabels["revenueUnbilled"] = "Revenue Unbilled (TC)";
        this.fieldLabels["pbAllocationAmountFc"] = "Post Billing Allocation Amount (FC)";
        this.fieldLabels["deliveredAllocationAmount"] = "Delivered Allocation Amount (TC)";
        this.fieldLabels["revCurrBal"] = "Revenue Current Balance (TC)";
        this.fieldLabels["revBegBalFc"] = "Revenue Beginning Balance (FC)";
        this.fieldLabels["salesTheater"] = "Sales Theater";
        this.fieldLabels["salesTerritory"] = "Sales Territory";
        this.fieldLabels["dealArrangementName"] = "Arrangement Name";
        this.fieldLabels["allocationAmount"] = "Allocation Amount (TC)";
        this.fieldLabels["billToCustomerNumber"] = "Bill To Customer Number";
        this.fieldLabels["unamortizedAmount"] = "Unamortized Amount (TC)";
        this.fieldLabels["revCurrBalFc"] = "Revenue Current Balance (FC)";
        this.fieldLabels["salesRegion"] = "Sales Region";
        this.fieldLabels["shipToCustomerNumber"] = "Ship To Customer Number";
        this.fieldLabels["carveInOutAmount"] = "Carve In/Carve Out Amount (TC)";
        this.fieldLabels["billToCustomer"] = "Bill To Customer Name";
        this.fieldLabels["sspAmount"] = "Extended SSP Amount (TC)";
        this.fieldLabels["revBegBal"] = "Revenue Beginning Balance (TC)";
        this.fieldLabels["bookedAmount"] = "Booked Amount (TC)";
        this.fieldLabels["postBillingDeferralsFc"] = "Post Billing Deferrals (FC)";
        this.fieldLabels["shipToCustomer"] = "Ship To Customer Name";
        this.fieldLabels["dealArrangementSource"] = "Arrangement Source";
        this.fieldLabels["bookingCurrency"] = "Transaction Currency";
        this.fieldLabels["revEndBalFc"] = "Revenue Ending Balance (FC)";
        this.fieldLabels["customerPoNum"] = "PO Number";
        this.fieldLabels["dealArrangementId"] = "DEAL ARRANGEMENT ID";
        this.fieldLabels["billedAmount"] = "Billed Amount (TC)";
        this.fieldLabels["allocationAmountFc"] = "Allocation Amount (FC)";
        this.fieldLabels["deliveredAllocationAmountFc"] = "Delivered Allocation Amount (FC)";
        this.fieldLabels["legalEntityName"] = "Legal Entity";
        this.fieldLabels["grossMarginFc"] = "Gross Margin (FC)";
        this.fieldLabels["postBillingAllocationAmount"] = "Post Billing Allocation Amount (TC)";
        this.fieldLabels["unamortizedAmountFc"] = "Unamortized Amount (FC)";
        this.fieldLabels["deliveredAmount"] = "Delivered Amount (TC)";
        this.fieldLabels["totalCostFc"] = "Total Cost (FC)";
        this.fieldLabels["dealArrangementStatus"] = "Status";
        this.fieldLabels["dealArrangementBasis"] = "Arrangement Basis";
        this.fieldLabels["creationDate"] = "Creation Date";
		this.fieldLabels["contractAsset"] = "Contract Asset (TC)";
		this.fieldLabels["contractLiability"] = "Contract Liability (TC)";
		this.fieldLabels["deferredRevenue"] = "Deferred Revenue (TC)";
		this.fieldLabels["clearing"] = "Clearing (TC)";
		this.fieldLabels["contractAssetFc"] = "Contract Asset (FC)";
		this.fieldLabels["contractLiabilityFc"] = "Contract Liability (FC)";
		this.fieldLabels["deferredRevenueFc"] = "Deferred Revenue (FC)";
		this.fieldLabels["clearingFc"] = "Clearing (FC)";
        this.fieldLabels["dealAarrangementBasis"] = "Arrangement Basis";
        this.fieldLabels["lastArrgModifiedDate"] = "Last Arrangement Modified Date";
        this.fieldLabels["salesContact"] = "Sales Rep";
    }

}
