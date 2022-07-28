interface ILabels {
    [index: string]: string;
}

export class RmanPermissionsLabels {

    fieldLabels: ILabels;

    constructor() {

        this.fieldLabels = {};

        this.fieldLabels["functionName"] = "Function Name";
        this.fieldLabels["read"] = "Read";
        this.fieldLabels["write"] = "Write";
        this.fieldLabels["upload"] = "Upload";
        this.fieldLabels["enabledFlag"] = "Enabled Flag";
        this.fieldLabels["startDateActive"] = "Start Date";
        this.fieldLabels["endDateActive"] = "End Date";
    }

}
