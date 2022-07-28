interface ILabels {
    [index: string]: string;
}

export class RmanContTemplateLabels {

    fieldLabels: ILabels;

    constructor() {

        this.fieldLabels = {};

        this.fieldLabels["attribute10"] = "Attribute10";
        this.fieldLabels["invoiceHold"] = "Invoice Hold";
        this.fieldLabels["attribute14"] = "Attribute14";
        this.fieldLabels["attribute13"] = "Attribute13";
        this.fieldLabels["attribute12"] = "Attribute12";
        this.fieldLabels["cogs"] = "Cogs";
        this.fieldLabels["attribute11"] = "Attribute11";
        this.fieldLabels["applyType"] = "Apply Type";
        this.fieldLabels["lastUpdateDate"] = "Last Update Date";
        this.fieldLabels["templateId"] = "Template Id";
        this.fieldLabels["description"] = "Description";
        this.fieldLabels["effectiveEndDate"] = "Effective End Date";
        this.fieldLabels["attribute3"] = "Attribute3";
        this.fieldLabels["createdBy"] = "Created By";
        this.fieldLabels["attribute2"] = "Attribute2";
        this.fieldLabels["lastUpdatedBy"] = "Last Updated By";
        this.fieldLabels["attribute1"] = "Attribute1";
        this.fieldLabels["revenue"] = "Revenue";
        this.fieldLabels["creationDate"] = "Creation Date";
        this.fieldLabels["attribute9"] = "Attribute9";
        this.fieldLabels["attribute8"] = "Attribute8";
        this.fieldLabels["attribute7"] = "Attribute7";
        this.fieldLabels["attribute6"] = "Attribute6";
        this.fieldLabels["defaultDays"] = "Default Days";
        this.fieldLabels["attribute5"] = "Attribute5";
        this.fieldLabels["attribute4"] = "Attribute4";
        this.fieldLabels["effectiveStartDate"] = "Effective Start Date";
        this.fieldLabels["templateName"] = "Template Name";
        this.fieldLabels["attribute15"] = "Attribute15";
    }

}
