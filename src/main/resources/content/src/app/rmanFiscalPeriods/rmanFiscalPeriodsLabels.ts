interface ILabels {
    [index: string]: string;
}

export class RmanFiscalPeriodsLabels {

    fieldLabels: ILabels;

    constructor() {

        this.fieldLabels = {};

        this.fieldLabels["quarterStartDate"] = "Quarter Start Date";
        this.fieldLabels["createdBy"] = "Created By";
        this.fieldLabels["lastUpdatedBy"] = "Last Updated By";
        this.fieldLabels["periodYear"] = "Period Year";
        this.fieldLabels["adjustmentPeriodFlag"] = "Adjustment Period Flag";
        this.fieldLabels["creationDate"] = "Creation Date";
        this.fieldLabels["endDate"] = "End Date";
        this.fieldLabels["startDate"] = "Start Date";
        this.fieldLabels["quarterNum"] = "Quarter Num";
        this.fieldLabels["sourcePeriodId"] = "Source Period Id";
        this.fieldLabels["lastUpdateDate"] = "Last Update Date";
        this.fieldLabels["periodNum"] = "Period Num";
        this.fieldLabels["ledgerName"] = "Ledger Name";
        this.fieldLabels["quarterName"] = "Quarter Name";
        this.fieldLabels["periodName"] = "Period Name";
        this.fieldLabels["enteredPeriodName"] = "Entered Period Name";
        this.fieldLabels["periodStatus"] = "Period Status";
        this.fieldLabels["yearStartDate"] = "Year Start Date";
        this.fieldLabels["rmanPeriodId"] = "Rman Period Id";
        this.fieldLabels["openFlag"] = "Open Flag";
    }

}
