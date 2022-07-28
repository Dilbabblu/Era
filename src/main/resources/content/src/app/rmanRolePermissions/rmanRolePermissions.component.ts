import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Message } from 'primeng/api';
import { NotificationService } from '../shared/notifications.service';
import { RmanPermissionsService } from './rmanPermissionsService';

@Component({
  templateUrl: './rmanRolePermissions.component.html',
  providers: [RmanPermissionsService]
})
export class RmanRolePermissionsComponent implements OnInit {

  permTabHeaderHtml = "<div class='row'><div class='col-md-6'>Functions</div><div class='col-md-2 text-center'>Read</div><div class='col-md-2 text-center'>Write</div><div class='col-md-2 text-right'> Upload</div></div>";
  readPerm = 1;

  paginationOptions: any;
  showLoading: boolean = false;
  saveLoading: boolean = false;
  currentTab: any = 'rcManager';

  adminRoleFunctions: any[];
  rcManagerFunctions: any[];
  rcManagerOverviewFunctions: any[];
  sspRulesFunctions: any[];
  configManagerFunctions: any[];
  jobsFunctions: any[];
  exceptionsFunctions: any[];
  reportsFunctions: any[];
  approvalFunctions: any[];

  rmanRoleFunctions: any = new RmanRoleFunctionsImpl();
  rmanRoleFunctionsV: any = new RmanRoleFunctionsImpl();

  roleId: any;
  roleName: any;

  msgs: Message[] = [];
  

  isPermChanged = false;

  constructor(private rmanPermissionsService: RmanPermissionsService, private route: ActivatedRoute,
    private notificationService: NotificationService) {
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.route.params.subscribe(params => {
      this.roleId = params['role'];
      this.roleName = params['name'];
    });
    this.getAllRmanFunctions(this.roleId);
  }

  ngOnInit() {
  }

  getAllRmanFunctions(role) {
    this.showLoading = true;
    this.rmanPermissionsService.getAllPermissionFunctions(this.paginationOptions, role).then((rmanFunctionsList: any) => {
      this.showLoading = false;
      this.rmanRoleFunctions = rmanFunctionsList.content;
      this.rmanRoleFunctionsV = this.rmanRoleFunctions;
      this.transformRoleFunctions(this.rmanRoleFunctionsV);
      this.prepareModuleBasedObjects(this.rmanRoleFunctionsV);

    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting  data');
    });
  }


  prepareModuleBasedObjects(rmanRoleFunctionsV) {
    this.adminRoleFunctions = rmanRoleFunctionsV.filter(i => i.rmanFunctions.module == 'Admin');
    this.configManagerFunctions = rmanRoleFunctionsV.filter(i => i.rmanFunctions.module == 'Configuration Manager');
    this.sspRulesFunctions = rmanRoleFunctionsV.filter(i => i.rmanFunctions.module == 'SSP Rules');
    this.rcManagerFunctions = rmanRoleFunctionsV.filter(i => i.rmanFunctions.module == 'Revenue Contract Manager');
    this.rcManagerOverviewFunctions = rmanRoleFunctionsV.filter(i => i.rmanFunctions.module == 'Revenue Contract Details');
    this.jobsFunctions = rmanRoleFunctionsV.filter(i => i.rmanFunctions.module == 'Jobs');
    this.exceptionsFunctions = rmanRoleFunctionsV.filter(i => i.rmanFunctions.module == 'Exceptions');
    this.approvalFunctions =  rmanRoleFunctionsV.filter(i => i.rmanFunctions.module == 'Approvals');
    this.reportsFunctions = rmanRoleFunctionsV.filter(i => i.rmanFunctions.module == 'Reports');
  }

  onTabChange(tab) {
    this.currentTab = tab;
  }

