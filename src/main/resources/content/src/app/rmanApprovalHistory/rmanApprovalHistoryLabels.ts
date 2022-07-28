interface ILabels {
    [index: string]: string;
}

export class RmanApprovalHistoryLabels {

    fieldLabels: ILabels;

    constructor() {

        this.fieldLabels = {};

        this.fieldLabels["approvalStatus"] = "Approval Status";
        this.fieldLabels["actionBy"] = "Action By";
        this.fieldLabels["actionDate"] = "Action Date";
        this.fieldLabels["comments"] = "Comments";
    }

}
