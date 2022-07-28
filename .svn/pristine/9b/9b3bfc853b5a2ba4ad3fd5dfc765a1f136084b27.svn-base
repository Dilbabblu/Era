package com.forsys.revmantra.utils;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExportColumns {
	protected static final Map<String, String> arrangementsFields = arrangementsAllVMap();
	protected static final Map<String, String> contractHeadersFields = contractHeadersMap();
	protected static final Map<String, String> contractLinesFields = contractLinesMap();
	protected static final Map<String, String> allocationsFields = allocationsMap();
	protected static final Map<String, String> releaseContingenciesFields = releaseContigenciesMap();
	protected static final Map<String, String> releaseLinesFields = releaseLinesMap();
	protected static final Map<String, String> bookingsFields = bookingsMap();
	protected static final Map<String, String> bookingLinesFields = bookingLinesMap();
	protected static final Map<String, String> invoiceHeadersFields = invoiceHeadersMap();
	protected static final Map<String, String> invoiceLinesFields = invoiceLinesMap();
	protected static final Map<String, String> revenueFields = revenueMap();
	
	// operational reports
	protected static final Map<String, String> rmanArrgSummaryRepV = rmanArrgSummaryRepMap();
	protected static final Map<String, String> rmanTrxDetailReportV = rmanTrxDetailReportMap();
	protected static final Map<String, String> rmanArrgWaterfallReportV = rmanArrgWaterfallReportVMap();
	protected static final Map<String, String> rmanDeferredRollForwardRepV = rmanDeferredRollForwardRepMap();
	protected static final Map<String, String> rmanGlAccountingV = rmanGlAccountingVMap();

	// reconciliation reports
	protected static final Map<String, String> rmanReconDealsArggRepV = rmanReconDealsArggRepMap();
	protected static final Map<String, String> rmanReconSosrcToBkingsRepV = rmanReconSosrcToBkingsRepMap();
	protected static final Map<String, String> rmanReconInvoiceRepV = rmanReconInvoiceRepMap();
	protected static final Map<String, String> rmanReconShippedSoTrgRepV = rmanReconShippedSoTrgRepMap();
	protected static final Map<String, String> rmanReconRevtrigRecogRepV = rmanReconRevtrigRecogRepMap();

	/**
	 *  Export Fields for the Quotes,Bookings,Shipments and Billing Documents Process Exceptions
	 */
	protected static final Map<String, String> quoteDocFields = quoteDocsMap();
	protected static final Map<String, String> bookDocFields = bookingDocsMap();
	protected static final Map<String, String> shipDocFields = shipmentDocsMap();
	protected static final Map<String, String> invDocFields = billingDocsMap();
	protected static final Map<String, String> vcDocFields = vcDocsMap();
	
	//export for pob mappings and conversion rates
	protected static final Map<String, String> pobMappingFields = pobMappingsMap();
	protected static final Map<String, String> conversionRatesFields = conversionRatesMap();
	
	protected ExportColumns() {
		
	}
	

	private static Map<String, String> arrangementsAllVMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("arrangementNumber", "Revenue Contract Number");
		map.put("groupingRule", "Grouping Rule");
		map.put("dealNum", "Deal Number");
		map.put("projectNumber", "Project Number");
		map.put("dealNumber", "Quote Number");
		map.put("customerPoNum", "PO Number");
		map.put("orderNumber", "SO Number");
		map.put("endCustomerName", "Customer Name");
		map.put("endCustomerNumber", "Customer Number");
		map.put("legalEntityName", "Legal Entity Name");
		map.put("arrangementCurrency", "Currency");
		map.put("arrangementTotal", "Amount");
		map.put("arrangementStatus", "Contract Status");
		map.put("arrangementSource", "Source");
		map.put("contApplied", "Contingency Applied");
		map.put("creationDate", "Creation Date");
		map.put("lastUpdateDate", "Last Update Date");
		map.put("lastArrgModifiedDate", "Modified Date");
		
		return Collections.unmodifiableMap(map);
	}

	private static Map<String, String> contractHeadersMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("dealNumber", "Contract/Deal#");
		map.put("dealName", "Contract/Deal Name");
		map.put("agreementNumber", "Agreement#");
		map.put("agreementName", "Agreement Name");
		map.put("opportunityNum", "Opportunity #");
		map.put("opportunityName", "Opportunity Name");
		map.put("endCustomerName", "Customer Name");
		map.put("salesChannel", "Sales Channel");
		map.put("dealCurrencyCode", "Currency");
		map.put("dealAmount", "Amount");
		map.put("createdDate", "Created Date");
		map.put("additionalInfo1", "Project Number");
		map.put("priceList", "Price List");
		map.put("po", "PO");
		map.put("groupingRuleName", "Grouping Rule Name");
		return Collections.unmodifiableMap(map);
	}

	private static Map<String, String> contractLinesMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("pobId", "POB ID");
		map.put("dealLineNumber", "Line#");
		map.put("productName", "Product Name");
		map.put("productDescription", "Product Description");
		map.put("uomCode", "UOM");
		map.put("quantity", "Quantity");
		map.put("dealCurrencyCode", "Currency");
		map.put("conversionRate", "Exchange Rate");
		map.put("unitListPrice", "Unit List Price");
		map.put("unitSellingPrice", "Unit Selling Price");
		map.put("lineAmount", "Line Amount");
		map.put("attribute13", "Variable Consideration");
		map.put("elementType", "Element Type");
		map.put("bundleFlag", "Bundle Flag");
		map.put("parentLineId", "Parent Product");
		map.put("attribute1", "Product Portfolio");
		map.put("attribute2", "Product Family");
		map.put("attribute3", "Product Line");
		map.put("serviceStartDate", "Service Start Date");
		map.put("serviceEndDate", "Service End Date");
		map.put("attribute9", "Unit Cost");
		map.put("dealLineCost", "Total Cost");
		map.put("accRuleRevenue", "Accounting Rule");
		map.put("lookupDescription", "Amortization Rule Name");
		return Collections.unmodifiableMap(map);
	}

	private static Map<String, String> allocationsMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("pobGrouping", "POB ID");
		map.put("arrgLineNumber", "Revenue Contract Line#");
		map.put("customerPoNum", "PO");
		map.put("orderNumber", "SO#");
		map.put("sourceLineNumber", "SO Line#");
		map.put("dealNumber", "Contract/Deal#");
		map.put("dealLineNumber", "Line#");
		map.put("productName", "Product Name");
		map.put("productDescription", "Product Description");
		map.put("uomCode", "UOM");
		map.put("quantity", "Quantity");
		map.put("dealCurrencyCode", "Currency");
		map.put("unitListPrice", "Unit List Price");
		map.put("unitSellingPrice", "Unit Selling Price");
		map.put("netPriceDiscount", "Net Price Discount%");
		map.put("extendedListAmount", "Extended List Amount");
		map.put("lineAmount", "Line Amount");
		map.put("vc", "Variable Consideration");
		map.put("allocableAmount", "Allocable Net Price");
		map.put("elementType", "Element Type");
		map.put("bundleFlag", "Bundle Flag");
		map.put("parentLineId", "Parent Product");
		map.put("productGroup", "Product Family");
		map.put("productType", "Product Line");
		map.put("fmvRuleName", "SSP Rule Name");
		map.put("fmvCategory", "SSP Category");
		map.put("fmvType", "SSP Type");
		map.put("fmvMin", "SSP Min");
		map.put("fmvMean", "SSP Trx");
		map.put("fmvMax", "SSP Max");
		map.put("bundleAttributionList", "Bundle Attribution List");
		map.put("bundleAttributionNet", "Bundle Attribution Net");
		map.put("sspLow", "SSP Low");
		map.put("sspHigh", "SSP High");
		map.put("ssp", "SSP");
		map.put("fmvAmount", "Extended SSP");
		map.put("allocationAmount", "Allocation Amount");
		map.put("cvInOutAmount", "Carve In/Carve Out ");
		map.put("allocationFlag", "Allocation Flag");
		map.put("allocationInclusive", "Allocation Inclusive");
		map.put("totalCost", "Total Cost");
		map.put("fxRate", "Fx Rate");
		map.put("fxCurrency", "Fx Currency");
		map.put("fxDate", "Fx Date");
		map.put("allocationAmountFc", "Allocation Amount(Fc)");
		map.put("bedp", "BEDP");
		map.put("esp", "ESP");
		map.put("espinst", "ESPINT");
		map.put("allocationMarginPercentage", "Allocation Margin %");
		map.put("grossMarginPercentage", "Gross Margin %");
		map.put("revenueGuidance", "Revenue Guidance Analysis");
		map.put("comments", "Revenue Guidance Description");
		return Collections.unmodifiableMap(map);
	}

	private static Map<String, String> releaseContigenciesMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("applicationLevel", "Release Level");
		map.put("sourceHeaderId", "Source Header Id");
		map.put("sourceLineId", "Source Line Id");
		map.put("attribute3", "Product Group");
		map.put("attribute2", "Product Category");
		map.put("productName", "Product Name");
		map.put("attribute29", "Post Allocation Contingency");
		map.put("contEventType", "Current/Future");
		map.put("ruleHeaderId", "Name");
		map.put("ranking", "Ranking");
		map.put("attribute28", "Include FV Allocation");
		map.put("templateId", "Template Id");
		map.put("revenue", "Revenue");
		map.put("cogs", "Cogs");
		map.put("invoiceHold", "Invoice Hold");
		map.put("applyType", "Type");
		map.put("deferredMethod", "Method");
		map.put("releaseType", "Release Type");
		map.put("releaseRevenue", "Release Revenue");
		map.put("releaseCogs", "Release Cogs");
		map.put("comments", "Comments");
		map.put("attribute14", "Additional Info");
		return Collections.unmodifiableMap(map);
	}

	private static Map<String, String> releaseLinesMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("releaseLevel", "Release Level");
		map.put("ruleName", "Rule Name");
		map.put("templateName", "Template Name");
		map.put("sourceHeader", "Source Header");
		map.put("sourceLineNumber", "Source Line Number");
		map.put("elementType", "Element Type");
		map.put("productGroup", "Product Group");
		map.put("productCategory", "Product Category");
		map.put("productName", "Product Name");
		map.put("applyType", "Apply Type");
		map.put("revenue", "Revenue");
		map.put("cogs", "Cogs");
		map.put("releaseRevenue", "Release Revenue");
		map.put("releaseCogs", "Release Cogs");
		map.put("event", "Event");
		map.put("releaseType", "Release Type");
		map.put("releaseDate", "Release Date");
		map.put("customerPayment", "Customer Payment");
		return Collections.unmodifiableMap(map);
	}

	private static Map<String, String> bookingsMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("so", "SO#");
		map.put("orderNumModifier", "Contract Modifier");
		map.put("ouName", "Operating Unit");
		map.put("endCustomer", "Bill To Customer Name");
		map.put("customerNumber", "Bill To Customer#");
		map.put("billToLocation", "Bill To Location");
		map.put("shipToLocation", "Ship To Location");
		map.put("salesrep", "Sales Rep");
		map.put("priceList", "Price List");
		map.put("customerPoNum", "PO #");
		map.put("bookingCurrency", "Booking Currency");
		map.put("funcCurrencyCode", "Functional Currency");
		map.put("orderAcctdAmount", "Ordered Amount");
		map.put("orderBookedDate", "Ordered Date");
		return Collections.unmodifiableMap(map);
	}

	private static Map<String, String> bookingLinesMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("pobGrouping", "POB Id");
		map.put("soLineNum", "SO Line#");
		map.put("productName", "Product Name");
		map.put("uom", "UOM");
		map.put("orderedQuantity", "Ordered Quantity");
		map.put("listPrice", "Unit List Price");
		map.put("netPrice", "Unit Selling Price");
		map.put("extendedListAmount", "Extended List Amount");
		map.put("lineAmount", "Line Amount");
		map.put("lineCost", "Line Cost");
		map.put("manufacturingCost", "Manufacturing Cost");
		map.put("bundleFlag", "Bundle Flag");
		map.put("parentLineId", "Parent Line Id");
		map.put("bookedDate", "Booked Date");
		map.put("shipeedDate", "Delivered Date");
		map.put("billedDate", "Billed Date");
		map.put("lineStatus", "Line Status");
		map.put("accountingRuleName", "Accounting Rule");
		map.put("amortRuleRevenue", "Amortization Rule");
		map.put("contractStartDate", "Contract Start Date");
		map.put("contractEndDate", "Contract End Date");
		map.put("productFamily", "Product Family");
		map.put("productCategory", "Product Line");
		map.put("dealNumber", "Deal Number");
		map.put("dealLineNumber", "Deal Line Number");
		map.put("contractModifed", "Contract Modified");
		map.put("contractModifiedDate", "Contract Modified Date");
		map.put("lineAttribute1", "Attribute 1");
		map.put("lineAttribute2", "Attribute 2");
		map.put("lineAttribute3", "Attribute 3");
		map.put("lineAttribute4", "Attribute 4");
		map.put("lineAttribute5", "Attribute 5");
		map.put("lineAttribute6", "Attribute 6");
		map.put("lineAttribute7", "Attribute 7");
		map.put("lineAttribute8", "Attribute 8");
		map.put("lineAttribute9", "Attribute 9");
		map.put("lineAttribute10", "Attribute 10");
		map.put("lineAttribute11", "Attribute 11");
		map.put("lineAttribute12", "Attribute 12");
		map.put("lineAttribute13", "Attribute 13");
		map.put("lineAttribute14", "Attribute 14");
		map.put("lineAttribute15", "Attribute 15");
		return Collections.unmodifiableMap(map);
	}

	private static Map<String, String> invoiceHeadersMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("invoiceNumber", "Invoice Number");
		map.put("invoicedDate", "Invoiced Date");
		map.put("invoiceType", "Invoice Type");
		map.put("invoiceTrxType", "InvoiceTrx Type");
		map.put("fxRate", "Fx Rate");
		map.put("fxDate", "Fx Date");
		map.put("invoiceCurrency", "Invoice Currency");
		map.put("acctdCurrency", "Functional Currency");
		map.put("salesOrderNumber", "SO #");
		map.put("invoiceSource", "Invoice Source");
		map.put("invoiceAmount", "Invoice Amount");
		return Collections.unmodifiableMap(map);
	}

	private static Map<String, String> invoiceLinesMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("invoiceLineNumber", "Invoice Line Number");
		map.put("lineType", "Line Type");
		map.put("quantity", "Quantity");
		map.put("unitSellingPrice", "Unit Selling Price");
		map.put("salesOrderNumber", "SO #");
		map.put("sourceLineNumber", "SO Line #");
		map.put("revenueAmount", "Invoice Line Amount");
		map.put("usdAmount", "Amount in FC");
		map.put("attribute1", "Attribute 1");
		map.put("attribute2", "Attribute 2");
		map.put("attribute3", "Attribute 3");
		map.put("attribute4", "Attribute 4");
		map.put("attribute5", "Attribute 5");
		return Collections.unmodifiableMap(map);
	}

	private static Map<String, String> revenueMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("pobGroup", "POB ID");
		map.put("arrgLineNumber", "Revenue Contract Line#");
		map.put("dealNumber", "Deal#");
		map.put("dealLineNumber", "Deal Line#");
		map.put("bundleFlag", "Bundle Flag");
		map.put("parentLineId", "Parent Line Id");
		map.put("customerPoNum", "PO#");
		map.put("orderNumber", "SO#");
		map.put("sourceLineNumber", "SO Line#");
		map.put("productName", "Product Name");
		map.put("productDescription", "Product Description");
		map.put("element", "Element Type");
		map.put("productGroup", "Product Family");
		map.put("productType", "Product Line");
		map.put("arrgLineAmount", "Revenue Contract Line Amount");
		map.put("arrgLineCost", "Revenue Contract Line Cost (FC)");
		map.put("attributedNetPrice", "Attributed Net Price");
		map.put("totalAllocation", "Total Allocation Amount (TC)");
		map.put("totalAllocationFc", "Total Allocation Amount (FC)");
		map.put("bookedAmount", "Booked Amount");
		map.put("shippedAmount", "Delivered Amount");
		map.put("deliveredAttributedNetPrice", "Delivered Attributed Net Price");
		map.put("deliveredAllocRsp", "Delivered Allocation RSP (TC)");
		map.put("deliveredAllocFcRsp", "Delivered Allocation RSP(FC)");
		map.put("billedAmount", "Billed Amount");
		map.put("billedAmountFc", "Billed Amount (FC)");
		map.put("postBillingContAmount", "Post Billing Provisions");
		map.put("postBillingDeferrals", "Post Billing Deferrals (TC)");
		map.put("pbDeferralFc", "Post Billing Deferrals (FC)");
		map.put("pbAllocAmountTc", "Post Billing Alloc Amt (TC)");
		map.put("postBillingAllocationAmount", "Post Billing Allocation Amount (FC)");
		map.put("revenueStartDate", "Service Start Date");
		map.put("revenueEndDate", "Service End Date");
		map.put("revBegBalTc", "Revenue - Beginning Balance (TC)");
		map.put("revCurrMonthBalTc", "Revenue-Current Period (TC)");
		map.put("revEndBalTc", "Revenue-Ending Balance (TC)");
		map.put("cumGaapBegBalance", "Revenue - Beginning Balance (FC)");
		map.put("netGappCurrMonth", "Revenue-Current Period (FC)");
		map.put("cumGaapEndingBalance", "Revenue-Ending Balance (FC)");
		map.put("accountingRuleName", "Accounting Rule");
		map.put("amortRuleRevenue", "Amortization Rule");
		map.put("amortMethodRevenue", "Amortization Method");
		map.put("gaapUnamortizedTc", "Unamortized Amount (TC)");
		map.put("gaapUnamortized", "Unamortized Amount (FC)");
		map.put("cogsBegiBalCogs", "COGS-Beg Balance");
		map.put("currentMonthCogs", "COGS-Current Period");
		map.put("endingBalance", "COGS-End Balance");
		map.put("revAdjustment", "Revenue Adjustment"); // AYAR-1692 by Chandra on 25-10-2021 Added RevAdjustment field to export columns
		return Collections.unmodifiableMap(map);
	}

	private static Map<String, String> rmanArrgSummaryRepMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("dealArrangementNumber", "Revenue Contract Number");
		map.put("dealArrangementBasis", "Revenue Contract Basis");
		map.put("dealArrangementStatus", "Status");
		map.put("lastArrgModifiedDate", "Revenue Contract Modified Date");
		map.put("legalEntityName", "Legal Entity");
		map.put("dealArrangementSource", "Revenue Contract Source");
		map.put("salesContact", "Sales Rep");
		map.put("customerPoNum", "PO Number");
		map.put("bookingCurrency", "Transaction Currency");
		map.put("billToCustomer", "Bill To Customer Name");
		map.put("billToCustomerNumber", "Bill To Customer Number");
		map.put("salesTheater", "Sales Theater");
		map.put("salesRegion", "Sales Region");
		map.put("salesTerritory", "Sales Territory");
		map.put("bookedAmount", "Booked Amount (TC)");
		map.put("sspAmount", "Extended SSP Amount (TC)");
		map.put("allocationAmount", "Allocation Amount (TC)");
		map.put("carveInOutAmount", "Carve In/Carve Out Amount (TC)");
		map.put("deliveredAmount", "Delivered Amount (TC)");
		map.put("billedAmount", "Billed Amount (TC)");
		map.put("deliveredAllocationAmount", "Delivered Allocation Amount (TC)");
		map.put("postBillingDeferrals", "Post Billing Deferrals (TC)");
		map.put("postBillingAllocationAmount", "Post Billing Allocation Amount (TC)");
		map.put("revBegBal", "Revenue Beginning Balance (TC)");
		map.put("revCurrBal", "Revenue Current Balance (TC)");
		map.put("revEndBal", "Revenue Ending Balance (TC)");
		map.put("unamortizedAmount", "Unamortized Amount (TC)");
		map.put("allocationAmountFc", "Allocation Amount (FC)");
		map.put("deliveredAllocationAmountFc", "Delivered Allocation Amount (FC)");
		map.put("postBillingDeferralsFc", "Post Billing Deferrals (FC)");
		map.put("pbAllocationAmountFc", "Post Billing Allocation Amount (FC)");
		map.put("revBegBalFc", "Revenue Beginning Balance (FC)");
		map.put("revCurrBalFc", "Revenue Current Balance (FC)");
		map.put("revEndBalFc", "Revenue Ending Balance (FC)");
		map.put("unamortizedAmountFc", "Unamortized Amount (FC)");
		map.put("totalCostFc", "Total Cost (FC)");
		map.put("grossMarginFc", "Gross Margin (FC)");
		map.put("contractAsset", "Contract Asset (TC)");
		map.put("contractLiability", "Contract Liability (TC)");
		map.put("deferredRevenue", "Deferred Revenue (TC)");
		map.put("clearing", "Clearing (TC)");
		map.put("contractAssetFc", "Contract Asset (FC)");
		map.put("contractLiabilityFc", "Contract Liability (FC)");
		map.put("deferredRevenueFc", "Deferred Revenue (FC)");
		map.put("clearingFc", "Clearing (FC)");
		return Collections.unmodifiableMap(map);
	}

	private static Map<String, String> rmanTrxDetailReportMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("dealArrangementNumber", "Revenue Contract#");
		map.put("dealArrangementName", "Revenue Contract");
		map.put("note", "Note Transaction Type");
		map.put("contApply", "Cont Apply");
		map.put("elementType", "Element Type");
		map.put("customerNumber", "Customer#");
		map.put("customerName", "Customer");
		map.put("po", "PO#");
		map.put("orderNumber", "SO#");
		map.put("invoiceNumber", "Invoice#");
		map.put("deliveredDate", "Delivered Date");
		map.put("arrangementType", "Revenue Contract Type");
		map.put("salesTheater", "Sales Theater");
		map.put("region", "Sales Region");
		map.put("territory", "Sales Territory");
		map.put("dealNumber", "Deal#");
		map.put("dealLineNumber", "Deal Line#");
		map.put("salesrep", "Sales Rep");
		map.put("sourceHeaderId", "Source Header Id");
		map.put("sourceLineId", "Source Line Id");
		map.put("sourceLineNumber", "Source Line#");
		map.put("productName", "Product Name");
		map.put("lineStatus", "Line Status");
		map.put("orderedQuantity", "Booked Quantity");
		map.put("bookedCurrency", "Transaction Currency");
		map.put("bookedDate", "Booked Date");
		map.put("unitListPrice", "List $/U");
		map.put("unitSellingPrice", "Sell $/U");
		map.put("transactionPrice", "Line AMT$");
		map.put("discountPercent", "Discount%");
		map.put("productPorfolio", "Product Porfolio");
		map.put("productFamily", "Product Family");
		map.put("productLine", "Product Line");
		map.put("division", "Division");
		map.put("serviceStartDate", "Service Start Date");
		map.put("serviceEndDate", "Service End Date");
		map.put("sspMin", "SSP Min");
		map.put("sspMean", "SSP Mean");
		map.put("sspMax", "SSP Max");
		map.put("sspHigh", "SSP High");
		map.put("sspLow", "SSP Low");
		map.put("ssp", "SSP");
		map.put("fmvAmount", "SSP Total");
		map.put("fxRate", "Fx Rate");
		map.put("fxCurrency", "Fx Currency");
		map.put("fxDate", "Fx Date");
		map.put("allocationAmount", "Allocation Amount (TC)");
		map.put("allocationAmountFc", "Allocation Amount (FC)");
		map.put("shippedQty", "Shipped Qty");
		map.put("deliveredAmount", "Delivered Amount (TC)");
		map.put("invoiceLineNumber", "Invoice Line#");
		map.put("invoiceQuantity", "Invoice Qty");
		map.put("invoiceCurrency", "Invoice Currency");
		map.put("invoiceDate", "Invoice Date");
		map.put("billedAmount", "Billed Amt(TC)");
		map.put("billedAmountFc", "Billed Amount (FC)");
		map.put("deliveredAllocAmount", "Delivered Allocated Price (TC)");
		map.put("deliveredAllocAmountFc", "Delivered Allocated Price (FC)");
		map.put("cancelledQty", "Cancelled Qty");
		map.put("cancelledDate", "Cancelled Date");
		map.put("contractModifiedDate", "Contract Modified Date");
		map.put("deferredAmount", "Revenue Deferred(TC)");
		map.put("deferredAmountFc", "Revenue Deferred(FC)");
		map.put("contReleaseDate", "Contingency Release Date");
		map.put("contractAsset", "Contract Asset (TC)");
		map.put("contractLiability", "Contract Liability (TC)");
		map.put("deferredRevenue", "Deferred Revenue (TC)");
		map.put("clearing", "Clearing (TC)");
		map.put("contractAssetFc", "Contract Asset (FC)");
		map.put("contractLiabilityFc", "Contract Liability (FC)");
		map.put("deferredRevenueFc", "Deferred Revenue (FC)");
		map.put("clearingFc", "Clearing (FC)");
		map.put("beginBal", "Revenue Begin Balance (TC)");
		map.put("currBal", "Revenue Current Balance (TC)");
		map.put("endBal", "Revenue End Balance (TC)");
		map.put("beginBalFc", "Revenue Begin Balance (FC)");
		map.put("currBalFc", "Revenue Current Balance (FC)");
		map.put("endBalFc", "Revenue End Balance (FC)");
		map.put("quarterName", "Quarter Name");
		map.put("periodName", "Period Name");
		map.put("backlog", "Backlog");
		map.put("exceptionMessage", "Exception Message");

		return Collections.unmodifiableMap(map);
	}

	private static Map<String, String> rmanArrgWaterfallReportVMap() {
		Map<String, String> map = new LinkedHashMap<>();

		return Collections.unmodifiableMap(map);
	}

	private static Map<String, String> rmanDeferredRollForwardRepMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("dealArrangementNumber", "Revenue Contract#");
		map.put("dealArrangementName", "Revenue Contract");
		map.put("note", "Note Transaction Type");
		map.put("contName", "Cont Apply");
		map.put("elementType", "Element Type");
		map.put("billToCustomerNumber", "Customer#");
		map.put("billToCustomer", "Customer");
		map.put("customerPoNum", "PO#");
		map.put("orderNumber", "SO#");
		map.put("invoiceNum", "Invoice#");
		map.put("dealArrangementBasis", "Revenue Contract Basis");
		map.put("dealArrangementStatus", "Status");
		map.put("legalEntityName", "Legal Entity");
		map.put("dealArrangementSource", "Revenue Contract Source");
		map.put("dealName", "Deal Name");
		map.put("dealNumber", "Deal#");
		map.put("dealLineNumber", "Deal Line#");
		map.put("sourceHeaderId", "Source Header Id");
		map.put("sourceLineId", "Source Line Id");
		map.put("sourceLineNumber", "Source Line#");
		map.put("productName", "Product Name");
		map.put("orderedQuantity", "Ordered Quantity");
		map.put("uom", "UOM");
		map.put("transactionCurrency", "Currency");
		map.put("unitListPrice", "List $/U");
		map.put("unitNetPrice", "Sell $/U");
		map.put("lineAmount", "Line AMT$");
		map.put("discountPercent", "Discount%");
		map.put("productPortfolio", "Product Porfolio");
		map.put("productFamily", "Product Family");
		map.put("productLine", "Product Line");
		map.put("division", "Division");
		map.put("shipToCustomerNumber", "Ship To Customer#");
		map.put("shipToCustomer", "Ship To Customer");
		map.put("salesTheater", "Sales Theater");
		map.put("salesRegion", "Sales Region");
		map.put("salesTeritory", "Sales Territory");
		map.put("lineCost", "Line Cost");
		map.put("bundleAttributedList", "Bundle Attributed List");
		map.put("bundleAttributedNet", "Bundle Attributed Net");
		map.put("startDate", "Start Date");
		map.put("endDate", "End Date");
		map.put("deliveredDate", "Delivered Date");
		map.put("sspAmount", "SSP Amount");
		map.put("allocationAmount", "Allocation Amount (TC)");
		map.put("allocationAmountFc", "Allocation Amount (FC)");
		map.put("bookedAmount", "Booked Amount");
		map.put("deliveredAmount", "Delivered Amount");
		map.put("deliveredAllocationAmount", "Delivered Allocation Amount(TC)");
		map.put("deliveredAllocationAmountFc", "Delivered Allocation Amount(FC)");
		map.put("postBillingDeferrals", "Post Billing Deferrals (TC)");
		map.put("postBillingDeferralsFc", "Post Billing Deferrals (FC)");
		map.put("beginingBalance", "Beginning Bal (FC)");
		map.put("additionAmount", "Addition Amount (FC)");
		map.put("releaseAmount", "Release (FC)");
		map.put("endingBalance", "Ending Bal(FC)");
		map.put("revenueRecognized", "Revenue Recognized (FC)");
		return Collections.unmodifiableMap(map);
	}

	private static Map<String, String> rmanGlAccountingVMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("dealArrangementNumber", "Revenue Contract#");
		map.put("dealArrangementName", "Revenue Contract Name");
		map.put("accountClass", "Account Class");
		map.put("orderNumber", "SO#");
		map.put("sourceLineId", "Source Line Id");
		map.put("sourceLineNumber", "SO Line#");
		map.put("dealLineNumber", "Deal Line#");
		map.put("lineStatus", "Line Status");
		map.put("glDate", "GL Date");
		map.put("periodName", "Period");
		map.put("drCr", "Debit/Credit");
		map.put("account", "Account");
		map.put("accountDescription", "Account Description");
		map.put("currencyCode", "Transaction Currency");
		map.put("functionalCurrency", "Functional Currency");
		map.put("amountTc", "Amount in TC");
		map.put("amountFc", "Amount in FC");
		map.put("postedFlag", "Posted Flag");
		return Collections.unmodifiableMap(map);
	}

	private static Map<String, String> rmanReconDealsArggRepMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("arrangementNumber", "Revenue Contract#");
		map.put("arrangementLineNum", "Revenue Contract Line#");
		map.put("dealNumber", "Deal#");
		map.put("dealLineNumber", "Deal Line#");
		map.put("so", "SO#");
		map.put("sourceLineId", "Source Line Id");
		map.put("sourceLineNumber", "SO Line#");
		map.put("customerName", "Customer Name");
		map.put("creationDate", "Creation Date");
		map.put("arrangementStatus", "Revenue Contract Status");
		map.put("sku", "Product Name");
		map.put("srcQty", "Quantity (Source)");
		map.put("trgQty", "Quantity (Destination)");
		map.put("srcUnitPrice", "Unit Price (Source)");
		map.put("trgUnitPrice", "Unit Price (Destination)");
		map.put("srcAmount", "Amount (Source)");
		map.put("trgAmount", "Amount (Destination)");
		map.put("currency", "Currency");
		map.put("exception", "Exception");
		return Collections.unmodifiableMap(map);
	}

	private static Map<String, String> rmanReconSosrcToBkingsRepMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("arrangementNumber", "Linked Revenue Contract#");
		map.put("arrangementLineNum", "Linked Revenue Contract Line#");
		map.put("so", "SO#");
		map.put("sourceLineId", "Source Line Id");
		map.put("sourceLineNumber", "SO Line#");
		map.put("bookingEntityName", "Entity");
		map.put("bookedDate", "SO Booked Date");
		map.put("endCustomer", "Customer Name");
		map.put("sku", "Product Name");
		map.put("srcQty", "Quantity (Source)");
		map.put("trgQty", "Quantity (Destination)");
		map.put("srcUnitPrice", "Unit Price (Source)");
		map.put("trgUnitPrice", "Unit Price (Destination)");
		map.put("srcAmount", "Amount (Source)");
		map.put("trgAmount", "Amount (Destination)");
		map.put("exception", "Exception");
		return Collections.unmodifiableMap(map);
	}

	private static Map<String, String> rmanReconInvoiceRepMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("dealArrangementNumber", "Revenue Contract#");
		map.put("dealArrangementName", "Revenue Contract Name");
		map.put("dealArrangementBasis", "Revenue Contract Type");
		map.put("endCustomerName", "Customer Name");
		map.put("salesNodeLevel1", "Sales Theater");
		map.put("salesNodeLevel2", "Region");
		map.put("salesNodeLevel3", "Territory");
		map.put("dealNumber", "Deal#");
		map.put("dealLineNumber", "Deal Line#");
		map.put("productName", "Product Name");
		map.put("productDescription", "Product Description");
		map.put("itemType", "Item Type");
		map.put("customerPoNum", "PO#");
		map.put("orderNumber", "SO#");
		map.put("sourceLineId", "Source Line Id");
		map.put("sourceLineNumber", "SO Line #");
		map.put("orderedDate", "Ordered Date");
		map.put("orderedQuantity", "Ordered Quantity");
		map.put("actualFulfilledDate", "Shipped Date");
		map.put("shippedQuantity", "Shipped Quantity");
		map.put("repUnitListPrice", "UnitList Price");
		map.put("repUnitSellingPrice", "Rep Unit Selling Price");
		map.put("transactionPrice", "Transaction Price");
		map.put("invoiceNumber", "Invoice #");
		map.put("invoiceLineNumber", "Invoice Line #");
		map.put("invoicedDate", "Invoiced Date");
		map.put("invoicedQuantity", "Invoiced Quantity");
		map.put("invoiceCurrency", "Invoice Currency");
		map.put("acctdCurrency", "Accounted Currency");
		map.put("fxRate", "Fx Rate");
		map.put("fxDate", "Fx Date");
		map.put("revenueAmount", "Revenue Amount");
		map.put("acctdRevAmount", "Accounted Amount");
		return Collections.unmodifiableMap(map);
	}

	private static Map<String, String> rmanReconShippedSoTrgRepMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("arrangementName", "Revenue Contract Name");
		map.put("arrangementNumber", "Revenue Contract#");
		map.put("so", "SO #");
		map.put("sourceLineId", "Source Line Id");
		map.put("soLineNum", "SO Line#");
		map.put("entity", "Entity");
		map.put("deliveredDate", "Delivered Date");
		map.put("arrgLineNum", "Linked Revenue Contract Line #");
		map.put("sku", "Product Name");
		map.put("srcDeliveredQty", "Delivered Quantity (Source)");
		map.put("trgDeliveredQty", "Delivered Quantity (Destination)");
		map.put("eventReceived", "Event Received");
		map.put("revTriggerForSku", "Revenue Trigger as per SKU");
		map.put("exception", "Exception");
		return Collections.unmodifiableMap(map);
	}

	private static Map<String, String> rmanReconRevtrigRecogRepMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("arrangementName", "Revenue Contract Name");
		map.put("arrangementNumber", "Revenue Contract#");
		map.put("arrangementLineNumber", "Revenue Contract Line#");
		map.put("so", "SO #");
		map.put("sourceLineId", "Source Line Id");
		map.put("soLineNum", "SO Line#");
		map.put("skuRevTrigger", "Revenue Triggers (as per SKU)");
		map.put("eventReceived", "Event Received");
		map.put("actualFulfilledDate", "Delivered Date");
		map.put("deliveredAmt", "Delivered Amount");
		map.put("allocAmt", "Allocation Amount");
		map.put("deferredAmt", "Deferred Amount");
		map.put("provisionAmt", "Provision Amount");
		map.put("recogAmt", "Recognized Amount");
		map.put("currency", "Currency");
		map.put("exception", "Exception");
		return Collections.unmodifiableMap(map);
	}
	
	private static Map<String, String> quoteDocsMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("documentCategory", "DOCUMENT_CATEGORY");
		map.put("documentSource", "DOCUMENT_SOURCE");
		map.put("dealNumber", "DEAL_NUMBER");
		map.put("projectNumber", "PROJECT_NUMBER");
		map.put("opportunityNumber", "OPPORTUNITY_NUMBER");
		map.put("opportunityName", "OPPORTUNITY_NAME");
		map.put("documentNumber", "DOCUMENT_NUMBER");
		map.put("documentDescription", "DOCUMENT_DESCRIPTION");
		map.put("documentHeaderId", "DOCUMENT_HEADER_ID");
		map.put("entityName", "ENTITY_NAME");
		map.put("entityId", "ENTITY_ID");
		map.put("customerName", "CUSTOMER_NAME");
		map.put("customerNumber", "CUSTOMER_NUMBER");
		map.put("documentDate", "DOCUMENT_DATE");
		map.put("currencyCode", "CURRENCY_CODE");
		map.put("SalesRep", "SALES_REP");
		map.put("salesTheater", "SALES_THEATER");
		map.put("region", "REGION");
		map.put("salesTerritory", "SALES_TERRITORY");
		map.put("documentLineNumber", "DOCUMENT_LINE_NUMBER");
		map.put("documentLineId", "DOCUMENT_LINE_ID");
		map.put("productName", "PRODUCT_NAME");
		map.put("quantity", "QUANTITY");
		map.put("uom", "UOM");
		map.put("unitListPrice", "UNIT_LIST_PRICE");
		map.put("unitSellingPrice", "UNIT_SELLING_PRICE");
		map.put("parentLineNumber", "PARENT_LINE_NUMBER");
		map.put("serviceStartDate", "SERVICE_START_DATE");
		map.put("serviceEndDate", "SERVICE_END_DATE");
		map.put("unitCost", "UNIT_COST");
		map.put("contingnecyCode", "CONTINGNECY_CODE");
		map.put("contingnecyPercentage", "CONTINGNECY_PERCENTAGE");
		map.put("revenueTemplateName", "REVENUE_TEMPLATE_NAME");
		map.put("refDocumentNumber", "REF_DOCUMENT_NUMBER");
		map.put("exceptionMessage", "EXCEPTION_MESSAGE");
		return Collections.unmodifiableMap(map);
	}

	private static Map<String, String> bookingDocsMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("documentCategory", "DOCUMENT_CATEGORY");
		map.put("documentSource", "DOCUMENT_SOURCE");
		map.put("eventType", "EVENT_TYPE");
		map.put("dealNumber", "DEAL_NUMBER");
		map.put("projectNumber", "PROJECT_NUMBER");
		map.put("opportunityNumber", "OPPORTUNITY_NUMBER");
		map.put("customerPo", "CUSTOMER_PO");
		map.put("documentNumber", "DOCUMENT_NUMBER");
		map.put("documentHeaderId", "DOCUMENT_HEADER_ID");
		map.put("documentType", "DOCUMENT_TYPE");
		map.put("entityName", "ENTITY_NAME");
		map.put("entityId", "ENTITY_ID");
		map.put("customerName", "CUSTOMER_NAME");
		map.put("customerNumber", "CUSTOMER_NUMBER");
		map.put("documentDate", "DOCUMENT_DATE");
		map.put("documentStatus", "DOCUMENT_STATUS");
		map.put("currencyCode", "CURRENCY_CODE");
		map.put("SalesRep", "SALES_REP");
		map.put("salesTheater", "SALES_THEATER");
		map.put("region", "REGION");
		map.put("salesTerritory", "SALES_TERRITORY");
		map.put("documentLineId", "DOCUMENT_LINE_ID");
		map.put("documentLineNumber", "DOCUMENT_LINE_NUMBER");
		map.put("productName", "PRODUCT_NAME");
		map.put("inventoryItemId", "INVENTORY_ITEM_ID");
		map.put("quantity", "QUANTITY");
		map.put("uom", "UOM");
		map.put("unitListPrice", "UNIT_LIST_PRICE");
		map.put("unitSellingPrice", "UNIT_SELLING_PRICE");
		map.put("serviceStartDate", "SERVICE_START_DATE");
		map.put("serviceEndDate", "SERVICE_END_DATE");
		map.put("unitCost", "UNIT_COST");
		map.put("documentLineStatus", "DOCUMENT_LINE_STATUS");
		map.put("contingencyCode", "CONTINGNECY_CODE");
		map.put("contApplyType", "CONT_APPLY_TYPE");
		map.put("contingnecyPercentage", "CONTINGNECY_PERCENTAGE");
		map.put("revenueTemplateName", "REVENUE_TEMPLATE_NAME");
		map.put("refLineId", "REF_LINE_ID");
		map.put("refLineNumber", "REF_LINE_NUMBER");
		map.put("refDocumentNumber", "REF_DOCUMENT_NUMBER");
		map.put("parentLineId", "PARENT_LINE_ID");
		map.put("exceptionMessage", "EXCEPTION_MESSAGE");
		return Collections.unmodifiableMap(map);
	}
	
	private static Map<String, String> shipmentDocsMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("documentCategory", "DOCUMENT_CATEGORY");
		map.put("documentSource", "DOCUMENT_SOURCE");
		map.put("eventType", "EVENT_TYPE");
		map.put("documentLineId", "DOCUMENT_LINE_ID");
		map.put("quantity", "QUANTITY");
		map.put("documentLineStatus", "DOCUMENT_LINE_STATUS");
		map.put("documentDate", "DOCUMENT_DATE");
		map.put("contingencyCode", "CONTINGNECY_CODE");
		map.put("contApplyType", "CONT_APPLY_TYPE");
		map.put("contingnecyPercentage", "CONTINGNECY_PERCENTAGE");
		map.put("exceptionMessage", "EXCEPTION_MESSAGE");
		return Collections.unmodifiableMap(map);		
	}
	
	private static Map<String, String> vcDocsMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("documentCategory", "DOCUMENT_CATEGORY");
		map.put("documentSource", "DOCUMENT_SOURCE");
		map.put("eventType", "EVENT_TYPE");
		map.put("documentLineId", "DOCUMENT_LINE_ID");
		map.put("contingencyCode", "CONTINGNECY_CODE");
		map.put("contReleaseType", "CONT_RELEASE_TYPE");
		map.put("contReleaseRevenue", "CONT_RELEASE_REVENUE");
		map.put("exceptionMessage", "EXCEPTION_MESSAGE");
		return Collections.unmodifiableMap(map);		
	}
	
	private static Map<String, String> billingDocsMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("documentCategory", "DOCUMENT_CATEGORY");
		map.put("documentSource", "DOCUMENT_SOURCE");
		map.put("documentType", "DOCUMENT_TYPE");
		map.put("documentHeaderId", "DOCUMENT_HEADER_ID");
		map.put("documentNumber", "DOCUMENT_NUMBER");
		map.put("documentDate", "DOCUMENT_DATE");
		map.put("documentLineId", "DOCUMENT_LINE_ID");
		map.put("documentLineNumber", "DOCUMENT_LINE_NUMBER");
		map.put("quantity", "QUANTITY");
		map.put("unitSellingPrice", "UNIT_SELLING_PRICE");
		map.put("currencyCode", "CURRENCY_CODE");
		map.put("amount", "AMOUNT");
		map.put("refDocumentNumber", "REF_DOCUMENT_NUMBER");
		map.put("refLineNumber", "REF_LINE_NUMBER");
		map.put("refLineId", "REF_LINE_ID");
		map.put("exceptionMessage", "EXCEPTION_MESSAGE");
		return Collections.unmodifiableMap(map);
	}
	
	private static Map<String, String> pobMappingsMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("skuType", "Mapping Type");
		map.put("standaloneSubSku", "Product Name");
		map.put("pobGrouping", "POB Grouping");
		map.put("rmanLookupsV", "Split Basis");
		map.put("split", "Split");
		map.put("parentSku", "Parent Product");
		map.put("startDate", "Start Date");
		map.put("endDate", "End Date");
		map.put("status", "Status");
		map.put("legalEntityName", "Legal Entity");
		return Collections.unmodifiableMap(map);
	}
	
	private static Map<String, String> conversionRatesMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("fromCurrency", "From Currency");
		map.put("toCurrency", "To Currency");
		map.put("conversionType", "Conversion Type");
		map.put("conversionRate", "Conversion Rate");
		map.put("conversionDate", "Effective Date");
		map.put("conversionStartDate", "Start Date");
		map.put("conversionEndDate", "End Date");
		map.put("statusCode", "Status Code");
		return Collections.unmodifiableMap(map);
	}


}
