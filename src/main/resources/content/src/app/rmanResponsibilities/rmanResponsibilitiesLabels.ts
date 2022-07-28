interface ILabels {
    [index: string]: string;
}

export class RmanResponsibilitiesLabels {

    fieldLabels: ILabels;

    constructor() {

        this.fieldLabels = {};

        this.fieldLabels["attribute3"] = "Attribute3";
        this.fieldLabels["createdBy"] = "Created By";
        this.fieldLabels["attribute2"] = "Attribute2";
        this.fieldLabels["lastUpdatedBy"] = "Last Updated By";
        this.fieldLabels["startDateActive"] = "Start Date";
        this.fieldLabels["attribute1"] = "Attribute1";
        this.fieldLabels["creationDate"] = "Creation Date";
        this.fieldLabels["lastUpdateDate"] = "Last Update Date";
        this.fieldLabels["responsibilityId"] = "Responsibility Id";
        this.fieldLabels["responsibilityName"] = "Responsibility Name";
        this.fieldLabels["attribute5"] = "Attribute5";
        this.fieldLabels["attribute4"] = "Attribute4";
        this.fieldLabels["description"] = "Description";
        this.fieldLabels["endDateActive"] = "End Date";
        this.fieldLabels["enabledFlag"] = "Enabled Flag";
        this.fieldLabels["permissions"] = "Permissions";
        this.fieldLabels["assignPermissions"] = "Assign Permissions";
    }

}
