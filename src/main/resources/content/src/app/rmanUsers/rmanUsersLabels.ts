interface ILabels {
  [index: string]: string;
}

export class RmanUsersLabels {

  fieldLabels: ILabels;

  constructor() {

    this.fieldLabels = {};

    this.fieldLabels["attribute3"] = "Attribute3";
    this.fieldLabels["createdBy"] = "Created By";
    this.fieldLabels["attribute2"] = "Attribute2";
    this.fieldLabels["lastUpdatedBy"] = "Last Updated By";
    this.fieldLabels["startDateActive"] = "Start Date";
    this.fieldLabels["attribute1"] = "Legal Entity";
    this.fieldLabels["rmanEmployeeId"] = "Employee ID";
    this.fieldLabels["creationDate"] = "Creation Date";
    this.fieldLabels["userName"] = "User Name";
    this.fieldLabels["lastName"] = "Last Name";
    this.fieldLabels["lastUpdateDate"] = "Last Update Date";
    this.fieldLabels["workPhone"] = "Work Phone";
    this.fieldLabels["firstName"] = "First Name";
    this.fieldLabels["attribute5"] = "Attribute5";
    this.fieldLabels["attribute4"] = "Attribute4";
    this.fieldLabels["cellPhone"] = "Cell Phone";
    this.fieldLabels["emailAddress"] = "Email Address";
    this.fieldLabels["userPassword"] = "User Password";
    this.fieldLabels["mgrId"] = "Manger";
    this.fieldLabels["fullName"] = "Full Name";
    this.fieldLabels["homePhone"] = "Home Phone";
    this.fieldLabels["endDateActive"] = "End Date";
    this.fieldLabels["rmanUserId"] = "Rman User Id";
    this.fieldLabels["enabledFlag"] = "Enabled Flag";
  }

}
