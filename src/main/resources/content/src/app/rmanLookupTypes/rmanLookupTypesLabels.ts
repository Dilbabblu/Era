interface ILabels {
    [index: string]: string;
}

export class RmanLookupTypesLabels {

    fieldLabels: ILabels;

    constructor() {

        this.fieldLabels = {};

        this.fieldLabels["attribute3"] = "ATTRIBUTE3";
        this.fieldLabels["createdBy"] = "Created By";
        this.fieldLabels["attribute2"] = "ATTRIBUTE2";
        this.fieldLabels["lastUpdatedBy"] = "Last Updated By";
        this.fieldLabels["startDateActive"] = "Start Date";
        this.fieldLabels["attribute1"] = "ATTRIBUTE1";
        this.fieldLabels["creationDate"] = "Creation Date";
        this.fieldLabels["meaning"] = "Lookup Name";
        this.fieldLabels["enabledFlag"] = "Enabled Flag";
        this.fieldLabels["lastUpdateDate"] = "Last Updated Date";
        this.fieldLabels["attribute5"] = "ATTRIBUTE5";
        this.fieldLabels["attribute4"] = "ATTRIBUTE4";
        this.fieldLabels["lookupTypeName"] = "Lookup Type";
        this.fieldLabels["description"] = "Description";
        this.fieldLabels["endDateActive"] = "End Date";
        this.fieldLabels["seededFlag"] = "Seed Data";
    }

}
