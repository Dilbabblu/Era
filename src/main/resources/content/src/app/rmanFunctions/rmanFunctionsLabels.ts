interface ILabels {
    [index: string]: string;
}

export class RmanFunctionsLabels {

    fieldLabels: ILabels;

    constructor() {

        this.fieldLabels = {};

        this.fieldLabels["fid"] = "Function Id";
        this.fieldLabels["module"] = "Module";
        this.fieldLabels["fcode"] = "Function Code";
        this.fieldLabels["enabledFlag"] = "Enabled Flag";
        this.fieldLabels["url"] = "URL";
        this.fieldLabels["name"] = "Function Name";
    }

}
