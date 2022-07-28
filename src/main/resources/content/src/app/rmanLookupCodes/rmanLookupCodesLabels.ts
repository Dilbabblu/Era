interface ILabels {
    [index: string]: string;
}

export class RmanLookupCodesLabels {

    fieldLabels: ILabels;

    constructor() {

        this.fieldLabels = {};

        this.fieldLabels["attribute3"] = "ATTRIBUTE3";
        this.fieldLabels["createdBy"] = "Created By";
        this.fieldLabels["attribute2"] = "ATTRIBUTE2";
        this.fieldLabels["lastUpdatedBy"] = "Last Updated By";
        this.fieldLabels["startDateActive"] = "Start Date";
        this.fieldLabels["attribute1"] = "ATTRIBUTE1";
        this.fieldLabels["lookupCode"] = "Lookup Code";
        this.fieldLabels["creationDate"] = "CREATION DATE";
        this.fieldLabels["enabledFlag"] = "Enabled Flag";
        this.fieldLabels["lastUpdateDate"] = "Last Update Date";
        this.fieldLabels["attribute5"] = "ATTRIBUTE5";
        this.fieldLabels["attribute4"] = "ATTRIBUTE4";
        this.fieldLabels["description"] = "Description";
        this.fieldLabels["lookupTypeCode"] = "Lookup Type Code";
        this.fieldLabels["endDateActive"] = "End Date";
        this.fieldLabels["seededFlag"] = "Seed Data";
    }

}