  save() {
    if (this.currentTab == 'rcManager') {
      this.updateRolePermissions(this.rcManagerFunctions);
    } else if (this.currentTab == 'rcManagerOverview') {
      this.updateRolePermissions(this.rcManagerOverviewFunctions);
    } else if (this.currentTab == 'ssp') {
      this.updateRolePermissions(this.sspRulesFunctions);
    } else if (this.currentTab == 'configManager') {
      this.updateRolePermissions(this.configManagerFunctions);
    } else if (this.currentTab == 'admin') {
      this.updateRolePermissions(this.adminRoleFunctions);
    } else if (this.currentTab == 'jobs') {
      this.updateRolePermissions(this.jobsFunctions);
    } else if (this.currentTab == 'reports') {
      this.updateRolePermissions(this.reportsFunctions);
    } else if (this.currentTab == 'exceptions') {
      this.updateRolePermissions(this.exceptionsFunctions);
    }else if (this.currentTab == 'approvals') {
      this.updateRolePermissions(this.approvalFunctions);
    }

  }

  updateRolePermissions(roleFunctions: any) {
    this.transformRoleFunctionsV(roleFunctions);
    this.saveLoading = true;
    this.rmanPermissionsService.updateRmanRolePermissions(roleFunctions).then((response: any) => {
      this.saveLoading = false;
      this.notificationService.showSuccess('Permissions Updated Successfully');
    }).catch((err: any) => {
      this.saveLoading = false;
      this.notificationService.showError('Permissions Updated Failed');
    });
  }

  transformRoleFunctions(roleFunctions) {
    for (let roleFunction of roleFunctions) {
      roleFunction.read == 1 ? roleFunction.read = true : roleFunction.read = false;
      roleFunction.write == 1 ? roleFunction.write = true : roleFunction.write = false;
      roleFunction.upload == 1 ? roleFunction.upload = true : roleFunction.upload = false;
    }
  }

  transformRoleFunctionsV(roleFunctions) {
    for (let roleFunction of roleFunctions) {
      roleFunction.read ? roleFunction.read = 1 : roleFunction.read = 0;
      roleFunction.write ? roleFunction.write = 1 : roleFunction.write = 0;
      roleFunction.upload ? roleFunction.upload = 1 : roleFunction.upload = 0;
    }
  }

  onReadPermChange(roleFunc) {
    if (!roleFunc.read) {
      roleFunc.write = false;
      roleFunc.upload = false;
    }
    this.isPermChanged = true;
  }

  onWriteUploadPermChange(roleFunc) {
    if (roleFunc.write || roleFunc.upload) {
      roleFunc.read = true;
    }
    if (!roleFunc.write && !roleFunc.upload) {
      roleFunc.read = false;
      roleFunc.write = false;
      roleFunc.upload = false;
    }
    this.isPermChanged = true;
  }

  discard() {
    this.adminRoleFunctions = []
    this.rcManagerFunctions = [];
    this.rcManagerOverviewFunctions = [];
    this.sspRulesFunctions = [];
    this.configManagerFunctions = [];
    this.jobsFunctions = [];
    this.exceptionsFunctions = [];
    this.reportsFunctions = [];
    this.approvalFunctions = [];

    this.rmanRoleFunctions = new RmanRoleFunctionsImpl();
    this.rmanRoleFunctionsV = new RmanRoleFunctionsImpl();

    this.isPermChanged = false;

    this.getAllRmanFunctions(this.roleId);
  }

}

class RmanRoleFunctionsImpl {
  constructor(
    public read?: any,
    public upload?: any,
    public write?: any,
    public rfid?: any,
    public roleid?: any,
    public functionId?: any,
    public rmanFunctions?: RmanFunctionsImpl,
    public enabledFlag?: any,
    public startDateActive?: any,
    public endDateActive?: any,
    public createdBy?: any,
    public creationDate?: any,
    public lastUpdatedBy?: any,
    public lastUpdateDate?: any,
    public createdUser?: any,
    public updatedUser?: any) { }
}

class RmanFunctionsImpl {
  constructor(
    public fid?: any,
    public module?: any,
    public fcode?: any,
    public url?: any,
    public name?: any,
    public enabledFlag?: any,
    public createdBy?: any,
    public creationDate?: any,
    public lastUpdatedBy?: any,
    public lastUpdateDate?: any,
    public createdUser?: any,
    public updatedUser?: any,
    public fType?: any) { }
}

interface ILabels {
  [index: string]: string;
}
