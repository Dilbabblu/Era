interface ILabels {
  [index: string]: string;
}

export class RmanRevDetailsVLabels {

  fieldLabels: ILabels;

  constructor() {

    this.fieldLabels = {};

    this.fieldLabels["dealLineId"] = "Deal Line ID";
    this.fieldLabels["deliveredAllocRsp"] = "Delivered Allocation RSP (TC)";
    this.fieldLabels["totalGaapRevenueCurrentMon"] = "Revenue-Current Period";
    this.fieldLabels["dealArrangementName"] = "Deal Revenue Contract Name";
    this.fieldLabels["postBillingContAmount"] = "Post Billing Provisions";
    this.fieldLabels["cumGaapEndingBalance"] = "Revenue-Ending Balance (FC)";
    this.fieldLabels["arrgLineAmount"] = "Revenue Contract Line Amount";
    this.fieldLabels["totalGaapRevenueEndingBal"] = "Total Revenue-End Balance";
    this.fieldLabels["cumGaapBegBalance"] = "Revenue - Beginning Balance (FC)";
    this.fieldLabels["bookedAmount"] = "Booked Amount";
    this.fieldLabels["preBillingContAmount"] = "Pre Billing Contengency Amount";
    this.fieldLabels["dealLineNumber"] = "Deal Line #";
    this.fieldLabels["productGroup"] = "Product Family";
    this.fieldLabels["cogsBegiBalCogs"] = "COGS-Beg Balance";
    this.fieldLabels["productName"] = "Product Name";
    this.fieldLabels["dealArrangementId"] = "Deal Revenue Contract ID";
    this.fieldLabels["accountingRuleName"] = "Accounting Rule";
    this.fieldLabels["shippedAmount"] = "Delivered Amount";
    this.fieldLabels["billedAmount"] = "Billed Amount";
    this.fieldLabels["productType"] = "Product Line";
    this.fieldLabels["netGappCurrMonth"] = "Revenue-Current Period (FC)";
    this.fieldLabels["element"] = "Element Type";
    this.fieldLabels["postBillingAllocationAmount"] = "Post Billing Allocation Amount (FC)";
    this.fieldLabels["currentMonthCogs"] = "COGS-Current Period";
    this.fieldLabels["gaapUnamortized"] = "Unamortized Amount (FC)";
    this.fieldLabels["totalGaapRevneueBegBal"] = "Revenue-Beg Balance (FC)";
    this.fieldLabels["arrgLineCost"] = "Revenue Contract Line Cost (FC)";
    this.fieldLabels["endingBalance"] = "COGS-End Balance";
    this.fieldLabels["totalAllocation"] = "Total Allocation Amount (TC)";
    this.fieldLabels["duration"] = "Duration";
    this.fieldLabels["postBillingDeferrals"] = "Post Billing Deferrals (TC)";
    this.fieldLabels["attributedNetPrice"] = "Attributed Net Price";
    this.fieldLabels["deliveredAttributedNetPrice"] = "Delivered Attributed Net Price";
    this.fieldLabels["pobGroup"] = "POB ID";
    this.fieldLabels["arrgLineNumber"] = "Revenue Contract Line #";
    this.fieldLabels["amortRuleRevenue"] = "Amortization Rule";
    this.fieldLabels["amortMethodRevenue"] = "Amortization Method";
    this.fieldLabels["totalAllocationFc"] = "Total Allocation Amount (FC)";
    this.fieldLabels["deliveredAllocFcRsp"] = "Delivered Allocation RSP(FC)";
    this.fieldLabels["pbDeferralFc"] = "Post Billing Deferrals (FC)";
    this.fieldLabels["orderNumber"] = "SO #";
    this.fieldLabels["sourceLineNumber"] = "SO Line#";
    this.fieldLabels["customerPoNum"] = "PO";
    this.fieldLabels["dealNumber"] = "Deal #";
    this.fieldLabels["bundleFlag"] = "Bundle Flag";
    this.fieldLabels["parentLineId"] = "Parent Line Id";
    this.fieldLabels["revenueStartDate"] = "Service Start Date";
    this.fieldLabels["revenueEndDate"] = "Service End Date";
    this.fieldLabels["billedAmountFc"] = "Billed Amount (FC)";
    this.fieldLabels["pbAllocAmountTc"] = "Post Billing Alloc Amt (TC)";
    this.fieldLabels["revBegBalTc"] = "Revenue - Beginning Balance (TC)";
    this.fieldLabels["revCurrMonthBalTc"] = "Revenue-Current Period (TC)";
    this.fieldLabels["revEndBalTc"] = "Revenue-Ending Balance (TC)";
    this.fieldLabels["gaapUnamortizedTc"] = "Unamortized Amount (TC)";
    this.fieldLabels["productDescription"] = "Product Description";
    this.fieldLabels["dealNum"] = "Deal line #";
  }


}
