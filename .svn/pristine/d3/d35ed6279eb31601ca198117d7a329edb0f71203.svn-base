import { Directive, Input, TemplateRef, ViewContainerRef } from '@angular/core';
import { CommonSharedService } from '../shared/common.service';

@Directive({
  selector: '[isAuthorized]'
})
export class IsAuthorizedDirective {

  private permissionType: any;
  isHidden: boolean = true;
  fCode: any;
  module: any;
  fType: any;

  allPermissons: any[] = [];
  role: any;
  primeRoles = ['REVADMIN'];

  constructor(private templateRef: TemplateRef<any>, private viewContainer: ViewContainerRef,
    private sharedService: CommonSharedService) {
    this.allPermissons = sharedService.allPermissions;
    this.role = sharedService.roleList;
  }

  @Input()
  set isAuthorized(permModule) {
    this.permissionType = permModule[0];
    this.fCode = permModule[1];
    if (permModule.length > 3) {
      this.fType = permModule[3];
    }
    if (permModule.length > 2) {
      this.module = permModule[2];
    }
    this.updateView();
  }

  updateView() {
    if (this.checkPermission() && this.isHidden) {
      this.viewContainer.createEmbeddedView(this.templateRef);
      this.isHidden = false;
    } else {
      this.isHidden = true;
      this.viewContainer.clear();
    }
  }

  private checkPermission() {
   // return true;
    let isAuthorized: boolean = true;
    if (this.role.includes(...this.primeRoles)) {
      return isAuthorized;
    }
    if (this.fType) {
      return this.checkReportRecursiveMenuPermissions();
    } else if (this.module) {
      return this.checkParentMenuPermissions();
    } else {
      if (this.allPermissons.length > 0) {
        for (let permission of this.allPermissons) {
          if (permission.rmanFunctions.fcode == this.fCode) {
            if (this.permissionType == PermissionType.READ) {
              if (permission.read == 1) {
                return isAuthorized;
              }
            } else if (this.permissionType == PermissionType.WRITE) {
              if (permission.write == 1) {
                return isAuthorized;
              }
            } else if (this.permissionType == PermissionType.UPLOAD) {
              if (permission.upload == 1) {
                return isAuthorized;
              }
            }
          }
        }
      }
    }
    return false;
  }
  private checkParentMenuPermissions() {
    if (this.allPermissons.length > 0) {
      for (let permission of this.allPermissons) {
        if (permission.rmanFunctions.module == this.module) {
          if (permission.read == 1) {
            return true;
          }
        }
      }
    }
  }
  private checkReportRecursiveMenuPermissions() {
    if (this.allPermissons.length > 0) {
      for (let permission of this.allPermissons) {
        if (permission.rmanFunctions.fType == this.fType) {
          if (permission.read == 1) {
            return true;
          }
        }
      }
    }
  }

}

export enum PermissionType {
  READ = 'read',
  WRITE = 'write',
  UPLOAD = 'upload'
}
