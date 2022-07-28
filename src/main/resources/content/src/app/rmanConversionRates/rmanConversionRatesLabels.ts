interface ILabels {
    [index: string]: string;
}

export class RmanConversionRatesLabels {

    fieldLabels: ILabels;

    constructor() {

        this.fieldLabels = {};
        this.fieldLabels["attribute10"] = "Attribute10";
        this.fieldLabels["conversionStartDate"] = "Start Date";
        this.fieldLabels["attribute14"] = "Attribute14";
        this.fieldLabels["attribute13"] = "Attribute13";
        this.fieldLabels["createdDate"] = "Created Date";
        this.fieldLabels["attribute12"] = "Attribute12";
        this.fieldLabels["attribute11"] = "Attribute11";
        this.fieldLabels["conversionType"] = "Conversion Type";
        this.fieldLabels["toCurrency"] = "To Currency";
        this.fieldLabels["attribute3"] = "Attribute3";
        this.fieldLabels["createdBy"] = "Created By";
        this.fieldLabels["attribute2"] = "Attribute2";
        this.fieldLabels["lastUpdatedBy"] = "Last Updated By";
        this.fieldLabels["attribute1"] = "Status";
        this.fieldLabels["conversionRate"] = "Conversion Rate";
        this.fieldLabels["attribute9"] = "Attribute9";
        this.fieldLabels["attribute8"] = "Attribute8";
        this.fieldLabels["attribute7"] = "Attribute7";
        this.fieldLabels["attribute6"] = "Attribute6";
        this.fieldLabels["attribute5"] = "Attribute5";
        this.fieldLabels["attribute4"] = "Attribute4";
        this.fieldLabels["lastUpdatedDate"] = "Last Updated Date";
        this.fieldLabels["fromCurrency"] = "From Currency";
        this.fieldLabels["attribute15"] = "Attribute15";
        this.fieldLabels["conversionEndDate"] = "End Date";
        this.fieldLabels["conversionDate"] = "Efftective Date";
        this.fieldLabels["statusCode"] = "Status Code";
    }

}
