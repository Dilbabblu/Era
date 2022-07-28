interface ILabels {
  [index: string]: string;
}

export class ArrgContractAllocationsVLabels {

  fieldLabels: ILabels;

  constructor() {

    this.fieldLabels = {};


    this.fieldLabels["dealLineId"] = "Deal Line Id";
    this.fieldLabels["quantity"] = "Quantity";
    this.fieldLabels["bundleAttributionList"] = "Bundle Attribution List";
    this.fieldLabels["elementType"] = "Element Type";
    this.fieldLabels["allocationAmount"] = "Allocation Amount";
    this.fieldLabels["parentLineNumber"] = "Parent Line Number";
    this.fieldLabels["totalCost"] = "Total Cost";
    this.fieldLabels["dealCurrencyCode"] = "Currency";
    this.fieldLabels["unitSellingPrice"] = "Unit Selling Price";
    this.fieldLabels["unitListPrice"] = "Unit List Price";
    this.fieldLabels["fmvCategory"] = "SSP Category";
    this.fieldLabels["cvInOutAmount"] = "Carve In/Carve Out";
    this.fieldLabels["lineAmount"] = "Line Amount";
    this.fieldLabels["repCurrCode"] = "Rep Curr Code";
    this.fieldLabels["fmvRuleName"] = "SSP Rule Name";
    this.fieldLabels["pobGrouping"] = "POB ID";
    this.fieldLabels["dealLineNumber"] = "Line #";
    this.fieldLabels["productGroup"] = "Product Family";
    this.fieldLabels["fmvMin"] = "SSP Min";
    this.fieldLabels["fmvMean"] = "SSP Trx";
    this.fieldLabels["fmvAmount"] = "Extended SSP";
    this.fieldLabels["dealHeaderId"] = "Deal Header Id";
    this.fieldLabels["bundleAttributionNet"] = "Bundle Attribution Net";
    this.fieldLabels["solution"] = "Solution";
    this.fieldLabels["parentLineId"] = "Parent Product";
    this.fieldLabels["productName"] = "Product Name";
    this.fieldLabels["dealArrangementId"] = "Deal Revenue Contract Id";
    this.fieldLabels["trxCurrencyCode"] = "Trx Currency Code";
    this.fieldLabels["accountingScope"] = "Accounting Scope";
    this.fieldLabels["productType"] = "Product Line";
    this.fieldLabels["fmvMax"] = "SSP Max";
    this.fieldLabels["accountingStandard"] = "Accounting Standard";
    this.fieldLabels["uomCode"] = "UOM";
    this.fieldLabels["allocationInclusive"] = "Allocation Inclusive";
    this.fieldLabels["bundleFlag"] = "Bundle Flag";
    this.fieldLabels["fmvType"] = "SSP Type";
    this.fieldLabels["dealNumber"] = "Contract/Deal #";
    this.fieldLabels["vc"] = "Variable Consideration";
    this.fieldLabels["arrgLineNumber"] = "Revenue Contract Line #";
    this.fieldLabels["allocableAmount"] = "Allocable Net Price";
    this.fieldLabels["sspLow"] = "SSP Low";
    this.fieldLabels["sspHigh"] = "SSP High";
    this.fieldLabels["netPriceDiscount"] = "Net Price Discount%";
    this.fieldLabels["fxRate"] = "Fx Rate";
    this.fieldLabels["fxDate"] = "Fx Date";
    this.fieldLabels["fxCurrency"] = "Fx Currency";
    this.fieldLabels["allocationAmountFc"] = "Allocation Amount (FC)";
    this.fieldLabels["ssp"] = "SSP";
    this.fieldLabels["orderNumber"] = "SO#";
	this.fieldLabels["sourceLineNumber"] = "SO Line#";
	this.fieldLabels["customerPoNum"] = "PO";
	this.fieldLabels["allocationFlag"] = "Allocation Flag";
	this.fieldLabels["discountType"] = "Discount Type";
	this.fieldLabels["additionalDiscount"] = "Additional Discount";
	this.fieldLabels["productDescription"] = "Product Description";
  }

}
